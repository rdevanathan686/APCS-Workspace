public class Rating
{
    private int timestamp; //Seconds from midnight (could be converted to Time class)
    private int rating; // 0.5 - 5.0
    private String tag; // User generated comments
    private Movie movie; //Movie the rating is related to
}
