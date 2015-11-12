
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MOBLIMAUser {

    static Movies movies = new Movies();
    static Cineplexes cineplexes = new Cineplexes();

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int option;
        boolean exit = false;
        do {
            System.out.println("- MOBLIMA -");
            System.out.println("Select an option below: ");
            System.out.println("1. Make new booking");
            System.out.println("2. Show movie listings");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            try {
                option = scanner.nextInt();
                System.out.println("");
                switch (option) {
                    case 1:
                    	int cineplexOption = -1;
                        do {
                        	System.out.println("- Cineplex Listings -");
                        	cineplexes.displayList();
                            System.out.print("Select Cineplex (0 to go back): ");
                            try{
                            	cineplexOption = scanner.nextInt();
                            	System.out.println();
                            	if (cineplexOption > 0 && cineplexOption <= cineplexes.getList().size()) {
                            		Cineplex cineplex = cineplexes.getCineplex(cineplexOption-1);
                            		List<Movie> movieList = getMovieList(cineplex.getMovieListings());
                            		System.out.println("- " + cineplex.getName() + " -");
                            		System.out.println("- Movie Listing -");
                            		displayMovieList(movieList);
                                    System.out.print("Select Movie (0 to go back): ");
                            		int movieIndex = -1;
                            		do {
                            			try {
                            				movieIndex = scanner.nextInt();
                                        	if (movieIndex > 0 && movieIndex <= movieList.size()) {
                                				int movieId = movieList.get(movieIndex-1).getMovieId();
                                				Movie movie = movies.getMovieById(movieId);
                                				System.out.println("- Showtimes for " + movie.getTitle() + " -");
                                				List<Showtime> showtimes = cineplex.getShowtimesForMovie(movieId);
                                				cineplex.displayShowtimesForMovie(movieId);
                                                System.out.print("Select Showtime (0 to go back): ");
                                				int showtimeIndex = -1;
                                				do {
                                					try {
                                						showtimeIndex = scanner.nextInt();
                                                    	if (showtimeIndex > 0 && showtimeIndex <= showtimes.size()) {
                                                    		Showtime showtime = showtimes.get(showtimeIndex-1);
                                                    		System.out.println("- " + movie.getTitle() + " " + showtime.getSession() + " at " + cineplex.getName() + " -" );
                                                    		showtime.displaySeats();
                                                    	} else {
                                                    		System.out.println("Invalid input!");
                                                    	}
                                					} catch (InputMismatchException inputMismatchException) {
                                                        System.out.println("Invalid input! Please enter a number!");
                                                        scanner.next();
                                                    }
                                				} while (showtimeIndex != 0);
                                				
                                				
                                        	} else {
                                        		System.out.println("Invalid input!");
                                        	}
                            			} catch (InputMismatchException inputMismatchException) {
                                            System.out.println("Invalid input! Please enter a number!");
                                            scanner.next();
                                        }
                            			
                            		} while (movieIndex != 0);
                            		
                            		
                            		
                            	} else if (cineplexOption < 0 || cineplexOption > cineplexes.getList().size()) {
                                    System.out.println("Invalid option! Please enter a valid movie number.");
                                }
                            	
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid input! Please enter a number!");
                                scanner.next();
                            }
                        } while (cineplexOption != 0);
                        break;
                        
                    case 2:
                        int movieOption = -1;
                        do {
                            System.out.println("- Movie Listings -");
                            List<Movie> recentMovies = movies.getRecentMovies();
                            for (int i = 0; i < recentMovies.size(); i++) {
                                Movie movie = recentMovies.get(i);
                                System.out.println((i + 1) + ". " + movie.getTitle());
                            }
                            System.out.print("Select movie no. to view details (0 to go back): ");
                            try {
                                movieOption = scanner.nextInt();
                                if (movieOption > 0 && movieOption <= recentMovies.size()) {
                                    System.out.println("");
                                    Movie m = recentMovies.get(movieOption - 1);
                                    m.displayMovieDetails();
                                    System.out.print("Press 1 to Add Review else press ENTER to go back: ");

                                    scanner.nextLine();
                                    String line = scanner.nextLine();
                                    if (line.equals("1")) {
                                        System.out.println("- NEW REVIEW -");
                                        String name = "";
                                        int rating = 0;
                                        String reviewText = "";
                                        System.out.print("Enter your name: ");
                                        name = scanner.nextLine();
                                        System.out.println("NAME: " + name);
                                        do {
                                            System.out.print("Enter your rating (out of 5): ");
                                            try {
                                                rating = scanner.nextInt();
                                            } catch (InputMismatchException inputMismatchException) {
                                                rating = -1;
                                                scanner.next();
                                            }
                                            if (rating < 0 || rating > 5) {
                                                System.out.println("Please enter a rating within 0 to 5 (inclusive).");
                                            }
                                        } while (rating < 0 || rating > 5);

                                        System.out.print("Enter your review: ");
                                        scanner.nextLine(); //flush
                                        reviewText = scanner.nextLine();
                                        System.out.println("REVIEW: " + reviewText);

                                        Review review = new Review(name, rating, reviewText);
                                        movies.addReview(m.getMovieId(), review);
                                        System.out.println("Thank you " + name + "! Your review has been submitted!");
                                    }

                                } else if (movieOption < 0 || movieOption > recentMovies.size()) {
                                    System.out.println("Invalid option! Please enter a valid movie number.");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid input! Please enter a number!");
                                scanner.next();
                            }
                        } while (movieOption != 0);
                        System.out.println("");
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Thanks for using MOBLIMA!");
                        break;
                    default:
                        System.out.println("Invalid option! Please select again!");
                        break;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input! Please enter a number!");
                scanner.next();
            }
        } while (!exit);
    }
    
    public static List<Movie> getMovieList(List<Integer> movieListing) {
    	List<Movie> movieList = new ArrayList<Movie>();
		for (Integer id : movieListing) {
			Movie movie = movies.getMovieById(id);
			movieList.add(movie);
		}
		return movieList;
    }
    
    public static void displayMovieList(List<Movie> movieList) {
    	if (movieList.size() > 0) {
			for (int i=0; i<movieList.size(); i++) {
				System.out.println((i+1) + ". " + movieList.get(i).getTitle());
			}
		} else {
			System.out.println("No Movies Listed at this Cineplex");
		}
    	System.out.println();
    }
}
