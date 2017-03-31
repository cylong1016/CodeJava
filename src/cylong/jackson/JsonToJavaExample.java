package cylong.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Read JSON string and convert it back to a Java object.
 * @see <a href=https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json>
 *      Jackson 2 Convert Java Object to / from JSON</a>
 * @author cylong
 * @version 2017年3月31日 上午9:05:18
 */
public class JsonToJavaExample {

	public static void main(String[] args) {
		JsonToJavaExample.run();
	}

	private static void run() {
		
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			Staff staff = mapper.readValue(new File("data/staff.json"), Staff.class);
			System.out.println(staff);

			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"cylong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff1);

			//Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
