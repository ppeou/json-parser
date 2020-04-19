package me.app.testcase;

import java.util.ArrayList;

public class TestCaseGroup extends BaseTestCase {

    ArrayList testCaseGroup = new ArrayList();

    private String name;
    private String description;

    public TestCaseGroup(String name, String description) {
       this.name = name;
       this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void add(BaseTestCase baseTestCase) {
        testCaseGroup.add(baseTestCase);
    }

    public void remove(BaseTestCase baseTestCase) {
        testCaseGroup.remove(baseTestCase);
    }

    public BaseTestCase getCase(int caseIndex) {
        return (BaseTestCase) testCaseGroup.get(caseIndex);
    }

    public boolean run() {
        boolean hasNoError = true;
        for(int i = 0; i < testCaseGroup.size(); i++) {
            TestCase tc = (TestCase) testCaseGroup.get(i);
            hasNoError= tc.run(i+1) && hasNoError ;
        }
        return hasNoError;
    }

    @Override
    public String toString() {
        return "TestCaseGroup{" +
                "testCaseGroup=" + testCaseGroup +
                ", listName='" + name + '\'' +
                ", listDescription='" + description + '\'' +
                '}';
    }
}
