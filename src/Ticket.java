
public class Ticket {
	private String type;
	private float price;
	
	public Ticket(String type, float price) {
		this.type = type;
		this.price = price;
	}
	
	public void displayTicket() {
		System.out.println(type + " - $" + price);
	}
	
	public String getType() {
		return type;
	}
	
	public float getPrice() {
		return price;
	}

}
