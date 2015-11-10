import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class Cineplexes implements JSONFile{
	private List<Cineplex> list;
	File JSONFile = new File("cineplexes.json");
	Type Cineplexlist = new TypeToken<ArrayList<Cineplex>>(){}.getType();

	public Cineplexes() {
		list = (List<Cineplex>) load(JSONFile, Cineplexlist);
	}
	
	public void addCineplex(Cineplex cineplex) {
		list.add(cineplex);
	}
	
	public Cineplex getCineplex(int index) {
		return list.get(index);
	}
	
	public void displayList() {
		for (int i=0; i<list.size(); i++) {
			System.out.println(" " + i + ": " + list.get(i).getName());
		}
	}
}
