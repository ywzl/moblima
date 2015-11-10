import java.util.List;

public class Booking {
	private String name;
	private int mobile;
	private String email;
	private String TID;
	private Ticket ticketType;
	private List<Seat> seats;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTotalAmount() {
		return seats.size() * ticketType.getPrice();
	}
	
	public void displayBooking() {
		// prints out all details
	}

}
