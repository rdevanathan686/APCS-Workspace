import java.util.ArrayList;

public class NetFlixPredictor
{

    // Add fields to represent your database.
    private ArrayList<Movie> movieData;
    private ArrayList<User> userData;

    /**
     * 
     * Use the file names to read all data into some local structures.
     * 
     * @param movieFilePath
     *            The full path to the movies database.
     * @param ratingFilePath
     *            The full path to the ratings database.
     * @param tagFilePath
     *            The full path to the tags database.
     * @param linkFilePath
     *            The full path to the links database.
     */
    public NetFlixPredictor(String movieFilePath, String ratingsFilePath, String tagFilePath, String linkFilePath)
    {
        // Testing movies
        movieData = new ArrayList<Movie>();
        userData = new ArrayList<User>();

        ArrayList<String> movieStringData = FileIO.readFile(movieFilePath);
        ArrayList<String> linkStringData = FileIO.readFile(linkFilePath);
        ArrayList<String> ratingStringData = FileIO.readFile(ratingsFilePath);
        ArrayList<String> tagStringData = FileIO.readFile(tagFilePath);

        MovieLensCSVTranslator translator = new MovieLensCSVTranslator();

        for (int i = 1; i < movieStringData.size(); i++)
        {
            Movie m = translator.parseMovie(movieStringData.get(i));
            translator.parseLinks(m, linkStringData.get(i));
            movieData.add(m);
        }

        int queueId = Integer.parseInt(tagStringData.get(1).substring(0, tagStringData.get(1).indexOf(","))); // 15
        int queuedIndex = 1;
        
        for (int i = 1; i < ratingStringData.size(); i++)
        {
            User user = null;
            if (userData.size() == 0)
                user = translator.parseUser(ratingStringData.get(i), null);
            else
                user = translator.parseUser(ratingStringData.get(i), userData.get(userData.size() - 1));
            
            
            
            if (user != null)
                translator.assignRating(ratingStringData.get(i), user, movieData);
            else
                translator.assignRating(ratingStringData.get(i), userData.get(userData.size() - 1), movieData);

            if (user != null && user.getUserId() == queueId)
            {
                
                for (int j = queuedIndex; j < tagStringData.size(); j++)
                {
                    int assignedId = translator.assignTag(tagStringData.get(j), user, movieData);
                    
                    if (assignedId != queueId)
                    {
                        queueId = assignedId;
                        queuedIndex = j;
                        break;
                    }
                        
                }
                    
            }   
            
            if (user != null)
                userData.add(user);
        }
           
        
    }

    /**
     * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
     * 
     * @param userNumber
     *            The ID of the user.
     * @param movieNumber
     *            The ID of the movie.
     * @return The rating that userNumber gave movieNumber, or -1 if the user does
     *         not exist in the database, the movie does not exist, or the movie has
     *         not been rated by this user.
     */
    public double getRating(int userID, int movieID)
    {
        for (User user: userData)
            if (user.getUserId() == userID)
                for (Rating rating : user.getRatings())
                    if (rating.getMovie().getMovieId() == movieID)
                        return rating.getRating();
                
        return -1;
    }

    /**
     * If userNumber has rated movieNumber, return the rating. Otherwise, use other
     * available data to guess what this user would rate the movie.
     * 
     * @param userNumber
     *            The ID of the user.
     * @param movieNumber
     *            The ID of the movie.
     * @return The rating that userNumber gave movieNumber, or the best guess if the
     *         movie has not been rated by this user.
     * @pre A user with id userID and a movie with id movieID exist in the database.
     */
    public double guessRating(int userID, int movieID)
    {
        double r = getRating(userID, movieID);
        
        if (r != -1)
            return r;
        
        User user = null;
        Movie movie = null;
        
        // Find user and movie objects in the database 
        for (User u : userData)
        {
            if (userID == u.getUserId())
            {
                user = u;
                break;
            }
        }
        
        for (Movie m : movieData)
        {
            if (movieID == m.getMovieId())
            {
                movie = m;
                break;
            }
        }
        
        double ratingGuess = 0;
        int match = 0;
        
        // if the user has rated something 
        // of the similar genre, add it to the avg genre rating for the specific genre
        for (Rating rating : user.getRatings())
        {
            for (String genre : rating.getMovie().getGenres())
            {
                for (String genreMovie : movie.getGenres())
                {
                    if (genre.equals(genreMovie))
                    {
                        ratingGuess += rating.getMovie().getAvgRating();
                        match++;
                    }
                }

                
            }
        }
        
        if (match == 0)
            return movie.getAvgRating();
        
        // Avg user bias?
        double userBias = (user.getAvgRating() - movie.getAvgRating()) / ((user.getRatings().size()) / 50.);
        System.out.println(userBias);
        
        return (ratingGuess / match) + userBias;
    }

    /**
     * Recommend a movie that you think this user would enjoy (but they have not
     * currently rated it).
     * 
     * @param userNumber
     *            The ID of the user.
     * @return The ID of a movie that data suggests this user would rate highly (but
     *         they haven't rated it currently).
     * @pre A user with id userID exists in the database.
     */
    public int recommendMovie(int userID)
    {

        return 0;
    }

}
