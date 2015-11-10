
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class Movies implements JSONFile {

    private List<Movie> list;
    Type Movielist = new TypeToken<ArrayList<Movie>>(){}.getType(); // needed for gson to load into Arraylist
    File JSONFile = new File("movies.json");

    public Movies() {
        list = (List<Movie>) load(JSONFile, Movielist);
    }

    public void addMovie(Movie movie) {
        list.add(movie);
        save(JSONFile, list);
    }

    public Movie getMovie(int index) {
        return list.get(index);
    }

    public List<Movie> getRecentMovies() {
        List<Movie> recentMovies = new ArrayList<>();
        for (Movie movie : list) {
            if (movie.getShowingStatus() != Movie.ShowingStatus.END_OF_SHOWING) {
                recentMovies.add(movie);
            }
        }
        return recentMovies;
    }
    
    public void displayRecentMovies() {
        List<Movie> recentMovies = getRecentMovies();
        for (int i = 0; i < recentMovies.size(); i++) {
            Movie movie = recentMovies.get(i);
            System.out.println((i+1)+". " + movie.getTitle());
        }
    }
    
    public void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(" " + i + ": " + list.get(i).getTitle());
        }
    }
}
