import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.Gson;

public interface JSONFile {
	
	public default Object load(File JSONFile, Type type) {
		Object object = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(JSONFile));
			object = new Gson().fromJson(reader.readLine(), type);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return object;
	}

	
	public default void save(File JSONFile, Object object) {
		FileWriter writer; 
		try {
			writer = new FileWriter(JSONFile);
			writer.write(new Gson().toJson(object));
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
