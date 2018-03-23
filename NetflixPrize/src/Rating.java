public class Rating
{
    private int userId; 
    private int timestamp; //Seconds from midnight (could be converted to Time class)
    private double rating; // 0.5 - 5.0
    private Movie movie; //Movie the rating is related to
    
    public Rating(int timestamp, double rating, Movie movie, int userId)
    {
        this.timestamp = timestamp;
        this.rating = rating;
        this.movie = movie;
        this.userId = userId;

    }
    
    public Rating()
    {
        this(-1, -1, null, -1);
    }
    
    public String toString()
    {
        String out = "\nMOVIE " + movie.toString();
        out += "\nTIMESTAMP: " + timestamp;
        out += "\nRATING: " + rating;
        out += "\nUSERID: " + userId;
        
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

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    
    
   
}
