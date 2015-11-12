import java.io.File;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.reflect.TypeToken;

public class Tickets implements JSONFile {
	private List<Ticket> list;
    private Type Ticketlist = new TypeToken<ArrayList<Ticket>>() {}.getType(); // needed for gson to load into Arraylist
    private File JSONFile = new File("tickets.json");

	public Tickets() {
    	list = (List<Ticket>) load(JSONFile, Ticketlist);
	}
	
	public Ticket getTicketType(String type) {
		for (Ticket ticket : list) {
			if (ticket.getType().equals(type)) return ticket;
		}
		return null;
	}
	
	public List<Ticket> getAvailableTickets(Date session, Holiday holiday, boolean threeD, boolean blockbuster) {
    	List<Ticket> tickets = new ArrayList<Ticket>();
        SimpleDateFormat df = new SimpleDateFormat("u");
        int dayOfWeek = Integer.parseInt(df.format(session));
        df = new SimpleDateFormat("EEE");
    	boolean evening = isAfterSix(session);

        
    	if (holiday != null) {
			if (threeD) tickets.add(getTicketType("PH/EVE 3D"));
			else tickets.add(getTicketType("PH/EVE"));
    	} else {
    		if (threeD) {
    			if (dayOfWeek <= 4) tickets.add(getTicketType("Mon-Thu 3D"));
    			else tickets.add(getTicketType("Weekend 3D"));
    			
    			if (!evening) tickets.add(getTicketType("Student 3D"));
    		} else {
    			if (dayOfWeek <= 3) tickets.add(getTicketType("Mon-Wed"));
    			if (dayOfWeek == 4 || (dayOfWeek == 5 && !evening)) tickets.add(getTicketType("Thu-Fri"));
    			if ((dayOfWeek == 5 && evening) || dayOfWeek >= 6) tickets.add(getTicketType("Weekend"));
    			if (dayOfWeek <= 5 && !evening) {
    				tickets.add(getTicketType("Student"));
    				tickets.add(getTicketType("Senior Citizen"));
    			}
    		}
    	}
    	/*
    	if (blockbuster) {
    		for (Ticket ticket : tickets) ticket.incPrice(1.0);
    	}
    	*/
		
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
