import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Showtime {
	private int movieId;
	private Date session;
	private Cinema cinema;
	private List<Ticket> ticketTypes;
	private List<Booking> bookings;
	private Seat[][] seats;
	
	public Showtime(Cinema cinema, int movieId, Date session, List<Ticket> tickets) {
		this.movieId = movieId;
		this.session = session;
		this.ticketTypes = tickets;
		this.cinema = cinema;
		this.bookings = new ArrayList<Booking>();
		
		int rows = cinema.getRows();
		int cols = cinema.getCols();
		seats = new Seat[rows][cols];
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				seats[i][j] = new Seat(i, j);
			}
		}
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public String getCinemaName() {
		return cinema.getName();
	}
	
	public String getSession() {
		DateFormat df = new SimpleDateFormat("dd-MM EEE HH:mm");
		return df.format(session);
	}
	
	public void displaySeats() {
		System.out.println("- Seat Layout (X denotes taken) -");
		
		for (int i=0; i<seats.length; i++) {
			System.out.print(seats[i][0].getRowAlphabet());
			for (int j=0; j<seats[i].length; j++) {
				String display = (seats[i][j].isTaken()) ? " [X] " : " ["+ j +"] ";
				System.out.print(display);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
		
		for (Seat seat : booking.getSeats()) {
			assignSeat(seat.getRow(), seat.getCol());
		}
		bookings.add(booking);
	}
	
	public void assignSeat(int row, int col) {
		seats[row][col].assignSeat();
	}
	
	public boolean isSeatTaken(int row, int col) {
		return seats[row][col].isTaken();
	}
	
	public void displayTicketTypes() {
		for (int i=0; i<ticketTypes.size(); i++) {
			System.out.print((i+1) + ". ");
			ticketTypes.get(i).displayTicket();
		}
	}
	
	public Ticket getTicket(int ticketIndex) {
		return ticketTypes.get(ticketIndex);
	}

	/**
	 * @return the ticketTypes
	 */
	public List<Ticket> getTicketTypes() {
		return ticketTypes;
	}

}
