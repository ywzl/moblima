import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class Holidays implements JSONFile {
	List<Holiday> list;
	Type Holidaylist = new TypeToken<ArrayList<Holiday>>(){}.getType(); // needed for gson to load into Arraylist
	File JSONFile = new File("holidays.json");

	public Holidays() {
		list = (List<Holiday>) load(JSONFile, Holidaylist);
	}
	
	public void addHoliday(String name, Date date) {
		list.add(new Holiday(name, date));
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			Holiday holiday = list.get(i);
			System.out.println(" " + i + ": " + holiday.getName() + " " + holiday.getDate());
		}
	}
}
