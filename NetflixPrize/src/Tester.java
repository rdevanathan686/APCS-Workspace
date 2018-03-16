import java.util.ArrayList;

public class Tester
{

    public static void main(String[] args)
    {
        ArrayList<String> movieStrings = FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
        
//        for (String movie: moveStrings)
//        {
//            System.out.println(movie);
//        }
        
        ArrayList<Movie> movieData = new ArrayList<Movie>();
        MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
        
        for (String s: movieStrings)
        {
            Movie m = translator.parseMovie(s);
            movieData.add(m);
        }
        
        for (Movie m : movieData)
        {
            System.out.println(m);
        }

    }

}
