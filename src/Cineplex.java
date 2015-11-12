
import java.util.ArrayList;
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
        for (int i = 0; i < cinemas.size(); i++) {
        	Cinema cinema = cinemas.get(i);
            System.out.println((i+1) + ": " + cinema.getName() + " [" + cinema.getSuite() + "]");
        }
    }
    
    public void displayShowtimesForMovie(int movieId) {
    	List<Showtime> movieShowtimes = getShowtimesForMovie(movieId);
    	for (int i=0; i<movieShowtimes.size(); i++) {
    		System.out.println((i+1) + ". " + movieShowtimes.get(i).getSession());
    	}
    }

    public List<Showtime> getShowtimesForMovie(int movieId) {
        List<Showtime> movieShowtimes = new ArrayList<Showtime>();
        for (int i = 0; i < showtimes.size(); i++) {
            Showtime showtime = showtimes.get(i);
            if (showtime.getMovieId() == movieId) {
                movieShowtimes.add(showtime);
            }
        }
        return movieShowtimes;
    }
    
    public void addMovieListing(int movieId) {
    	movieListings.add(movieId);
    }
    
    public void removeMovieListing(Integer movieId) {
    	movieListings.remove(movieId);
    }

    public Showtime getShowtime(int index) {
        return showtimes.get(index);
    }
    
    public void removeShowtime(int showtimeIndex) {
    	showtimes.remove(showtimeIndex);
    }
    
    public Cinema getCinema(int index) {
    	return cinemas.get(index);
    }
    
    public void addCinema(String name, int row, int col, Cinema.Suite suite) {
    	cinemas.add(new Cinema(name, row, col, suite));
    }
    
    public void addShowtime(Showtime showtime) {
    	showtimes.add(showtime);
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
