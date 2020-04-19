package me.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.app.core.MyComponent;
import me.app.core.MyComponentJSON;
import me.app.core.TestDataCSV;
import me.app.core.WebElement;

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

            //load JSON file into me.app.core.MyComponentJSON object
            MyComponentJSON obj = mapper.readValue(fileReader, MyComponentJSON.class);

            //flat me.app.core.MyComponentJSON nested structure into flat Map<String, me.app.core.MyComponent>
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
