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
    static Holidays holidays = new Holidays();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean exit = false;
        
        do {
            System.out.println("- MOBLIMA Admin -");
            System.out.println("Select an option below: ");
            System.out.println("1. Movies");
            System.out.println("2. Cineplexes");
            System.out.println("3. Holidays");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            try {
                option = scanner.nextInt();
                System.out.println();
                
                switch (option) {
                    case 1:
                    	int movieOption = -1;
                    	do {
                    		System.out.println("- Movies Options -");                    		
                    		System.out.println("1. list All Movies");
                    		System.out.println("2. List [Now Showing]");
                    		System.out.println("3. List [End of Showing]");
                    		System.out.println("4. Add Movie");
                    		System.out.println("5. Edit Movie");
                            System.out.print("Select option (0 to go back): ");
                            movieOption = scanner.nextInt();
                            System.out.println();
                            List<Movie.ShowingStatus> statuses;
                            
                            switch (movieOption) {
                            	case 1:
                            		System.out.println("- All Movies -");
                            		movies.displayListStatus();
                            		break;
                            		
                            	case 2:
                            		System.out.println("- Now Showing -");
                            		statuses = new ArrayList<Movie.ShowingStatus>();
                            		statuses.add(Movie.ShowingStatus.NOW_SHOWING);
                            		movies.displayFilteredList(statuses);
                            		break;
                            		
                            	case 3:
                            		statuses = new ArrayList<Movie.ShowingStatus>();
                            		statuses.add(Movie.ShowingStatus.END_OF_SHOWING);
                            		System.out.println("- End of Showing -");
                            		movies.displayFilteredList(statuses);
                            		break;
                            		
                            	case 4:
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
                                
                            	case 5:
                            		System.out.println("- Edit Movie -");
                            		movies.displayListStatus();
                            		System.out.print("Select Movie to edit: ");
                            		int movieIndex = scanner.nextInt()-1;
                            		Movie movie = movies.getMovie(movieIndex);
                            		int editOption = -1;
                            		do {
                            			System.out.println("- Editing: " + movie.getTitle() + " -");
                                		System.out.println("1. Title: " + movie.getTitle());
                                		System.out.println("2. Status: " + movie.getShowingStatus());
                                		System.out.println("3. Rating: " + movie.getAgeRating());
                                		System.out.println("4. Cast: " + movie.getCasts());
                                		System.out.println("5. Director: " + movie.getDirector());
                                		System.out.println("6. Synopsis: " + movie.getSynopsis());
                                		System.out.print("Item to edit (0 to go back): ");
                                		editOption = scanner.nextInt();
                                		scanner.nextLine();
                                		
                                		switch (editOption) {
                                			case 1:
                                				System.out.print("New Title: ");
                                				String newTitle = scanner.nextLine();
                                				movie.setTitle(newTitle);
                                				movies.updateMovie(movieIndex, movie);
                                				break;
                                				
                                			case 2:
                                				Movie.ShowingStatus newStatus = chooseStatus();
                                				movie.setShowingStatus(newStatus);
                                				movies.updateMovie(movieIndex, movie);
                                				break;
                                				
                                			case 3:
                                				Movie.AgeRating newRating = chooseRating();
                                				movie.setAgeRating(newRating);
                                				movies.updateMovie(movieIndex, movie);
                                				break;
                                				
                                			case 4:
                                        		System.out.println("Cast(separate by , ): ");
                                        		List<String> newCast = Arrays.asList(scanner.nextLine().split(","));
                                        		movie.setCasts(newCast);
                                        		movies.updateMovie(movieIndex, movie);
                                        		break;
                                        		
                                			case 5:
                                				System.out.print("New Director: ");
                                				String newDirector = scanner.nextLine();
                                				movie.setTitle(newDirector);
                                				movies.updateMovie(movieIndex, movie);
                                				break;
                                				
                                			case 6:
                                				System.out.print("New Synopsis: ");
                                				String newSynopsis = scanner.nextLine();
                                				movie.setTitle(newSynopsis);
                                				movies.updateMovie(movieIndex, movie);
                                				break;
                                				
                                			case 0:
                                				break;
                                				
                                			default:
                                                System.out.println("Invalid option! Please select again!");
                                				break;
                                		}
                            			
                            		} while (editOption != 0);
                            		System.out.println();
                            		break;
                            		
                            	case 0:
                    				break;
                    			default:
                                    System.out.println("Invalid option! Please select again!");
                    				break;
                            }

                    	} while (movieOption != 0);
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
                                        			movieOption = -1;
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
                                                                    
                                                                    System.out.print("Input date (DDMMYY): ");
                                                                    String date = scanner.nextLine();
                                                                    
                                                                    System.out.print("Input time (HHMM): ");
                                                                    String time = scanner.nextLine();
                                                                    
                                                                    SimpleDateFormat df = new SimpleDateFormat("ddMMyyHHmm");
                                                                    Date session = df.parse(date+time);
                                                                                                                                    
                                                                    System.out.println("Cinema: ");
                                                                    cineplex.displayCinemas();
                                                                    System.out.print("Cinema Choice: ");
                                                                    int cinemaIndex = scanner.nextInt()-1;
                                                                    System.out.println();
                                                                    
                                                                    List<Ticket> tickets = new ArrayList<Ticket>();
                                                                    scanner.nextLine();
                                                                	int ticketOption = -1;
                                                                    do {
                                                                    	System.out.println("- Ticket types -");
                                                                    	for (int i=0; i<tickets.size(); i++) {
                                                                    		Ticket ticket = tickets.get(i);
                                                                    		System.out.println((i+1) + ". " + ticket.getType() + " $" + ticket.getPrice());
                                                                    	}
                                                                    	df = new SimpleDateFormat("EEE");
                                                                    	
                                                                    	System.out.print("It is " + df.format(session) + ", " + holidays.isHoliday(session));
                                                                    	
                                                                    	System.out.println();
                                                                    	System.out.println("- Option -");
                                                                    	System.out.println("1. Add ticket type");
                                                                    	System.out.println("2. Remove ticket type");
                                                                    	System.out.println("0. Exit");
                                                                    	System.out.print("Choice: ");
                                                                    	ticketOption = scanner.nextInt();
                                                                    	
                                                                    	switch (ticketOption) {
                                                                    		case 1:
                                                                    			scanner.nextLine();
                                                                    			System.out.print("Ticket type: ");
                                                                    			String type = scanner.nextLine();
                                                                    			
                                                                    			System.out.print("Price: ");
                                                                    			float price = scanner.nextFloat();
                                                                    			tickets.add(new Ticket(type, price));
                                                                    			
                                                                    			break;
                                                                    			
                                                                    		case 2:
                                                                    			System.out.print("Ticket to remove: ");
                                                                    			int ticketIndex = scanner.nextInt()-1;
                                                                    			tickets.remove(ticketIndex);
                                                                    			break;
                                                                    		case 0:
                                                                			default:
                                                                				break;
                                                                    	}
                                                                    	
                                                                    	
                                                                    } while (ticketOption != 0);
                                                                    
                                                                    
                                                                    Showtime showtime = new Showtime(cineplex.getCinema(cinemaIndex), movieId, session, tickets);
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
                        break;
                        
                    case 3:
                    	int holidaysOption = -1;
                    	do {
                    		System.out.println("- Holidays Listing -");
                        	holidays.displayList();
                        	System.out.println();
                        	System.out.println("- Option -");
                        	System.out.println("1. Add Holiday");
                        	System.out.println("2. Remove Holiday");
                        	System.out.println("0. Exit");
                        	System.out.print("Choice: ");
                        	
                        	try {
                        		holidaysOption = scanner.nextInt();
                        		switch (holidaysOption) {
                        			case 1:
                        				scanner.nextLine();
                            			System.out.print("Holiday name: ");
                            			String name = scanner.nextLine();
                            			
                                        System.out.print("Date (DDMM): ");
                                        SimpleDateFormat df = new SimpleDateFormat("ddMM");
                                        Date date = df.parse(scanner.nextLine());
                                        
                                        Holiday holiday = new Holiday(name, date);
                                        System.out.println(holiday.getName());
                                        holidays.addHoliday(holiday);
                        				break;
                        				
                        			case 2:
                        				System.out.print("Holiday to remove: ");
                        				int holidayIndex = scanner.nextInt()-1;
                        				holidays.removeHoliday(holidayIndex);
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
                    	} while (holidaysOption != 0);
                    	break;
                    	
                    case 4:
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
    
    public static Movie.ShowingStatus chooseStatus() {
        Scanner scanner = new Scanner(System.in);
    	Movie.ShowingStatus status = null;
    	System.out.println("Select Status: ");
    	System.out.println("1. Coming Soon");
    	System.out.println("2. Preview");
    	System.out.println("3. Now Showing");
    	System.out.println("4. End of Showing");
    	System.out.print("Choice: ");
    	
    	try {
    		int choice = scanner.nextInt();
        	switch (choice) {
        		case 1:
        			status = Movie.ShowingStatus.COMING_SOON;
        			break;
        			
        		case 2:
        			status = Movie.ShowingStatus.PREVIEW;
        			break;
        		
        		case 3:
        			status = Movie.ShowingStatus.NOW_SHOWING;
        			break;
        			
        		case 4:
        			status = Movie.ShowingStatus.END_OF_SHOWING;
        			break;
        			
        		default:
                    System.out.println("Invalid option! Please select again!");
        			break;
        	}
    	} catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid input! Please enter a number!");
            scanner.next();
        }
    	scanner.close();
    	return status;
    }
    

    public static Movie.AgeRating chooseRating() {
        Scanner scanner = new Scanner(System.in);
    	Movie.AgeRating rating = null;
    	System.out.println("Select Status: ");
    	System.out.println("1. G");
    	System.out.println("2. PG");
    	System.out.println("3. PG13");
    	System.out.println("4. NC16");
    	System.out.println("5. M18");
    	System.out.println("6. R21");
    	System.out.print("Choice: ");
    	
    	try {
    		int choice = scanner.nextInt();
        	switch (choice) {
        		case 1:
        			rating = Movie.AgeRating.G;
        			break;
        			
        		case 2:
        			rating = Movie.AgeRating.PG;
        			break;
        		
        		case 3:
        			rating = Movie.AgeRating.PG13;
        			break;
        			
        		case 4:
        			rating = Movie.AgeRating.NC16;
        			break;

        		case 5:
        			rating = Movie.AgeRating.M18;
        			break;

        		case 6:
        			rating = Movie.AgeRating.R21;
        			break;
        			
        		default:
                    System.out.println("Invalid option! Please select again!");
        			break;
        	}
    	} catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid input! Please enter a number!");
            scanner.next();
        }
    	scanner.close();
    	return rating;
    }
    
}
