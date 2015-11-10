
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
