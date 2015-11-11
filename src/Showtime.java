import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Showtime {
	private int movieIndex;
	private Date session;
	private List<Ticket> ticketTypes;
	private List<Booking> bookings;
	private Seat[][] seats;
	
	public Showtime(Cinema cinema, int movieIndex, Date session) {
		this.movieIndex = movieIndex;
		this.session = session;
		this.ticketTypes = new ArrayList<Ticket>();
		
		int rows = cinema.getRows();
		int cols = cinema.getCols();
		seats = new Seat[rows][cols];
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				seats[i][j] = new Seat(i, j);
			}
		}
	}
	
	public int getMovieIndex() {
		return movieIndex;
	}
	
	public String getSession() {
		DateFormat df = new SimpleDateFormat("hhmm");
		return df.format(session);
	}
	
	public void addBooking(String name, int mobile, String email, Ticket ticketType, List<Seat> seats) {
		String XXX = "XXX";
		Booking booking = new Booking(name, mobile, email, ticketType, seats, XXX);
		
		for (Seat seat : seats) {
			assignSeat(seat.getRow(), seat.getCol());
		}
		bookings.add(booking);
	}
	
	public void assignSeat(int row, int col) {
		seats[row][col].assignSeat();
	}
	
	public boolean seatTaken(int row, int col) {
		return seats[row][col].isTaken();
	}

	/**
	 * @return the ticketTypes
	 */
	public List<Ticket> getTicketTypes() {
		return ticketTypes;
	}

	/**
	 * @param ticketTypes the ticketTypes to set
	 */
	public void addTicketTypes(Ticket ticket) {
		ticketTypes.add(ticket);
	}

}
