import java.util.ArrayList;

public class Tester
{
    public static final String moviesFile = "ml-small-dataset" + FileIO.fileSeparator + "movies.csv";
    public static final String linksFile = "ml-small-dataset" + FileIO.fileSeparator + "links.csv";
    public static final String tagsFile = "ml-small-dataset" + FileIO.fileSeparator + "tags.csv";
    public static final String ratingsFile = "ml-small-dataset" + FileIO.fileSeparator + "ratings.csv";

    public static void main(String[] args)
    {

        ArrayList<Movie> movieData = new ArrayList<Movie>();
        ArrayList<User> userData = new ArrayList<User>();

        ArrayList<String> movieStringData = FileIO.readFile(moviesFile);
        ArrayList<String> linkStringData = FileIO.readFile(linksFile);
        ArrayList<String> ratingStringData = FileIO.readFile(ratingsFile);
        ArrayList<String> tagStringData = FileIO.readFile(tagsFile);

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
            for (int i = 1; i < ratingStringData.size(); i++)
                translator.assignRating(ratingStringData.get(i), u, movieData);

            for (int i = 1; i < tagStringData.size(); i++)
                translator.assignTag(tagStringData.get(i), u, movieData);
        }
        

            System.out.println(movieData.get(0).getRating());

        

    }

}
