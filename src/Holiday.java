import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Holiday {
	private String name;
	private Date date;
	
	public Holiday(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateParsed() {
		DateFormat df = new SimpleDateFormat("dd-MM");
		return df.format(date);
	}
}
