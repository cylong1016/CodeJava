package cylong.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Convert a Staff object into a JSON formatted string.
 * @see <a href=https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json>
 * Jackson 2 Convert Java Object to / from JSON</a>
 * @author cylong
 * @version 2017年3月31日 上午8:49:09
 */
public class JavaToJsonExample {

	public static void main(String[] args) {
		JavaToJsonExample.run();
	}

	private static void run() {

		ObjectMapper mapper = new ObjectMapper();

		Staff staff = Staff.createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data/staff.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
