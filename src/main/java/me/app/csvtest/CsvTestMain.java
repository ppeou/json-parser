package me.app.csvtest;

import me.app.core.MyComponent;
import me.app.util.Util;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CsvTestMain {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        JSONParser parser = new JSONParser();
        String profileFile = CsvTestMain.class.getClassLoader()
                .getResource("test-form.json")
                .getFile();
        Map<String, MyComponent> elementMetaData = Util.readJSONFile(profileFile);


        String testDataFile = CsvTestMain.class.getClassLoader()
                .getResource("csv-test-form.csv")
                .getFile();

        CsvTester tester = new CsvTester(testDataFile, elementMetaData);
        boolean result = tester.run();
        System.out.println("\n---------------------------------------");
        if(!result) {
            System.out.println("1 or more test case failed");
        } else {
            System.out.println("Passed");
        }
    }
}
