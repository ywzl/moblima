import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lloyd
 */
public class Holiday {
	private String name;
	private Date date;
	
    /**
     *
     * @param name
     * @param date
     */
    public Holiday(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	
    /**
     *
     * @return
     */
    public String getName() {
		return name;
	}
	
    /**
     *
     * @return
     */
    public Date getDate() {
		return date;
	}
	
    /**
     *
     * @param date
     */
    public void setDate(Date date) {
		this.date = date;
	}
	
    /**
     *
     * @return
     */
    public String getDateParsed() {
		DateFormat df = new SimpleDateFormat("dd-MM");
		return df.format(date);
	}
}
