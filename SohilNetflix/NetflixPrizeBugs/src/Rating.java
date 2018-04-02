
public class Rating implements Comparable<Rating> {
	
	private Movie movie;
	private int userID;
	private double rating;
	private int timestamp;
	
	// CONSTRUCTOR
	public Rating (Movie movie, int userID, double rating, int timestamp) {
		this.movie = movie;
		this.userID = userID;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	public Rating (int userID, Movie movie, int movieID) {
		this.userID = userID;
		this.movie = movie;
		if (movie != null)
			this.movie.setMovieID(movieID);
	}
	
	// TOSTRING
	public String toString() {
		String out = "ID: " + userID;
		out += "\nMOVIE: " + movie.toString();
		out += "\nRATING: " + rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int compareTo(Rating arg0) {
		
		if (userID > arg0.userID) {
			return 1;
		} else if (userID < arg0.userID) {
			return -1;
		} else {
			if (movie != null && arg0.movie != null) {
				if (movie.getMovieID() > arg0.getMovie().getMovieID()) {
					return 1;
				} else if (movie.getMovieID() < arg0.getMovie().getMovieID()) {
					return -1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}
		
	}
	
	
}
