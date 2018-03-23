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

        for (int i = 1; i < ratingStringData.size(); i++)
        {
            User user = translator.parseUser(ratingStringData.get(i), userData);
            
            if (user != null)
            
                userData.add(user);
            
               
        }
            
        
        for (User u : userData)
        {
            for (int j = 1; j < ratingStringData.size(); j++)
                translator.assignRating(ratingStringData.get(j), u, movieData);
            
            for (int j = 1; j < tagStringData.size(); j++)
                translator.assignTag(tagStringData.get(j), u, movieData);
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
        double ratingValue = -1;
        for (User user: userData)
        {
            if (user.getUserId() == userID)
            {
                for (Rating rating : user.getRatings())
                {
                    if (rating.getMovie().getMovieId() == movieID)
                        ratingValue = rating.getRating();
                }
            }
        }
        
        return ratingValue;
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
        
          
        
        
        return 0;
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
