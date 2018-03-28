import java.util.ArrayList;
import java.util.Collections;

public class NetFlixPredictor
{

    // Add fields to represent your database.
    private ArrayList<Movie> movieData;
    private ArrayList<User> userData;
    
    //TODO more than one prediction per user

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

        Collections.sort(movieData);

        int queuedId = Integer.parseInt(tagStringData.get(1).substring(0, tagStringData.get(1).indexOf(","))); // 15
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

            if (user != null && user.getUserId() == queuedId)
            {

                for (int j = queuedIndex; j < tagStringData.size(); j++)
                {
                    int assignedId = translator.assignTag(tagStringData.get(j), user, movieData);

                    if (assignedId != queuedId)
                    {
                        queuedId = assignedId;
                        queuedIndex = j;
                        break;
                    }

                }

            }

            if (user != null)
                userData.add(user);
        }
        
        Collections.sort(userData);
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
        int userIndex = Collections.binarySearch(userData, new User(userID));
        
        if (userIndex < 0)
            return -1;
        
        User user = userData.get(userIndex);
        
        Collections.sort(user.getRatings());
        int ratingIndex = Collections.binarySearch(user.getRatings(), new Rating(new User(userID), new Movie(movieID)));
        
        if (ratingIndex < 0)
            return -1;
        
        return user.getRatings().get(ratingIndex).getRating();
        
//        for (Rating rating : user.getRatings())
//            if (rating.getMovie().getMovieId() == movieID)
//                return rating.getRating();
//
//        return -1;
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



        // Find user and movie objects in the database
//
//        for (User u : userData)
//        {
//            if (userID == u.getUserId())
//            {
//                user = u;
//                break;
//            }
//        }

        Movie movie = movieData.get(Collections.binarySearch(movieData, new Movie(movieID)));
        User user = userData.get(Collections.binarySearch(userData, new User(userID)));

        /*
         * for (Movie m : movieData) { if (movieID == m.getMovieId()) { movie = m;
         * break; } }
         */

        // double baseline = 0;
        //
        // for (User u : userData)
        // {
        // baseline += u.getAvgRating();
        // }
        //
        // baseline /= userData.size();
        //
        // double ratingGuess = 0;
        // int match = 0;
        //
        // // if the user has rated something
        // // of the similar genre, add it to the avg genre rating for the specific
        // genre
        // for (Rating rating : user.getRatings())
        // {
        // for (String genre : rating.getMovie().getGenres())
        // {
        // for (String genreMovie : movie.getGenres())
        // {
        // if (genre.equals(genreMovie))
        // {
        // ratingGuess += rating.getMovie().getAvgRating();
        // match++;
        // }
        // }
        //
        //
        // }
        // }

        // for (User u : userData)
        // {
        // double simil = similiarity(user, u);
        // if (simil > 0)
        // {
        // U.add(u);
        // sim.add(simil);
        // }
        // }

        double rating = 0;
        double index = 0;
        for (Rating k : movie.getRating())
        {
            double sim = similarity(k.getUser(), user);
            rating += sim * (k.getRating() - k.getUser().getAvgRating());
            index += Math.abs(sim);

        }

        if (index != 0)
            index = 1 / index;

        System.out.println((index * rating) + user.getAvgRating());

        // if (match == 0)
        // return movie.getAvgRating();
        //
        // // Avg user bias?
        // double userBias = (baseline - user.getAvgRating());
        // System.out.println(userBias);
        //
        // return (ratingGuess / match) - userBias;

        return (index * rating) + user.getAvgRating();
    }

    private double similarity(User i, User j)
    {
        double sim = 0;
        double iSim = 0;
        double jSim = 0;

        // Cosine similarity
        // for (Rating a : i.getRatings())
        // {
        // for (Rating b : j.getRatings())
        // {
        // if (a.getMovie().getMovieId() == b.getMovie().getMovieId())
        // sim += (a.getRating()) * (b.getRating());
        //
        // jSim += (b.getRating()) * b.getRating();
        // }
        //
        // iSim += (a.getRating()) * a.getRating();
        // }
        
        
        ArrayList<Rating> smaller = j.getRatings();
        ArrayList<Rating> bigger = i.getRatings();
        
        if (j.getRatings().size() > i.getRatings().size())
        {
            smaller = i.getRatings();
            bigger = j.getRatings();
        }
        
        for (Rating a : smaller)
        {
            int indexFound = Collections.binarySearch(bigger, a);
            
            if (indexFound >= 0)
            {
                Rating b = bigger.get(indexFound);
                jSim += (b.getRating() - j.getAvgRating()) * (b.getRating() - j.getAvgRating());
                iSim += (a.getRating() - i.getAvgRating()) * (a.getRating() - i.getAvgRating());
                sim += (a.getRating() - i.getAvgRating()) * (b.getRating() - j.getAvgRating());
            }
                
//            for (Rating b : j.getRatings())
//            {
//                if (a.getMovie().getMovieId() == b.getMovie().getMovieId())
//                {
//                    
//                }
//
//            }

        }

        if (sim == 0)
            return 0;

        return (sim) / ((Math.sqrt(iSim)) * (Math.sqrt(jSim)));
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
