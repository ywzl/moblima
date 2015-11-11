
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cineplex {

    private String name;
    private List<Integer> movieListings;
    private List<Showtime> showtimes;
    private List<Cinema> cinemas;

    public Cineplex() {
    }

    public Cineplex(String name) {
        this.name = name;
        this.movieListings = new ArrayList<Integer>();
        this.showtimes = new ArrayList<Showtime>();
        this.cinemas = new ArrayList<Cinema>();
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
    
    public void addMovieListing(int movieIndex) {
    	movieListings.add(movieIndex);
    }

    public Showtime getShowtime(int index) {
        return showtimes.get(index);
    }
    
    public Cinema getCinema(int index) {
    	return cinemas.get(index);
    }
    
    public void addCinema(String name, int row, int col) {
    	cinemas.add(new Cinema(name, row, col));
    }
    
    public void addShowtime(Cinema cinema, int movieIndex, Date session) {
    	showtimes.add(new Showtime(cinema, movieIndex, session));
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
    public List<Integer> getMovieListings() {
        return movieListings;
    }

    /**
     * @param movieListings the movieListings to set
     */
    public void setMovieListings(List<Integer> movieListings) {
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

}
