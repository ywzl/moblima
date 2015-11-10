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
	
	public void addMovieListing(int cineplexIndex, int movieIndex) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.addMovieListing(movieIndex);
		save(JSONFile, list);
	}
	
	public void addBooking(int cineplexIndex, int showtimeIndex, String name, int mobile, String email, Ticket ticketType, List<Seat> seats) {
		Cineplex cineplex = list.get(cineplexIndex);
		Showtime showtime = cineplex.getShowtime(showtimeIndex);
		showtime.addBooking(name, mobile, email, ticketType, seats);
		save(JSONFile, list);
	}
	
	public void addTicket(int cineplexIndex, int showtimeIndex, String ticketType, int price) {
		Cineplex cineplex = list.get(cineplexIndex);
		Showtime showtime = cineplex.getShowtime(showtimeIndex);
		showtime.addTicketTypes(new Ticket(ticketType, price));
		save(JSONFile, list);
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			System.out.println(" " + i + ": " + list.get(i).getName());
		}
	}
}
