
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class Movies implements JSONFile {

    private List<Movie> list;
    Type Movielist = new TypeToken<ArrayList<Movie>>() {}.getType(); // needed for gson to load into Arraylist
    File JSONFile = new File("movies.json");

    public Movies() {
//        list = (List<Movie>) load(JSONFile, Movielist);
        list = new ArrayList<Movie>();
        Movie m = new Movie();
        
        //SPECTRE
        m.setTitle("SPECTRE");
        m.setDirector("Sam Mendes");
        m.setSynopsis("In SPECTRE, a cryptic message from Bond’s past sends him on a trail to uncover a sinister organization. While M battles political forces to keep the secret service alive, Bond peels back the layers of deceit to reveal the terrible truth behind SPECTRE.");
        m.setAgeRating(Movie.AgeRating.PG13);
        m.setGenre("Action");
        List<String> casts = new ArrayList<String>();
        casts.add("Daniel Craig");
        casts.add("Ralph Fiennes");
        casts.add("Ben Whishaw");
        casts.add("Naomie Harris");
        casts.add("Rory Kinnear");
        casts.add("Christoph Waltz");
        casts.add("Léa Seydoux");
        casts.add("Monica Bellucci");
        casts.add("David Bautista");
        casts.add("Andrew Scott");
        List<Review> reviews = new ArrayList<>();
        m.setReviews(reviews);
        m.setCasts(casts);
        m.setShowingStatus(Movie.ShowingStatus.NOW_SHOWING);
        list.add(m);
        
        //Legend
        m = new Movie();
        m.setTitle("Legend");
        m.setDirector("Brian Helgeland");
        m.setSynopsis("From Academy Award® winner Brian Helgeland (L.A. Confidential, Mystic River) and Working Title (The Theory of Everything) comes the true story of the rise and fall of London’s most notorious gangsters, Reggie and Ronnie Kray, both portrayed by Tom Hardy in a powerhouse double performance. Together, the Kray Twins take over the city. But as their reign expands, powerstruggles, fierce madness, and a woman diminishes their bond; the weak link that could cause their empire to collapse. Legend is a classic crime thriller taking us into the secret history of the 1960s and the extraordinary events that secured the infamy of the Kray twins.");
        m.setAgeRating(Movie.AgeRating.M18);
        m.setGenre("Crime");
        casts = new ArrayList<String>();
        casts.add("Tom Hardy");
        casts.add("Emily Browning");
        casts.add("Taron Egerton");
        casts.add("Colin Morgan");
        casts.add("David Thewlis");
        reviews = new ArrayList<>();
        m.setReviews(reviews);
        m.setCasts(casts);
        m.setShowingStatus(Movie.ShowingStatus.COMING_SOON);
        list.add(m);
        
        //The Martian
        m = new Movie();
        m.setTitle("The Martian");
        m.setDirector("Ridley Scott");
        m.setSynopsis("During a manned mission to Mars, Astronaut Mark Watney (Matt Damon) is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet. With only meager supplies, he must draw upon his ingenuity, wit and spirit to subsist and find a way to signal to Earth that he is alive. Millions of miles away, NASA and a team of international scientists work tirelessly to bring “the Martian” home, while his crewmates concurrently plot a daring, if not impossible rescue mission. As these stories of incredible bravery unfold, the world comes together to root for Watney’s safe return. Based on a best-selling novel, and helmed by master director Ridley Scott, THE MARTIAN features a star studded cast that includes Jessica Chastain, Kristen Wiig, Kate Mara, Michael Peña, Jeff Daniels, Chiwetel Ejiofor, and Donald Glover.");
        m.setAgeRating(Movie.AgeRating.PG13);
        m.setGenre("Adventure");
        casts = new ArrayList<String>();
        casts.add("Matt Damon");
        casts.add("Jessica Chastain");
        casts.add("Kristen Wiig");
        casts.add("Jeff Daniels");
        casts.add("Chiwetel Ejiofor");
        casts.add("Michael Pena");
        casts.add("Kate Mara");
        casts.add("Sean Bean");
        casts.add("Sebastian Stan");
        casts.add("Mackenzie Davis");
        reviews = new ArrayList<>();
        reviews.add(new Review("Sridhar_Rajamani", 3, "Innovative plot."));
        reviews.add(new Review("fat_hamster", 5, "Plot was great. Taught us not to give up and fight for survival using the knowledge of science and botany. There were some intense moments. Enjoyed this movie."));
        reviews.add(new Review("yyhoe", 5, "Love it. Show us what we can do if determined"));
        reviews.add(new Review("theneelie", 4, "Great movie, learnt some scientific knowledge from the show. More surprises."));
        reviews.add(new Review("ahpapa", 4, "Worth the time. Highly recommended."));
        reviews.add(new Review("onlysue", 4, "Its indeed a great movie worth watching! The entire storyline was exciting & intense too. Highly recommended!"));
        m.setReviews(reviews);
        m.setCasts(casts);
        m.setShowingStatus(Movie.ShowingStatus.NOW_SHOWING);
        list.add(m);
        
        //Burnt 
        m = new Movie();
        m.setTitle("Burnt");
        m.setDirector("John Wells");
        m.setSynopsis("Chef Adam Jones (Bradley Cooper) had it all—and lost it. A two-star Michelin rockstar with the bad habits to match, the former enfant terrible of the Paris restaurant scene did everything different every time out, and only ever cared about the thrill of creating explosions of taste. To land his own kitchen and that third elusive Michelin star though, he’ll need the best of the best on his side, including the beautiful Helene (Sienna Miller). Burnt is a remarkably funny and emotional story about the love of food, the love between two people, and the power of second chances.");
        m.setAgeRating(Movie.AgeRating.NC16);
        m.setGenre("Drama");
        casts = new ArrayList<String>();
        casts.add("Bradley Cooper");
        casts.add("Sienna Miller");
        casts.add("Omar Sy");
        casts.add("Daniel Brühl");
        casts.add("Matthew Rhys");
        casts.add("Uma Thurman");
        casts.add("Emma Thompson");
        casts.add("Alicia Vikander");
        casts.add("Lily James");
        reviews = new ArrayList<>();
        reviews.add(new Review("Vampire", 4, "I enjoyed it. Storyline is nice. Somehow predictable, but there are still unexpected twists in the show, which is great. I like Adam Jones’s passion of food. And this movie shows me part of the restaurant which I never knew (The preparations needed)."));
        reviews.add(new Review("ULTRON", 5, "Wonderful acting by wonderful cast and a wonderful story. it will rise above your expectations. very worth watching"));
        reviews.add(new Review("aflufybuny", 4, "Good acting generally, close depiction of subject matter with clear simplified goals of the characters whilst focused on emotive acting illustrating individual dilemas. One should emulate good values, discard bad habits and traits of the industry."));
        reviews.add(new Review("Psngx", 5, "The show has exceeded my expectations and would certainly exceed yours too. Though the storyline's pretty predictable, it was a heartwarming one."));
        m.setReviews(reviews);
        m.setCasts(casts);
        m.setShowingStatus(Movie.ShowingStatus.NOW_SHOWING);
        list.add(m);
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
            System.out.println((i + 1) + ". " + movie.getTitle());
        }
    }

    public List<Movie> getShowing() {
        List<Movie> listShowing = new ArrayList<Movie>();
        for (Movie movie : list) {
            if (movie.getShowingStatus() != Movie.ShowingStatus.END_OF_SHOWING) {
                listShowing.add(movie);
            }
        }
        return listShowing;
    }

    public void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(" " + i + ": " + list.get(i).getTitle());
        }
    }
}
