import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class NetFlixPredictor
{

    // Add fields to represent your database.
    private ArrayList<Movie> movieData;
    private ArrayList<User> userData;

    // TODO more than one prediction per user

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

        Movie movie = movieData.get(Collections.binarySearch(movieData, new Movie(movieID)));
        User user = userData.get(Collections.binarySearch(userData, new User(userID)));

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
        // if (match == 0)
        // return movie.getAvgRating();
        //
        // // Avg user bias?
        // double userBias = (baseline - user.getAvgRating());
        // System.out.println(userBias);
        //
        // return (ratingGuess / match) - userBias;

        double rating = 0;
        double index = 0;
        double stdDev = 0;
        
        

        
        
        HashMap<String, Double> genreAvg = new HashMap<String, Double>();
        HashMap<String, Integer> occurrence = new HashMap<String, Integer>();

        for (Rating k : movie.getRating())
        {
            double sim = (similarity(k.getUser(), user));
            int common = commonItems(movie, k.getMovie());
            rating += sim * (k.getRating() - k.getUser().getAvgRating()) * (common / k.getMovie().getGenres().length);
            index += Math.abs(sim);
            
            for (String genre : k.getMovie().getGenres())
                genreAvg.put(genre, 0.0);
        }
        
        for (Rating k : user.getRatings())
        {
            stdDev += (k.getRating() - k.getUser().getAvgRating()) * (k.getRating() - k.getUser().getAvgRating());
            
            String[] keys = genreAvg.keySet().toArray(new String[genreAvg.keySet().size()]);
            Arrays.sort(keys);
            
            int indexFound = -1;
            
            for (String genre : k.getMovie().getGenres())
            {
                indexFound = Arrays.binarySearch(keys, genre);
                
                if (indexFound >= 0)
                {
                    genreAvg.put(genre, genreAvg.get(genre) + k.getRating());
                    occurrence.put(genre, (int) (genreAvg.get(genre) + 1));
                }
                    
            }
                
            
        }

        stdDev /= (user.getRatings().size() - 1);
        stdDev = Math.sqrt(stdDev);
        
        
        if (index != 0)
            index = 1 / index;

        return (stdDev * (index * rating)) + user.getAvgRating();
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
        User smallerUser = j;
        User biggerUser = i;

        if (j.getRatings().size() > i.getRatings().size())
        {
            smaller = i.getRatings();
            bigger = j.getRatings();
            smallerUser = i;
            biggerUser = j;
        }

        Collections.sort(bigger, new MovieComparator());

        for (Rating a : smaller)
        {
            int indexFound = Collections.binarySearch(bigger, a, new MovieComparator());

            if (indexFound >= 0)
            {
                Rating b = bigger.get(indexFound);
                
//                int commonGenres = commonItems(a.getMovie(), b.getMovie());
                
                jSim += (b.getRating() - biggerUser.getAvgRating()) * (b.getRating() - biggerUser.getAvgRating());
                iSim += (a.getRating() - smallerUser.getAvgRating()) * (a.getRating() - smallerUser.getAvgRating());
                sim += ((a.getRating() - smallerUser.getAvgRating()) * (b.getRating() - biggerUser.getAvgRating()));
            }

        }

        if (iSim == 0 || jSim == 0)
            return 0;

        return (sim) / ((Math.sqrt(iSim)) * (Math.sqrt(jSim)));
    }

    private int commonItems(Movie movie, Movie movie2)
    {
        int result = 0;
        
        Arrays.sort(movie2.getGenres(), new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }

        });
        
        Arrays.sort(movie.getGenres(), new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }

        });
        
        for (String genre : movie.getGenres())
        {
            int index = Arrays.binarySearch(movie2.getGenres(), genre, new Comparator<String>()
            {
                public int compare(String o1, String o2)
                {
                    return o1.compareTo(o2);
                }

            });
            
            if (index >= 0)
                result++;

        }
        
        return result;
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
        User user = userData.get(Collections.binarySearch(userData, new User(userID)));
        double maxRating = 0;
        int movieID = 0;

        for (Rating r : user.getRatings())
        {
            for (Rating k : r.getMovie().getRating())
            {
                double guess = guessRating(userID, k.getMovie().getMovieId());

                if (guess > maxRating)
                {
                    maxRating = guess;
                    movieID = k.getMovie().getMovieId();
                }

            }
        }

        return movieID;

    }

    public ArrayList<Movie> getMovieData()
    {
        return movieData;
    }

    public void setMovieData(ArrayList<Movie> movieData)
    {
        this.movieData = movieData;
    }

    public ArrayList<User> getUserData()
    {
        return userData;
    }

    public void setUserData(ArrayList<User> userData)
    {
        this.userData = userData;
    }
}

class MovieComparator implements Comparator<Rating>
{
    public int compare(Rating o1, Rating o2)
    {
        return o1.getMovie().compareTo(o2.getMovie());
    }

}
