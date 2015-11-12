import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Booking {
	private String name;
	private int mobile;
	private String email;
	private int showtimeIndex;
	private int cineplexIndex;
	private String TID;
	private Ticket ticketType;
	private List<Seat> seats;
	
	public Booking(String name, int mobile, String email, Ticket ticketType, List<Seat> seats, String XXX, int cineplexIndex, int showtimeIndex) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.ticketType = ticketType;
		this.seats = seats;
		this.cineplexIndex = cineplexIndex;
		this.showtimeIndex = showtimeIndex;
		
		DateFormat df = new SimpleDateFormat("YYYYMMDDhhmm");
		this.TID = XXX + df.format(new Date());
	}
	
	public List<Seat> getSeats() {
		return seats;
	}
	
	public String getTID() {
		return TID;
	}
	
	public int getMobile() {
		return mobile;
	}
	
	public int getCineplexIndex() {
		return cineplexIndex;
	}
	
	public int getShowtimeIndex() {
		return showtimeIndex;
	}
	
	public double getTotalAmount() {
		return seats.size() * ticketType.getPrice();
	}
	
	public Ticket getTicketType() {
		return ticketType;
	}

}
