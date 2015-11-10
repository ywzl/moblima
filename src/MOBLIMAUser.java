
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MOBLIMAUser {

    static Movies movies = new Movies();

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
                                    System.out.print("Press 1 to Add Review else ANY key to go back: ");

                                    int reviewOption = 0;
                                    try {
                                        reviewOption = scanner.nextInt();
                                        if (reviewOption == 1) {
                                            System.out.println("- NEW REVIEW -");
                                            String name = "";
                                            int rating = 0;
                                            String reviewText = "";
                                            scanner.nextLine(); //flush
                                            System.out.print("Enter your name: ");
                                            name = scanner.nextLine();
                                            System.out.println("NAME: "+ name);
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
                                        }
                                    } catch (InputMismatchException inputMismatchException) {
                                        scanner.nextLine();
                                        break;
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

}
