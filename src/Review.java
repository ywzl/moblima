
public class Review {
	private String movieGoer;
	private int rating;
	private String text;
	
	public Review() {
		
	}
	
	public int getRating() {
		return rating;
	}
	
	public void displayReview() {
		System.out.println(movieGoer);
		System.out.println(rating);
		System.out.println(text);
	}

}
