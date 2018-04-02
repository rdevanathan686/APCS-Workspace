import java.util.ArrayList;


public class NetFlixPredictor {


	// Add fields to represent your database.
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private ArrayList<Rating> ratings = new ArrayList<Rating>();
	private ArrayList<Tag> tags = new ArrayList<Tag>();


	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {

		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();

		ArrayList<String> movieStringData = FileIO.readFile(movieFilePath);
		ArrayList<String> ratingStringData = FileIO.readFile(ratingFilePath);
		ArrayList<String> tagStringData = FileIO.readFile(tagFilePath);
		ArrayList<String> linkStringData = FileIO.readFile(linkFilePath);

		for (int i = 1; i < movieStringData.size(); i++) {
			Movie m = translator.parseMovie(movieStringData.get(i));
			translator.parseLink(m, linkStringData.get(i));
			movies.add(m);
		}

		//		for (int i = 0; i < ratingStringData.size(); i++) {
		//			for (int j = 0; j < users.size(); j++) {
		//				User user = translator.parseUser(users.get(j), ratingStringData.get(i));
		//				System.out.println("adding user");
		//				if (user != null) {
		//					users.add(user);
		//				}
		//			}
		//		}

		for (int i = 1; i < ratingStringData.size(); i++) {
			User user = null;

			if (users.size() != 0) {
				user = translator.parseUser(users.get(users.size() - 1), ratingStringData.get(i));
			} else {
				user = (translator.parseUser(null, ratingStringData.get(i)));
			}

			if (user != null)
				users.add(user);

		}

		for (User user : users) {
			for (int i = 1; i < ratingStringData.size(); i++) {
				translator.parseRating(user, movies, ratingStringData.get(i));
				if (user.getRatings().size() != 0) {
					if (user.getRatings().size() == 1) {
						ratings.add(user.getRatings().get(0));
					} else {
						ratings.add(user.getRatings().get(user.getRatings().size() - 1));	
					}
				}	
			}

			for (int i = 1; i < tagStringData.size(); i++) {
				translator.parseTag(user, movies, tagStringData.get(i));
//				tags.add(user.getTags().get(user.getTags().size() - 1));
			}
		}
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {

		for (User user : users)
		{
			if (user.getUserID() == userID)
			{
				for (Rating rating : user.getRatings()) {
					if (rating.getMovie().getMovieID() == movieID) {
						return rating.getRating();
					}
				}
			}
		}

		return -1;
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {
		User user = null;
		Movie movie = null;
		double userAvg = 0, movieAvg = 0, ratingSuperAvg = 0, userDifference = 0, ratingGenreAvg = 0;

		for (User u : users) {
			ratingSuperAvg += u.ratingAvg();
			if (u.getUserID() == userID) {
				user = u;
				userAvg = user.ratingAvg();
			}
		}	
		ratingSuperAvg /= users.size();
		userDifference = (ratingSuperAvg - userAvg);

		for (Movie m : movies) {
			if (m.getMovieID() == movieID) {
				movie = m;
				break;
			}
		}

		if (getRating(userID, movieID) != -1) {
			return getRating(userID, movieID);
		}

		int sameGenre = 0;
		for (Rating rating : user.getRatings()) {
			for (String genre : rating.getMovie().getGenres()) {
				for (String genreMovie : movie.getGenres()) {
					if (genre.equals(genreMovie)) {
						ratingGenreAvg += rating.getRating();
						sameGenre++;
					}
				}
			}
		}
		if (sameGenre != 0)
			ratingGenreAvg /= sameGenre;


		if (ratings.size() != 0) {
			int ratingTotal = 0;
			int numOfRatedMovie = 0;
			for (Rating r : ratings) {
				if (r.getMovie().getMovieID() == movieID) {
					ratingTotal += r.getRating();
					numOfRatedMovie++;
				}
			}
			if (numOfRatedMovie != 0) {
				movieAvg = ratingTotal / numOfRatedMovie;
			} else {
				movieAvg = userAvg;
			}
		}

		return ratingGenreAvg + userDifference;
//		return (movieAvg + userAvg) / 2;
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		return 0;
	}

}