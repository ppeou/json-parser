import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Util {
    public static MyComponent clone(MyComponentJSON item) {
        MyComponent newItem = new MyComponent();
        newItem.component = item.component;
        newItem.label = item.label;
        newItem.testId = item.testId;
        newItem.webElement = new WebElement();
        return newItem;
    }
    public static Map<String, MyComponent> flatNestedArray(MyComponentJSON myComponent, Map newMap) {
        if(newMap == null) {
            newMap = new HashMap<String, MyComponent>();
        }
        newMap.put(myComponent.testId, clone(myComponent));
        if(myComponent.items != null && myComponent.items.length > 0) {
            for(MyComponentJSON x : myComponent.items) {
                flatNestedArray(x, newMap);
            }
        }

        return newMap;
    }

    public static Map<String, MyComponent> readJSONFile(String profileFile) {
        try {
            FileReader fileReader = new FileReader(profileFile);
            ObjectMapper mapper = new ObjectMapper();

            //load JSON file into MyComponentJSON object
            MyComponentJSON obj = mapper.readValue(fileReader, MyComponentJSON.class);

            //flat MyComponentJSON nested structure into flat Map<String, MyComponent>
            return Util.flatNestedArray(obj, null);
        } catch (Exception ex) {
            return null;
        }
    }
    public static List<TestDataCSV> readCSVFile(String testDataFile) {
        List<TestDataCSV> items = new ArrayList();
        char SEPARATOR = ',';
        char QUOTE = '"';

        try {
            Scanner valueScanner = null;
            Scanner scanner = new Scanner(new FileReader(testDataFile));

            //skip header
            scanner.nextLine();
            while(scanner.hasNext()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(",");
                items.add(new TestDataCSV(
                        valueScanner.next(),
                        valueScanner.next(),
                        valueScanner.next())
                );
            }

            return items;
        }catch (Exception ex) {
            return null;
        }

    }
}
