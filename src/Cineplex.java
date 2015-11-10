import java.util.List;

public class Cineplex {
	private String name;
	private List<Integer> movieListing;
	private List<Showtime> showtimes;
	private List<Cinema> cinemas;
	
	public Cineplex() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMovie(Integer index) {
		movieListing.add(index);
	}
	
	public List<Integer> getMovieListing() {
		return movieListing;
	}
	
	public void addShowtime(Showtime showtime) {
		showtimes.add(showtime);
	}
	
	public Showtime getShowtime(int index) {
		return showtimes.get(index);
	}
	
	public void displayShowtimes() {
		// prints out all showtime + movie
	}
	
	public void addCinema(Cinema cinema) {
		cinemas.add(cinema);
	}
	
	public void displayCinemas() {
		for (int i=0; i<cinemas.size(); i++) {
			System.out.println(" " + i + ": " + cinemas.get(i).getName());
		}
	}

	public String getName() {
		return name;
	}

}
