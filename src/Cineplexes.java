import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class Cineplexes implements JSONFile{
	private List<Cineplex> list;
	File JSONFile = new File("cineplexes.json");
	Type Cineplexlist = new TypeToken<ArrayList<Cineplex>>(){}.getType();

	public Cineplexes() {
		list = (List<Cineplex>) load(JSONFile, Cineplexlist);		
	}
	
	public void addCineplex(Cineplex cineplex) {
		list.add(cineplex);
	}
	
	public Cineplex getCineplex(int index) {
		return list.get(index);
	}
	
	public List<Cineplex> getList() {
		return list;
	}
	
	public void addShowtime(int cineplexIndex, Showtime showtime) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.addShowtime(showtime);
		save(JSONFile, list);
	}
	
	public void removeShowtime(int cineplexIndex, int showtimeIndex) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.removeShowtime(showtimeIndex);
		save(JSONFile, list);
	}
	
	public void addMovieListing(int cineplexIndex, int movieId) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.addMovieListing(movieId);
		save(JSONFile, list);
	}
	
	public void removeMovieListing(int cineplexIndex, Integer movieId) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.removeMovieListing(movieId);
		save(JSONFile, list);
	}
	
	public void addBooking(int cineplexIndex, int showtimeIndex, Booking booking) {
		Cineplex cineplex = list.get(cineplexIndex);
		Showtime showtime = cineplex.getShowtime(showtimeIndex);
		showtime.addBooking(booking);
		save(JSONFile, list);
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).getName());
		}
	}
}
