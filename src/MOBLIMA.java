
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class MOBLIMA {
    private List<Cineplex> cineplexes;
    private List<Movie> movieListing;

    public MOBLIMA() {
    }
    
    public MOBLIMA(List<Cineplex> cineplexes, List<Movie> movieListing) {
        this.cineplexes = cineplexes;
        this.movieListing = movieListing;
    }
    
    public List<Movie> getRecentMovies() {
        List<Movie> recentMovies = new ArrayList<>();
        for (Movie movie : movieListing) {
            if (movie.getShowingStatus() != Movie.ShowingStatus.END_OF_SHOWING) {
                recentMovies.add(movie);
            }
        }
        return recentMovies;
    }

    /**
     * @return the cineplexes
     */
    public List<Cineplex> getCineplexes() {
        return cineplexes;
    }

    /**
     * @param cineplexes the cineplexes to set
     */
    public void setCineplexes(List<Cineplex> cineplexes) {
        this.cineplexes = cineplexes;
    }

    /**
     * @return the movieListing
     */
    public List<Movie> getMovieListing() {
        return movieListing;
    }

    /**
     * @param movieListing the movieListing to set
     */
    public void setMovieListing(List<Movie> movieListing) {
        this.movieListing = movieListing;
    }
    
    
}
