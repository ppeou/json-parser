
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        JSONParser parser = new JSONParser();
        String profileFile = Main.class.getClassLoader()
                .getResource("na-profile.json")
                .getFile();
        String testDataFile = Main.class.getClassLoader()
                .getResource("na-profile-test.csv")
                .getFile();

        Map<String, MyComponent> myElements = Util.readJSONFile(profileFile);
        List<TestDataCSV> cases = Util.readCSVFile(testDataFile);
        for(TestDataCSV itcase : cases) {
            System.out.printf("%s\n", itcase.toString());
            if(myElements.containsKey(itcase.testId)) {
                System.out.printf("--- Element: [%s]\n",
                        myElements.get(itcase.testId).toString());
            }
        }

        System.out.println("\n------------------\n");

        for(Map.Entry myElement : myElements.entrySet()) {
            System.out.printf("Test ID: `%s`\n Value: `%s`\n",
                    myElement.getKey(),
                    myElement.getValue().toString());
        }

    }

}
