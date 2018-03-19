import java.util.InputMismatchException;

public class MovieLensCSVTranslator
{
    
    public Movie parseMovie(String line)
    {
        Movie movie = new Movie();
        
        // try 
        // strictest check
        
        try
        {
            int movieId = Integer.parseInt(line.substring(0, line.indexOf(",")));
            line = line.substring(line.indexOf(",") + 1);
            String title;
            
            if (line.charAt(0) != '"')
            {
                title = line.substring(0, line.indexOf(","));
                line = line.substring(line.indexOf(",") + 1);
            } 
            else
            {
                title = line.substring(1, line.indexOf("\"", 1));
                line = line.substring(line.lastIndexOf("\"") + 2);
            }
            

            String[] genres = line.split("|");
            
                
            movie.setMovieId(movieId);
            movie.setTitle(title);
            movie.setGenres(genres);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        
        // catch errors
        
        // chop off the line
        // line 13
        

        
        
        return movie;

    }

    
}
