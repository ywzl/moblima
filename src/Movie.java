import java.text.DecimalFormat;
import java.util.List;

public class Movie {

    public enum AgeRating {
        G, PG, PG13, NC16, M18, R21
    }
    
    private String title;
    private String synopsis;
    private String director;
    private List<String> casts;
    private String genre;
    private AgeRating ageRating;
    private List<Review> reviews;

    public Movie() {
    }

    public Movie(String title, String synopsis, String director, List<String> casts, String genre, AgeRating ageRating, List<Review> reviews) {
        this.title = title;
        this.synopsis = synopsis;
        this.director = director;
        this.casts = casts;
        this.genre = genre;
        this.ageRating = ageRating;
        this.reviews = reviews;
    }
    
    public void displayMovieDetails() {
        System.out.println(" - DETAILS -");
        System.out.print("Cast: ");
        String delimiter = "";
        DecimalFormat df = new DecimalFormat("#.####");
        for (int i = 0; i < casts.size(); i++) {
            System.out.print(delimiter + casts.get(i));
            delimiter = ", ";
        }
        System.out.println("Director: " + director);
        System.out.println("Genre: " + genre);
        System.out.print("Overall rating: ");
        if (reviews.size() > 1) {
            System.out.print(df.format(getOverallRating()) + "/5\t" + reviews.size() + " review(s)");
        } else if (reviews.size() <= 1){
            System.out.print("N/A");
        }
        System.out.println("");
        System.out.println("- SYNOPSIS -\n" + synopsis + "\n");
        System.out.println("- REVIEWS -");
        for (Review review : reviews) {
            System.out.println("Review by: " + review.getMovieGoer() + "\tRating:" + review.getRating() + "/5\n" + review.getText() + "\n");
        }
    }
    
    public double getOverallRating() {
        double overallRating = 0.0;
        for (Review review : reviews) {
            overallRating += review.getRating();
        }
        overallRating = overallRating/reviews.size();
        return overallRating;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the casts
     */
    public List<String> getCasts() {
        return casts;
    }

    /**
     * @param casts the casts to set
     */
    public void setCasts(List<String> casts) {
        this.casts = casts;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the ageRating
     */
    public AgeRating getAgeRating() {
        return ageRating;
    }

    /**
     * @param ageRating the rating to set
     */
    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    /**
     * @return the reviews
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}