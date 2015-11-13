import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Lloyd
 */
public class StaffController implements JSONFile {
	List<Staff> list;
	File JSONFile = new File("staff.json");
	Type Stafflist = new TypeToken<ArrayList<Staff>>(){}.getType();
	
    /**
     *
     */
    public StaffController() {
		list = (List<Staff>) load(JSONFile, Stafflist);		
	}
	
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
		for (Staff staff : list) {
			if (staff.getUsername().equals(username) && staff.getPassword().equals(password)) return true;
		}
		return false;
	}

}
