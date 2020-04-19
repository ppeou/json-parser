package me.app.csvtest;

import me.app.core.MyComponent;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class CsvTester {
    TestCaseList testCaseList;
    String csvFile;
    Map<String, MyComponent> elementMetaData;

    public CsvTester(String csvFile, Map<String, MyComponent> elementMetaData) {
        this.csvFile = csvFile;
        this.elementMetaData = elementMetaData;
        load();
    }

    private void load() {
        testCaseList = new TestCaseList("First Test", this.csvFile);
        char SEPARATOR = ',';
        char QUOTE = '"';

        try {
            Scanner valueScanner = null;
            Scanner scanner = new Scanner(new FileReader(csvFile));
            String action;
            String testId;
            String value;
            String componentType;
            //skip header
            scanner.nextLine();
            while (scanner.hasNext()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(",");
                testId = valueScanner.next();
                action = valueScanner.next();
                value = valueScanner.next();

                componentType = elementMetaData.containsKey(testId) ? elementMetaData.get(testId).component : "unknown";


                testCaseList.add(new TestCase(action,testId,value, componentType.toLowerCase()));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean run() {
        System.out.println("Starting to process" + testCaseList.getListName());
        boolean result = testCaseList.run();
        System.out.println("-- test completed.");
        return result;
    }

    @Override
    public String toString() {
        return "CsvTester{" +
                "testCaseList=" + testCaseList.toString() +
                ", file='" + csvFile + '\'' +
                '}';
    }
}
