import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Booking {
	private String name;
	private int mobile;
	private String email;
	private String TID;
	private Ticket ticketType;
	private List<Seat> seats;
	
	public Booking(String name, int mobile, String email, Ticket ticketType, List<Seat> seats, String XXX) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.ticketType = ticketType;
		this.seats = seats;
		
		DateFormat df = new SimpleDateFormat("YYYYMMDDhhmm");
		this.TID = XXX + df.format(new Date());
	}
	
	public List<Seat> getSeats() {
		return seats;
	}
	
	public String getTID() {
		return TID;
	}
	
	public double getTotalAmount() {
		return seats.size() * ticketType.getPrice();
	}
	
	public void displayBooking() {
		// prints out all details
	}

}
