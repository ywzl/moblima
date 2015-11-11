import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lloyd
 */
public class MOBLIMAAdmin {
    static Cineplexes cineplexes = new Cineplexes();
    static Movies movies = new Movies();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean exit = false;
        
        do {
            System.out.println("- MOBLIMA Admin -");
            System.out.println("Select an option below: ");
            System.out.println("1. Add new movie");
            System.out.println("2. Add movie listing to cineplex");
            System.out.println("3. Add showtime to cineplex");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                    	int newMovieId = movies.getNewMovieId();
                    	scanner.nextLine();
                    	
                    	System.out.print("Title: ");
                    	String title = scanner.nextLine();
                    	
                    	System.out.print("Synopsis: ");
                    	String synopsis = scanner.nextLine();
                    	
                    	System.out.print("Director: ");
                    	String director = scanner.nextLine();
                    	
                    	System.out.print("Genre: ");
                    	String genre = scanner.nextLine();
                    	
                		System.out.println("Cast(separate by , ): ");
                		List<String> casts = Arrays.asList(scanner.nextLine().split(","));
                		
                		// For enum, need to use capitals and _ for spaces. Not sure how to solve this
                		System.out.print("Rating (");
                		for (Movie.AgeRating rating : Movie.AgeRating.values()) {
                		    System.out.print(rating + " ");
                		}
                		System.out.print("): ");
                		Movie.AgeRating rating = Movie.AgeRating.valueOf(scanner.nextLine());
                		
                		System.out.print("Showing Status (");
                		for (Movie.ShowingStatus status : Movie.ShowingStatus.values()) {
                		    System.out.print(status + " ");
                		}
                		System.out.print("): ");
                		Movie.ShowingStatus status = Movie.ShowingStatus.valueOf(scanner.nextLine());
                		
                		List<Review> reviews = new ArrayList<Review>();
                		
                		Movie newMovie = new Movie(newMovieId, title, synopsis, director, casts, genre, rating, status, reviews);
                    	movies.addMovie(newMovie);
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
                                    recentMovies.get(movieOption-1).displayMovieDetails();
                                    System.out.print("Press ENTER to continue.");
                                    scanner.nextLine();
                                } else if (movieOption < 0 || movieOption > recentMovies.size()) {
                                    System.out.println("Invalid option! Please enter a valid movie number.");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid input! Please enter a number!");
                                scanner.next();
                            }
                        } while (movieOption != 0);
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
    
}
