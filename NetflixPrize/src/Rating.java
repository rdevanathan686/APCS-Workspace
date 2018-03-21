public class Rating
{
    private int timestamp; //Seconds from midnight (could be converted to Time class)
    private double rating; // 0.5 - 5.0
    private String tag; // User generated comments
    private Movie movie; //Movie the rating is related to
    
    public Rating(int timestamp, double rating, String tag, Movie movie)
    {
        this.timestamp = timestamp;
        this.rating = rating;
        this.tag = tag;
        this.movie = movie;
    }
    
    public Rating()
    {
        this(-1, -1, null, null);
    }
    
    public String toString()
    {
        String out = "\nMOVIE: " + movie.toString();
        out += "\nTIMESTAMP: " + timestamp;
        out += "\nRATING: " + rating;
        out += "\nTAG: " + tag;
        
        return out;
        
    }

    public int getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(int timestamp)
    {
        this.timestamp = timestamp;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
    
    
   
}
