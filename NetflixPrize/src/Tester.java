import java.util.ArrayList;

public class Tester
{

    public static void main(String[] args)
    {

        // Testing movies
        String movieFilePath = "data" + FileIO.fileSeparator + "movies.csv";
        String linkFilePath = "data" + FileIO.fileSeparator + "links.csv";
        String ratingsFilePath = "data" + FileIO.fileSeparator + "ratings.csv";
        String tagFilePath = "data" + FileIO.fileSeparator + "tags.csv";

        ArrayList<String> movieStringData = FileIO.readFile(movieFilePath);
        ArrayList<String> linkStringData = FileIO.readFile(linkFilePath);
        ArrayList<String> ratingStringData = FileIO.readFile(ratingsFilePath);
        ArrayList<String> tagStringData = FileIO.readFile(tagFilePath);

        ArrayList<Movie> movieData = new ArrayList<Movie>();
        ArrayList<User> userData = new ArrayList<User>();

        MovieLensCSVTranslator translator = new MovieLensCSVTranslator();

        for (int i = 1; i < movieStringData.size(); i++)
        {
            Movie m = translator.parseMovie(movieStringData.get(i));
            translator.parseLinks(m, linkStringData.get(i));
            movieData.add(m);
        }

        for (int i = 1; i < ratingStringData.size(); i++)
        {

            translator.parseUser(ratingStringData.get(i), userData);

        }

        for (User u : userData)
        {

            for (int i = 1; i < ratingStringData.size(); i++)
            {

                translator.assignRating(ratingStringData.get(i), u, movieData);

            }

            for (int i = 1; i < tagStringData.size(); i++)
            {

                translator.assignTag(tagStringData.get(i), u);

            }

        }

//        for (User u : userData)
//        {
//            System.out.println(u);
//
//        }
        
        for (Movie u : movieData)
        {
            System.out.println(u);

        }

    }

}
