import java.util.ArrayList;
import java.util.Arrays;

public class Movie
{
    private int movieId, imdbId, tmdbId; //IDs
    private String title;
    private int releaseYear;
    private String[] genres;
    
    private ArrayList<Rating> ratings;
    private ArrayList<Tag> tags;

    public Movie(int movieId, int imdbId, int tmdbId, 
            String title, int releaseYear, String[] genres, 
            ArrayList<Rating> rating, ArrayList<Tag> tags)
    {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.setRating(rating);
        this.setTags(tags);
    }
    
    public Movie(int movieId, String title, int releaseYear, String[] genres)
    {
        this(movieId, -1, -1, title, releaseYear, genres, 
                new ArrayList<Rating>(), new ArrayList<Tag>());
    }
    
    // TODO unecessary?
    public Movie()
    {
        this(-1, "", -1, null);
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
        String out = "\nTITLE: " + title;
        out += "\nYEAR: " + releaseYear;
        out += "\nMOVIEID: " + movieId;
        out += "\nIMDBID: " + imdbId;
        out += "\nTMDBID: " + tmdbId;
        out += "\nGENRES: " + Arrays.toString(genres);
        
        
        return out;
    }

    public int getMovieId()
    {
        return movieId;
    }

    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }

    public int getImdbId()
    {
        return imdbId;
    }

    public void setImdbId(int imdbId)
    {
        this.imdbId = imdbId;
    }

    public int getTmdbId()
    {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId)
    {
        this.tmdbId = tmdbId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public String[] getGenres()
    {
        return genres;
    }

    public void setGenres(String[] genres)
    {
        this.genres = genres;
    }

    public ArrayList<Rating> getRating()
    {
        return ratings;
    }

    public void setRating(ArrayList<Rating> rating)
    {
        this.ratings = rating;
    }

    public ArrayList<Tag> getTags()
    {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags)
    {
        this.tags = tags;
    }

    
    

}
