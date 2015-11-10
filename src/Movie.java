import java.util.List;

public class Movie {
	private String title;
	private String[] statuses = {"Coming Soon", "Preview", "Now Showing", "End Of Showing"};
	private String status; // e.g. (Coming Soon, Preview, Now Showing, End Of Showing)
	private String synopsis;
	private String director;
	private List<String> cast;
	private String genre;
	private String[] ratings = {"G", "PG", "PG13", "NC16", "M18", "R21"};
	private String rating; // e.g.(PG, NC16, R21)
	private List<Review> reviews;
	
	public Movie() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// TODO CREATE SET AND GET FOR ALL
	
	public String getStatus() {
		return status;
	}
	
}
