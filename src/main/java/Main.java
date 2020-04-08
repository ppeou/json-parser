
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        JSONParser parser = new JSONParser();
        String profileFile = Main.class.getClassLoader()
                .getResource("na-profile.json")
                .getFile();



        try {
            FileReader fileReader = new FileReader(profileFile);
            ObjectMapper mapper = new ObjectMapper();

            //JSON file to Java object
            MyComponent obj = mapper.readValue(fileReader, MyComponent.class);
            System.out.println(mapper.writeValueAsString(obj));

            /*Object obj = parser.parse(fileReader);

            JSONObject jsonObj = (JSONObject) obj;
            JSONArray items = (JSONArray) jsonObj.get("items");

            Iterator<JSONObject> iterator = items.iterator();

            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
