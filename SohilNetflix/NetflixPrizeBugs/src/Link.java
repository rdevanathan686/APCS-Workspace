
public class Link {
	
	private int movieID;
	private int imdbID;
	private int tmdbID;
	
	// CONSTRUCTOR
	public Link (int movieID, int imdbID, int tmdbID) {
		this.movieID = movieID;
		this.imdbID = imdbID;
		this.tmdbID = tmdbID;
	}
	
	// TOSTRING
	public String toString() {
		String out = "ID: " + movieID;
		out += "\nIMDBID: " + imdbID;
		out += "\nTMBDID: " + tmdbID;
		
		return out;
	}
	
}
