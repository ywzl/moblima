import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Lloyd
 */
public class CineplexController implements JSONFile{
	private List<Cineplex> list;
	private File JSONFile = new File("cineplexes.json");
	private Type Cineplexlist = new TypeToken<ArrayList<Cineplex>>(){}.getType();

    /**
     *
     */
    public CineplexController() {
		list = (List<Cineplex>) load(JSONFile, Cineplexlist);		
	}
	
    /**
     *
     * @param cineplex
     */
    public void addCineplex(Cineplex cineplex) {
		list.add(cineplex);
	}
	
    /**
     *
     * @param index
     * @return
     */
    public Cineplex getCineplex(int index) {
		return list.get(index);
	}
	
    /**
     *
     * @return
     */
    public List<Cineplex> getList() {
		return list;
	}
	
    /**
     *
     * @param cineplexIndex
     * @param showtime
     */
    public void addShowtime(int cineplexIndex, Showtime showtime) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.addShowtime(showtime);
		save(JSONFile, list);
	}
	
    /**
     *
     * @param cineplexIndex
     * @param showtimeIndex
     */
    public void removeShowtime(int cineplexIndex, int showtimeIndex) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.removeShowtime(showtimeIndex);
		save(JSONFile, list);
	}
	
    /**
     *
     * @param cineplexIndex
     * @param movieId
     */
    public void addMovieListing(int cineplexIndex, int movieId) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.addMovieListing(movieId);
		save(JSONFile, list);
	}
	
    /**
     *
     * @param cineplexIndex
     * @param movieId
     */
    public void removeMovieListing(int cineplexIndex, Integer movieId) {
		Cineplex cineplex = list.get(cineplexIndex);
		cineplex.removeMovieListing(movieId);
		save(JSONFile, list);
	}
	
    /**
     *
     * @param cineplexIndex
     * @param showtimeIndex
     * @param booking
     */
    public void addBooking(int cineplexIndex, int showtimeIndex, Booking booking) {
		Cineplex cineplex = list.get(cineplexIndex);
		Showtime showtime = cineplex.getShowtime(showtimeIndex);
		showtime.addBooking(booking);
		save(JSONFile, list);
	}
	
    /**
     *
     */
    public void displayList() {
		for (int i=0; i<list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).getName());
		}
	}
}
