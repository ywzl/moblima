import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import com.google.gson.reflect.TypeToken;

public class Holidays implements JSONFile {
	List<Holiday> list;
	Type Holidaylist = new TypeToken<ArrayList<Holiday>>(){}.getType(); // needed for gson to load into Arraylist
	File JSONFile = new File("holidays.json");

	public Holidays() {
		list = (List<Holiday>) load(JSONFile, Holidaylist);
	}
	
	public void addHoliday(Holiday holiday) {
		list.add(holiday);
		save(JSONFile, list);
	}
	
	public void setDate(int holidayIndex, Date newDate) {
		Holiday holiday = list.get(holidayIndex);
		holiday.setDate(newDate);
		save(JSONFile, list);
	}
	
	public void removeHoliday(int holidayIndex) {
		list.remove(holidayIndex);
		save(JSONFile, list);
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			Holiday holiday = list.get(i);
			System.out.println((i+1) + ": " + holiday.getName() + " " + holiday.getDateParsed());
		}
	}
	
	public Holiday isHoliday(Date date) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.setTime(date);
		for (Holiday holiday : list) {
			cal2.setTime(holiday.getDate());
			if (cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) || cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)-1) {
				return holiday;
			}
		}
		return null;
	}
}
