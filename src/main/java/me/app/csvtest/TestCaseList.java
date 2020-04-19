package me.app.csvtest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCaseList extends CsvTestCase {

    ArrayList testCases = new ArrayList();

    private String listName;
    private String listDescription;

    public TestCaseList(String listName, String listDescription) {
       this.listName = listName;
       this.listDescription = listDescription;
    }

    public String getListName() {
        return listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void add(CsvTestCase csvTestCase) {
        testCases.add(csvTestCase);
    }

    public void remove(CsvTestCase csvTestCase) {
        testCases.remove(csvTestCase);
    }

    public CsvTestCase getCase(int caseIndex) {
        return (CsvTestCase)testCases.get(caseIndex);
    }

    public boolean run() {
        boolean hasNoError = true;
        for(int i=0; i < testCases.size(); i++) {
            TestCase tc = (TestCase) testCases.get(i);
            hasNoError= tc.run(i+1) && hasNoError ;
        }
        return hasNoError;
    }

    @Override
    public String toString() {
        return "CsvTestCaseList{" +
                "testCases=" + testCases +
                ", listName='" + listName + '\'' +
                ", listDescription='" + listDescription + '\'' +
                '}';
    }
}
