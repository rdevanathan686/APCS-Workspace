import java.util.ArrayList;
import java.util.Arrays;

public class User
{
    private int userId;
    private ArrayList<Rating> ratings;
    private ArrayList<Tag> tags;
    
    public User(int userId, ArrayList<Rating> ratings, ArrayList<Tag> tags)
    {
        this.userId = userId;
        this.ratings = ratings;
        this.tags = tags;

    }
    
    public User()
    {
        this(-1, new ArrayList<Rating>(), new ArrayList<Tag>());
    }
    
    public User(int userId)
    {
        this(userId, new ArrayList<Rating>(), new ArrayList<Tag>());
    }
    
    public void addRating(Rating r)
    {
        ratings.add(r);
    }
    
    public void addTag(Tag t)
    {
        tags.add(t);
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
