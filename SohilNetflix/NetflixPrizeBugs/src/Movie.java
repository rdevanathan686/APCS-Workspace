import java.util.Arrays;

public class Movie implements Comparable<Movie> {

	private int movieID;
	private String imdbID, tmdbID;
	private String title;
	private int year;
	private String[] genres;
	
	// Add other fields for handling ratings, links, and tags in some way	
	
	// CONSTRUCTOR
	public Movie (int movieId, int year, String title, String[] genres, String imdbID, String tmdbID) {
		this.movieID = movieId;
		this.year = year;
		this.title = title;
		this.genres = genres;
		this.imdbID = imdbID;
		this.tmdbID = tmdbID;
	}
	
	public Movie (int movieId, int year, String title, String[] genres) {
		this.movieID = movieId;
		this.year = year;
		this.title = title;
		this.genres = genres;
	}
	
	public Movie (int movieID) {
		this.movieID = movieID;
	}
	
	// TOSTRING
	public String toString() {
		String out = "ID: " + movieID;
		out += "\nYEAR: " + year;
		out += "\nTITLE: " + title;
		out += "\nGENRES: " + Arrays.toString(genres);
		out += "\nIMDBID: " + imdbID;
		out += "\nTMDBID: " + tmdbID;
		
		return out;
	}

	// SETTERS AND GETTERS
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getTmdbID() {
		return tmdbID;
	}

	public void setTmdbID(String tmdbID) {
		this.tmdbID = tmdbID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	@Override
	public int compareTo(Movie arg0) {
		
		/*
		if (movieID > arg0.movieID) {
			return 1;
		} else if (movieID < arg0.movieID) {
			return -1;
		} else {
			return 0;
		}
		*/
		
		return movieID - arg0.movieID;
	}
	
	
}
