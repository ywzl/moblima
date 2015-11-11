import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
            System.out.println("2. Cineplex Listing");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            try {
                option = scanner.nextInt();
                System.out.println();
                
                switch (option) {
                    case 1:
                    	int newMovieId = movies.getNewMovieId();
                    	scanner.nextLine();
                    	System.out.println();
                    	
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
                    	int cineplexChoice = -1;
                    	int movieId;
                    	do {
                            System.out.println("- Cineplex Listings -");
                            cineplexes.displayList();
                            System.out.print("Select Cineplex no. (0 to go back): ");
                            try {
                            	cineplexChoice = scanner.nextInt();
                            	System.out.println();
                            	
                                if (cineplexChoice > 0 && cineplexChoice <= cineplexes.getList().size()) {
                                	cineplexChoice--;
                                	Cineplex cineplex = cineplexes.getCineplex(cineplexChoice);
                                	System.out.println("Cineplex chosen: " + cineplex.getName());
                    				List<Movie> movieList = getMovieList(cineplex.getMovieListings());

                                	int cineplexOption = -1;
                                	do {
                                        System.out.println("1. Movie Listing");
                                        System.out.println("2. Showtimes");
                                        System.out.print("Select option (0 to go back): ");
                                        
                                        try {
                                        	cineplexOption = scanner.nextInt();
                                        	System.out.println();
                                        	
                                        	switch(cineplexOption) {
                                        		case 1:
                                        			System.out.println("- Movie Listing for " + cineplex.getName() + " -");
                                        			int movieOption = -1;
                                        			do {
                                        				movieList = getMovieList(cineplex.getMovieListings());
                                        				displayMovieList(movieList);
                                            			System.out.println();
                                        				System.out.println("- Option -");
                                                        System.out.println("1. Add Movie Listing");
                                                        System.out.println("2. Remove Movie Listing");
                                                        System.out.print("Select option (0 to go back): ");
                                                        System.out.println();
                                                        try {
                                                        	movieOption = scanner.nextInt();
                                                        	
                                                        	switch (movieOption) {
                                                        		case 1:
                                                        			System.out.println("- Recent Movies -");
                                                        			List<Movie> moviesToAdd = movies.getRecentMovies(); 
                                                        			moviesToAdd.removeAll(movieList);
                                                        			displayMovieList(moviesToAdd);
                                                        			
                                                        			System.out.print("Choose movie to add: ");
                                                        			movieId = moviesToAdd.get(scanner.nextInt()-1).getMovieId();
                                                                    cineplexes.addMovieListing(cineplexChoice, movieId);
                                                                    System.out.println();
                                                                    break;
                                                                    
                                                        		case 2:
                                                        			System.out.print("Choose movie to remove: ");
                                                                    movieId = cineplex.getMovieListings().get(scanner.nextInt()-1);
                                                                    cineplexes.removeMovieListing(cineplexChoice, movieId);
                                                        			break;
		                                                			
		                                                		case 0:
		                                                			break;
		                                                		default:
		                                                			System.out.println("Invalid option! Please select again!");
		        	                                                break;
                                                        	}
                                                        } catch (InputMismatchException inputMismatchException) {
                                                            System.out.println("Invalid input! Please enter a number!");
                                                            scanner.next();
                                                        }
                                        			} while (movieOption != 0);
                                        			break;
                                        			
                                        		case 2:
                                        			System.out.println("- Showtime Listing for " + cineplex.getName() + " -");
                                        			int showtimeOption = -1;
                                        			do {
                                        				
                                        				List<Showtime> showtimes = cineplex.getShowtimes();
                                        				displayShowtimes(showtimes);
                                            			
                                            			System.out.println();
                                        				System.out.println("- Option -");
                                                        System.out.println("1. Add Showtime");
                                                        System.out.println("2. Remove Showtime");
                                                        System.out.print("Select option (0 to go back): ");
                                                        try {
                                                        	showtimeOption = scanner.nextInt();
                                                            System.out.println();
                                                            
                                                        	switch (showtimeOption) {
                                                        		case 1:
                                                        			System.out.println("Create Showtime for: ");
                                                    				movieList = getMovieList(cineplex.getMovieListings());
                                                    				displayMovieList(movieList);
                                                    				System.out.print("Movie Choice: ");
                                                                    movieId = cineplex.getMovieListings().get(scanner.nextInt()-1);
                                                                    
                                                                    scanner.nextLine();
                                                                    
                                                                    System.out.print("Input date (ddMMyy): ");
                                                                    String date = scanner.nextLine();
                                                                    
                                                                    System.out.print("Input time (HHmm): ");
                                                                    String time = scanner.nextLine();
                                                                    
                                                                    SimpleDateFormat df = new SimpleDateFormat("ddMMyyHHmm");
                                                                    Date session = df.parse(date+time);
                                                                                                                                    
                                                                    System.out.println("Cinema: ");
                                                                    cineplex.displayCinemas();
                                                                    System.out.print("Cinema Choice: ");
                                                                    int cinemaIndex = scanner.nextInt()-1;
                                                                    
                                                                    Showtime showtime = new Showtime(cineplex.getCinema(cinemaIndex), movieId, session);
                                                                    cineplexes.addShowtime(cineplexChoice, showtime);
                                                                    break;
                                                                    
                                                        		case 2:
                                                        			System.out.print("Choose Showtime to remove: ");
                                                        			int showtimeIndex = scanner.nextInt()-1;
                                                        			cineplexes.removeShowtime(cineplexChoice, showtimeIndex);
                                                        			break;
		                                                			
		                                                		case 0:
		                                                			break;
		                                                		default:
		                                                			System.out.println("Invalid option! Please select again!");
		        	                                                break;
                                                        	}
                                                        } catch (InputMismatchException inputMismatchException) {
                                                            System.out.println("Invalid input! Please enter a number!");
                                                            scanner.next();
                                                        } catch (ParseException e) {
                                                        	System.out.println("Invalid Date");
														}
                                        			} while (showtimeOption != 0);
                                        			break;
                                        			
                                        		case 0:
                                        			break;
                                        		default:
                                        			System.out.println("Invalid option! Please select again!");
	                                                break;
                                        	}
                                        } catch (InputMismatchException inputMismatchException) {
                                            System.out.println("Invalid input! Please enter a number!");
                                            scanner.next();
                                        }
                                        
                                        
                                        
                                	} while (cineplexOption != 0);
                                	
                                	
                                } else if (cineplexChoice < 0 || cineplexChoice > cineplexes.getList().size()) {
                                    System.out.println("Invalid option! Please enter a valid cineplex number.");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid input! Please enter a number!");
                                scanner.next();
                            }
                        } while (cineplexChoice != 0);
                    	
                    	
                    	
                        int movieOption = -1;
                        do {
                            System.out.println("- Movie Listings -");
                            List<Movie> recentMovies = movies.getRecentMovies();
                            for (int i = 0; i < recentMovies.size(); i++) {
                                Movie movie = recentMovies.get(i);
                                System.out.println((i + 1) + ". " + movie.getTitle());
                            }
                            System.out.print("Select movie no. (0 to go back): ");
                            try {
                                movieOption = scanner.nextInt();
                                if (movieOption > 0 && movieOption <= recentMovies.size()) {
                                	System.out.println("Movie chosen: " + recentMovies.get(movieOption-1).getTitle());
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
    }
    
    public static void displayShowtimes(List<Showtime> showtimes) {
    	for (int i=0; i<showtimes.size(); i++) {
    		Showtime showtime = showtimes.get(i);
    		Movie movie = movies.getMovieById(showtime.getMovieId());
    		System.out.println((i+1) + ". " + showtime.getSession() + " " + movie.getTitle() + " " + showtime.getCinemaName());
    	}
    }
    
}
