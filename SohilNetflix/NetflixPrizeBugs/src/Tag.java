
public class Tag {
	
	private Movie movie;
	private int userID;
	private String tag;
	private int timestamp;
	
	
	// CONSTRUCTOR
	public Tag (Movie movie, int userID, String tag, int timestamp) {
		this.movie = movie;
		this.userID = userID;
		this.tag = tag;
		this.timestamp = timestamp;
	}
	
	// TOSTRING
	public String toString() {
		String out = "ID: " + userID;
		out += "\nMOVIE: " + movie.toString();
		out += "\nTAG: " + tag;
		out += "\nTIMESTAMP: " + timestamp;
		
		return out;
	}
	
	// SETTERS AND GETTERS
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
