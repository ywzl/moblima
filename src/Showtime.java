import java.util.Date;
import java.util.List;

public class Showtime {
	private String movieTitle;
	private Date session;
	private List<Ticket> ticketTypes;
	private List<Booking> bookings;
	private Seat[][] seats;
	
	public Showtime(Cinema cinema, String movieTitle, Date session, List<Ticket> ticketTypes) {
		
		
	}
	
	public void addBooking() {
		// collect relevant details
		// check if seats taken
		// assign seats
		// create booking
	}
	
	public void assignSeat(int row, int col) {
		getSeat(row, col).assignSeat();
	}
	
	public boolean seatTaken(int row, int col) {
		return getSeat(row, col).isTaken();
	}

}
