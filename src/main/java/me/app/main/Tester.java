package me.app.main;

import me.app.helper.MetaDataComponent;
import me.app.helper.Util;
import me.app.testcase.TestCase;
import me.app.testcase.TestCaseGroup;

import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class Tester {
    TestCaseGroup testCaseGroup;
    String testDataFile;
    String metaDataFile;
    Map<String, MetaDataComponent> elementMetaData;

    public Tester(String csvFile, String metaDataFile) {
        this.testDataFile = csvFile;
        this.metaDataFile = metaDataFile;
        loadMetaDataFile();
        loadTestDataFile();
    }

    private void loadMetaDataFile() {
        this.elementMetaData = Util.readJSONFile(metaDataFile);
    }

    private void loadTestDataFile() {
        testCaseGroup = new TestCaseGroup("First Test", this.testDataFile);
        char SEPARATOR = ',';
        char QUOTE = '"';

        try {
            Scanner valueScanner = null;
            Scanner scanner = new Scanner(new FileReader(testDataFile));
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

                testCaseGroup.add(new TestCase(action, testId, value, componentType.toLowerCase()));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean run() {
        System.out.println("Starting to process" + testCaseGroup.getName());
        boolean result = testCaseGroup.run();
        System.out.println("-- test completed.");
        return result;
    }
}
