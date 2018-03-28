public class Rating
{
    private User user; 
    private int timestamp; //Seconds from midnight (could be converted to Time class)
    private double rating; // 0.5 - 5.0
    private Movie movie; //Movie the rating is related to
    
    public Rating(int timestamp, double rating, Movie movie, User u)
    {
        this.timestamp = timestamp;
        this.rating = rating;
        this.movie = movie;
        this.user = u;

    }
    
    public Rating()
    {
        this(-1, -1, null, null);
    }
    
    public String toString()
    {
        String out = "\nMOVIE " + movie.toString();
        out += "\nTIMESTAMP: " + timestamp;
        out += "\nRATING: " + rating;
        out += "\nUSERID: " + user.getUserId();
        
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    
    
    
   
}
