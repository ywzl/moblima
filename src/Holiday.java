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
}
