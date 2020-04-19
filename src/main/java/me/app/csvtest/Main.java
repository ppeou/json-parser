package me.app.csvtest;

import me.app.core.MyComponent;
import me.app.util.Util;
import org.json.simple.parser.JSONParser;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String testDataFile = Main.class.getClassLoader()
                .getResource("csv-test-form.csv")
                .getFile();

        JSONParser parser = new JSONParser();
        String profileFile = Main.class.getClassLoader()
                .getResource("test-form.json")
                .getFile();
        Map<String, MyComponent> elementMetaData = Util.readJSONFile(profileFile);

        CsvTester tester = new CsvTester(testDataFile, elementMetaData);
        tester.run();
    }
}
