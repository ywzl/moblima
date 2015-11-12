
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class Movies implements JSONFile {

    private List<Movie> list;
    private Type Movielist = new TypeToken<ArrayList<Movie>>() {}.getType(); // needed for gson to load into Arraylist
    private File JSONFile = new File("movies.json");

    public Movies() {
    	list = (List<Movie>) load(JSONFile, Movielist);
    }

    public void addMovie(Movie movie) {
        list.add(movie);
        save(JSONFile, list);
    }
    
    public void addReview(int movieId, Review review) {
        for (Movie movie : list) {
            if (movie.getMovieId() == movieId) {
                movie.getReviews().add(review);
                break;
            }
        }
        save(JSONFile, list);
    }
    
    public void updateMovie(int movieIndex, Movie updatedMovie) {
    	list.set(movieIndex, updatedMovie);
    	save(JSONFile, list);
    }

    public Movie getMovie(int index) {
        return list.get(index);
    }
    
    public Movie getMovieById(int id) {
    	Movie movie = null;
    	for (Movie m : list) {
    		if (m.getMovieId() == id) return m;
    	}
    	return movie;
    }
    
    public int getNewMovieId() {
    	return list.size()+1;
    }
    
    public void incrementSales(int movieId) {
    	getMovieById(movieId).incrementSales();
    	save(JSONFile, list);
    }

    public List<Movie> getList() {
    	return list;
    }
    
    public void displayTopSales() {
    	List<Movie> sortedList = getListTopSales();
    	for (int i=0; i<sortedList.size(); i++) {
    		Movie movie = sortedList.get(i);
    		System.out.println((i+1) + ". " + movie.getTitle() + " Sales: " + movie.getTicketsSold());
    	}
    	System.out.println();
    }
    
    public List<Movie> getListTopSales() {
    	List<Movie> sortedList = list;
    	Collections.sort(sortedList, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o2.getTicketsSold() - o1.getTicketsSold();
			}
    	});
    	if (sortedList.size() > 5) sortedList = sortedList.subList(0, 5);
    	return sortedList;
    }
    
    public void displayTopRated() {
    	List<Movie> sortedList = getListTopRated();
    	for (int i=0; i<sortedList.size(); i++) {
    		Movie movie = sortedList.get(i);
    		System.out.println((i+1) + ". " + movie.getTitle() + " Rating: " + movie.getOverallRating() + "/5");
    	}
    	System.out.println();
    }
    
    public List<Movie> getListTopRated() {
    	List<Movie> sortedList = list;
    	Collections.sort(sortedList, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return (int) (o2.getOverallRating() - o1.getOverallRating());
			}
    	});
    	if (sortedList.size() > 5) sortedList = sortedList.subList(0, 5);
    	return sortedList;
    }
    
    public void removeMovie(int movieIndex) {
    	list.remove(movieIndex);
    	save(JSONFile, list);
    }
    
    // Showing list = movies that can be bought (NOW_SHOWING and PREVIEW)
    public void displayListShowing() {
    	List<Movie> showingList = getListShowing();
    	for (int i=0; i<showingList.size(); i++) {
    		System.out.println((i+1) + ". " + showingList.get(i).getTitle());
    	}
    	System.out.println();
    }
    
    public List<Movie> getListShowing() {
    	List<Movie.ShowingStatus> statuses = new ArrayList<Movie.ShowingStatus>();
    	statuses.add(Movie.ShowingStatus.NOW_SHOWING);
    	statuses.add(Movie.ShowingStatus.PREVIEW);
    	return getFilteredList(statuses);
    }
    
    public void displayFilteredList(List<Movie.ShowingStatus> statuses) {
    	List<Movie> filteredList = getFilteredList(statuses);
    	for (int i=0; i<filteredList.size(); i++) {
    		System.out.println((i+1) + ". " + filteredList.get(i).getTitle());
    	}
    	System.out.println();
    }
    
    public List<Movie> getFilteredList(List<Movie.ShowingStatus> statuses) {
        List<Movie> filteredList = new ArrayList<Movie>();
        for (Movie movie : list) {
        	Movie.ShowingStatus status = movie.getShowingStatus();
        	if (statuses.contains(status)) {
        		filteredList.add(movie);
        	}
        }
        return filteredList;
    }

    public void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).getTitle());
        }
    }
    
    public void displayListStatus() {
        for (int i = 0; i < list.size(); i++) {
        	Movie movie = list.get(i);
            System.out.println((i+1) + ". " + movie.getTitle() + " [" + movie.getShowingStatus() + "] -ticketsSold: " + movie.getTicketsSold());
        }
		System.out.println();
    }
}
