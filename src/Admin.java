import java.util.List;
import java.util.Scanner;

public class Admin {
	static Movies movies = new Movies();
	static Cineplexes cineplexes = new Cineplexes();
	
	public static void main(String[] args) {
		displayCineplexMenu();
	}
	
	public void displayMovieMenu() {
		
	}
	
	public static void displayCineplexMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		while(choice != -1) {
			System.out.println("==========Cineplex Menu==========");
			cineplexes.displayList();
			System.out.println("-1: Exit");
			System.out.print("Choice: ");
			choice = sc.nextInt();
			
			int cineplexIndex = choice;
			Cineplex cineplex = cineplexes.getCineplex(cineplexIndex);
			
			System.out.println(cineplex.getName());
			
			System.out.println(" 0: Movie Listing");
			System.out.println(" 1: Showtimes");
			System.out.println("-1: Exit");
			System.out.print("Choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 0:
					//displayMovieListing(cineplex.getMovieListings(), movies.getList());
					
						
					
					break;
			}
			
			
		}
	}
	
	public static void displayMovieListing(List<Integer> movieListing, List<Movie> moviesList) {
		for (int i=0; i<movieListing.size(); i++) {
			int movieIndex = movieListing.get(i);
			String movieTitle = moviesList.get(movieIndex).getTitle();
			System.out.println(movieTitle);	
		}
	}
	
}
