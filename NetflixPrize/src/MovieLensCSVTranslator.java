
public class MovieLensCSVTranslator
{
    
    public Movie parseMovie(String line)
    {
        Movie movie = new Movie();
//        for (int i = 0; i < line.length(); i++)
//        {
//            
//        }
        
        // try 
        // strictest check
        int movieId = Integer.parseInt(line.substring(0, line.indexOf(",")));
        // catch errors
        
        // chop off the line
        // line 13
        

        movie.setMovieId(movieId);
        
        return movie;

    }

    
}
