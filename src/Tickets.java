import java.io.File;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class Tickets implements JSONFile {
	private List<Ticket> list;
    private Type Ticketlist = new TypeToken<ArrayList<Ticket>>() {}.getType(); // needed for gson to load into Arraylist
    private File JSONFile = new File("tickets.json");

	public Tickets() {
    	list = (List<Ticket>) load(JSONFile, Ticketlist);
		/*
    	list = new ArrayList<Ticket>();
		
		list.add(new Ticket("Senior Citizen", 4.0));
		list.add(new Ticket("Student", 7.0));
		list.add(new Ticket("Student 3D", 9.0));
		list.add(new Ticket("Mon-Wed", 8.5));
		list.add(new Ticket("Mon-Wed 3D", 11.0));
		list.add(new Ticket("Thursday", 9.5));
		list.add(new Ticket("Thursday 3D", 11.0));
		list.add(new Ticket("Friday", 9.5));
		list.add(new Ticket("Friday 3D", 15.0));
		
		list.add(new Ticket("Weekend", 11.0)); // includes friday evening
		list.add(new Ticket("Weekend 3D", 15.0));
		
		list.add(new Ticket("PH/EVE", 11.0));
		list.add(new Ticket("PH/EVE 3D", 15.0));
	
		list.add(new Ticket("D-BOX", 22.0));
		list.add(new Ticket("Gold Class", 29.0));
		list.add(new Ticket("Gemini", 18.0));
		
		save(JSONFile, list);
		*/
	}
	
	public List<Ticket> getAvailableTickets(Date session) {
		List<Ticket> tickets = new ArrayList();
		
		
		return tickets;
	}
	
	public Ticket getTicket(int index) {
		return list.get(index);
	}
	
	public void setTicketPrice(int ticketIndex, double price) {
		list.get(ticketIndex).setPrice(price);
		save(JSONFile, list);
	}
	
	public List<Ticket> getList() {
		return list;
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			System.out.print((i+1) + ". ");
			list.get(i).displayTicket();
		}
		System.out.println();
	}
	
    public boolean isAfterSix(Date session) {
        SimpleDateFormat df = new SimpleDateFormat("HH");
        Date sixPM = null;
		try {
			sixPM = df.parse("18");
		} catch (ParseException e) {
			e.printStackTrace();
		}
        int t1 = (int) (session.getTime() % (24*60*60*1000L));
        int t2 = (int) (sixPM.getTime() % (24*60*60*1000L));
        
        return t1 >= t2;
    }
}
