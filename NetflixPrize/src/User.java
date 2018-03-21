import java.util.ArrayList;
import java.util.Arrays;

public class User
{
    private int userId;
    private ArrayList<Rating> ratings;
    
    public User(int userId, ArrayList<Rating> ratings)
    {
        this.userId = userId;
        this.ratings = ratings;
    }
    
    public User()
    {
        this(-1, new ArrayList<Rating>());
    }
    
    public User(int userId)
    {
        this(userId, new ArrayList<Rating>());
    }
    
    public void addRating(Rating r)
    {
        ratings.add(r);
    }
    
    public String toString()
    {
        String out = "\nUSERID: " + userId;
        out += "\nRATINGS: ";
        
        for (Rating r: ratings)
        {
            out += r.toString() + "\n";
        }
        
        return out;
        
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public ArrayList<Rating> getRatings()
    {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings)
    {
        this.ratings = ratings;
    }
    
    
    
}
