import java.util.ArrayList;

public class TesterBugs {

	public static void main(String[] args) {
				
//		testMovies();
//		testRatings();
//		testTags();
//		testLinks();
	}


	public static void testMovies() {
		// Testing movies
		String movieFilePath = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";

		ArrayList<String> movieStringData = FileIO.readFile(movieFilePath);

		ArrayList<Movie> movieData = new ArrayList<Movie>();
		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();
		for (int i = 1; i < movieStringData.size(); i++) {
			Movie m = translator.parseMovie(movieStringData.get(i));
			movieData.add(m);
		}

		for (Movie m : movieData) {
			System.out.println(m);
		}
	}
	
//	public static void testRatings() {
//		// Testing ratings
//		String ratingsFilePath = "ml-latest-small" + FileIO.fileSeparator + "ratings.csv";
//
//		ArrayList<String> ratingStringData = FileIO.readFile(ratingsFilePath);
//
//		ArrayList<Rating> ratingData = new ArrayList<Rating>();
//		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();
//		for (int i = 1; i < ratingStringData.size(); i++) {
//			Rating r = translator.parseRating(ratingStringData.get(i));
//			ratingData.add(r);
//		}
//
//		for (Rating r : ratingData) {
//			System.out.println(r);
//		}
//	}
//	
//	public static void testTags() {
//		// Testing ratings
//		String tagsFilePath = "ml-latest-small" + FileIO.fileSeparator + "tags.csv";
//
//		ArrayList<String> tagStringData = FileIO.readFile(tagsFilePath);
//
//		ArrayList<Tag> tagData = new ArrayList<Tag>();
//		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();
//		for (int i = 1; i < tagStringData.size(); i++) {
//			Tag t = translator.parseTag(tagStringData.get(i));
//			tagData.add(t);
//		}
//
//		for (Tag t : tagData) {
//			System.out.println(t);
//		}
//	}
//	
//	public static void testLinks() {
//		// Testing ratings
//		String linksFilePath = "ml-latest-small" + FileIO.fileSeparator + "links.csv";
//
//		ArrayList<String> linkStringData = FileIO.readFile(linksFilePath);
//
//		ArrayList<Link> linkData = new ArrayList<Link>();
//		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();
//		for (int i = 1; i < linkStringData.size(); i++) {
//			Link l = translator.parseLink(linkStringData.get(i));
//			linkData.add(l);
//		}
//
//		for (Link l : linkData) {
//			System.out.println(l);
//		}
//	}
}
