
import java.util.ArrayList;
import java.util.List;

public class Cineplex {

    private String name;
    private List<MovieStatus> movieListings;
    private List<Showtime> showtimes;
    private List<Cinema> cinemas;

    public Cineplex() {
    }

    public Cineplex(String name, List<MovieStatus> movieListings, List<Showtime> showtimes, List<Cinema> cinemas) {
        this.name = name;
        this.movieListings = movieListings;
        this.showtimes = showtimes;
        this.cinemas = cinemas;
    }

    public void displayCinemas() {
        for (int i = 0; i < getCinemas().size(); i++) {
            System.out.println(" " + i + ": " + getCinemas().get(i).getName());
        }
    }

    public List<Showtime> getShowtimesForMovie(int movieIndex) {
        List<Showtime> movieShowtimes = new ArrayList<Showtime>();
        for (int i = 0; i < showtimes.size(); i++) {
            Showtime showtime = showtimes.get(i);
            if (showtime.getMovieIndex() == movieIndex) {
                movieShowtimes.add(showtime);
            }
        }
        return movieShowtimes;
    }

    public Showtime getShowtime(int index) {
        return showtimes.get(index);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the movieListings
     */
    public List<MovieStatus> getMovieListings() {
        return movieListings;
    }

    /**
     * @param movieListings the movieListings to set
     */
    public void setMovieListings(List<MovieStatus> movieListings) {
        this.movieListings = movieListings;
    }

    /**
     * @return the showtimes
     */
    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    /**
     * @param showtimes the showtimes to set
     */
    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    /**
     * @return the cinemas
     */
    public List<Cinema> getCinemas() {
        return cinemas;
    }

    /**
     * @param cinemas the cinemas to set
     */
    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

}
