

/**
 *
 * @author Lloyd
 */
public class Ticket {
	private String type;
	private double price;
	
    /**
     *
     * @param type
     * @param price
     */
    public Ticket(String type, double price) {
		this.type = type;
		this.price = price;
	}
	
    /**
     *
     */
    public void displayTicket() {
		System.out.println(type + " - $" + price);
	}
	
    /**
     *
     * @return
     */
    public String getType() {
		return type;
	}
	
    /**
     *
     * @return
     */
    public double getPrice() {
		return price;
	}
	
    /**
     *
     * @param increment
     */
    public void incPrice(double increment) {
		this.price += increment;
	}
	
    /**
     *
     * @param price
     */
    public void setPrice(double price) {
		this.price = price;
	}

}
