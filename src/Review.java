public class Review {

    private String movieGoer;
    private int rating;
    private String text;

    public Review() {

    }

    public Review(String movieGoer, int rating, String text) {
        this.movieGoer = movieGoer;
        this.rating = rating;
        this.text = text;
    }
    
    /**
     * @return the movieGoer
     */
    public String getMovieGoer() {
        return movieGoer;
    }

    /**
     * @param movieGoer the movieGoer to set
     */
    public void setMovieGoer(String movieGoer) {
        this.movieGoer = movieGoer;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

}
