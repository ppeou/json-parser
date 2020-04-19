package me.app.main;

import org.json.simple.parser.JSONParser;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        JSONParser parser = new JSONParser();
        String jsonFile = Main.class.getClassLoader()
                .getResource("test-form.json")
                .getFile();

        String testDataFile = Main.class.getClassLoader()
                .getResource("csv-test-form.csv")
                .getFile();

        Tester tester = new Tester(testDataFile, jsonFile);
        boolean result = tester.run();
        System.out.println("\n---------------------------------------");
        if(!result) {
            System.out.println("1 or more test case failed");
        } else {
            System.out.println("Passed");
        }
    }
}
