import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MovieLensCSVTranslatorBugs {


	private ArrayList<String> getLinePieces (String line) {
		ArrayList<String> pieces = new ArrayList<String>();  // Holds comma separated pieces of the line
		boolean quoted = false;  // Keeps track of whether the current character is inside of quotes or not
		int start = 0;
		for (int i = 0; i < line.length(); i++) {  // For each character...
			char thisChar = line.charAt(i);
			if (thisChar == '"') {  // If we see a quote symbol
				quoted = !quoted;   // Then we're inside of quotes
			} else if (thisChar == ',' && !quoted) {  // If we see a comma and we're not inside of quotes
				pieces.add(line.substring(start,i));  // Add this chunk of data to the pieces list
				start = i+1;
			}
		}

		pieces.add(line.substring(start));

		return pieces;
	}


	public Movie parseMovie (String line) {
		ArrayList<String> pieces = getLinePieces(line);  // Get all the sections of the line separated by commas (but not in quotes)

		int id = Integer.parseInt(pieces.get(0));  // ID is the first piece of data

		String title = pieces.get(1);  // title is the second piece of data

		int yearStart = title.lastIndexOf("(");
		int year = -1;

		if (yearStart != -1) {
			year = Integer.parseInt(title.substring(yearStart+1, yearStart+5));  // Extract the year from inside parenthesis
		}

		String[] genrePieces = pieces.get(2).split("\\|"); // Split up the genres by looking for |

		Movie m = new Movie(id, year, title, genrePieces);
		return m;
	}


	// HERE WE NEED
	// METHODS FOR TRANSLATING

	// USER
	public User parseUser(User user, String line) {
		ArrayList<String> pieces = getLinePieces(line);
		
		int userID = Integer.parseInt(pieces.get(0));
		
		if (user == null) {
			return new User(userID);
		}
		if (user.getUserID() == userID) {
			return null;
		}
		
		return new User(userID);
	}

	// RATINGS
	public void parseRating (User user, ArrayList<Movie> movies, String line) {
		ArrayList<String> pieces = getLinePieces(line);  // Get all the sections of the line separated by commas (but not in quotes)

		int userID = Integer.parseInt(pieces.get(0));  // userID is the first piece of data
		int movieID = Integer.parseInt(pieces.get(1));	// movieID is the second piece of data
		double rating = Double.parseDouble(pieces.get(2));  // rating is the third piece of data
		int timestamp = Integer.parseInt(pieces.get(3)); // timestamp is the fourth piece of data
		
		if (user.getUserID() != userID) {
			return;
		}
		
		Movie movie = null;
		int num = Collections.binarySearch(movies, new Movie(movieID));
		if (num >= 0) {
			movie = movies.get(num);
		} else {
			// NOT IN THE LIST
		}
		/*
		for (Movie m : movies) {
			if (m.getMovieID() == movieID) {
				movie = m;
				break;
			}
		}
		*/
		
		user.addRating(new Rating(movie, userID, rating, timestamp));
	}

	
	// TAGS
	public void parseTag (User user, ArrayList<Movie> movies, String line) {
		ArrayList<String> pieces = getLinePieces(line);  // Get all the sections of the line separated by commas (but not in quotes)

		int userID = Integer.parseInt(pieces.get(0)); // userID is the first piece of data
		int movieID = Integer.parseInt(pieces.get(1));  // movieID is the second piece of data
		String tag = pieces.get(2);  // tag is the third piece of data
		int timestamp = Integer.parseInt(pieces.get(3)); // timestamp is the fourth piece of data
		
		if (user.getUserID() != userID) {
			return;
		}
		
		Movie movie = null;
		int num = Collections.binarySearch(movies, new Movie(movieID));
		if (num >= 0) {
			movie = movies.get(num);
		} else {
			// NOT IN THE LIST
		}
		/*
		for (Movie m : movies) {
			if (m.getMovieID() == movieID) {
				movie = m;
				break;
			}
		}
		*/
		
		user.addTag(new Tag(movie, userID, tag, timestamp));
	}

	
	// AND LINKS
	public void parseLink (Movie movie, String line) {
		ArrayList<String> pieces = getLinePieces(line);  // Get all the sections of the line separated by commas (but not in quotes)

		int movieID = Integer.parseInt(pieces.get(0));  // movieID is the first piece of data

		String imdbID = pieces.get(1);  // imdbID is the second piece of data

		String tmdbID = "";
		if (!pieces.get(2).equals(""))
			tmdbID = pieces.get(2); // timestamp is the third piece of data

		// Link l = new Link(movieID, imdbID, tmdbID);
		
		movie.setMovieID(movieID);
		movie.setImdbID(imdbID);
		movie.setTmdbID(tmdbID);
		
		// return l;
	}

	
}
