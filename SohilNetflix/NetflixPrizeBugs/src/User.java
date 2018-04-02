import java.util.ArrayList;
import java.util.Arrays;

public class User implements Comparable<User> {
	
	private int userID;
	private ArrayList<Rating> ratings = new ArrayList<Rating> ();
	private ArrayList<Tag> tags = new ArrayList<Tag> ();
	
	
	// CONSTRUCTOR
	public User (int userID, ArrayList<Rating> ratings, ArrayList<Tag> tags) {
		this.userID = userID;
		this.ratings = ratings;
		this.tags = tags;
	}
	
	public User(int userID) {
		this.userID = userID;
	}
	
	// TOSTRING
	public String toString() {
		String out = "ID: " + userID;
		out += "\nRATINGS: " + ratings;
		out += "\nTAGS: " + tags;
		
		return out;
	}

	// SETTERS AND GETTERS
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	
	// ADDING TO ARRAYS
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public void addRating(Rating rating) {
		ratings.add(rating);
	}
	
	// AVERAGES
	public double ratingAvg() {
		if (ratings.size() == 0) {
			return -1;
		} else {
			double total = 0;
			for (int i = 0; i < ratings.size(); i ++) {
				total += ratings.get(i).getRating();
			}
			
			return total / ratings.size();
		}
	}

	@Override
	public int compareTo(User arg0) {
		
		if (userID > arg0.userID) {
			return 1;
		} else if (userID < arg0.userID) {
			return -1;
		} else {
			return 0;
		}
		
	}
}
