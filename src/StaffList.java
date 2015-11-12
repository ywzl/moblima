import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class StaffList implements JSONFile {
	List<Staff> list;
	File JSONFile = new File("staff.json");
	Type Stafflist = new TypeToken<ArrayList<Staff>>(){}.getType();
	
	public StaffList() {
		list = (List<Staff>) load(JSONFile, Stafflist);		
	}
	
	public boolean login(String username, String password) {
		for (Staff staff : list) {
			if (staff.getUsername().equals(username) && staff.getPassword().equals(password)) return true;
		}
		return false;
	}

}
