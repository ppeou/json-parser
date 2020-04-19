package me.app.csvtest;

import me.app.action.TestAction;
import me.app.action.TestActionFactory;
import me.app.action.TestComponent;

public class TestCase extends CsvTestCase {

    String testId;
    String componentType;
    String action;
    String value;

    public TestCase(String action, String testId,String value, String componentType) {
        this.action = action;
        this.testId = testId;
        this.value = value;
        this.componentType = componentType;
    }

    public boolean run(int step) {
        System.out.println(step + ". Executing ["+ action +"] on ["+ testId +"]");
        TestComponent element = new TestComponent(componentType, testId);
        TestAction testAction = TestActionFactory.create(componentType, action);
        return testAction.execute(element, action, value);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "componentType='" + componentType + '\'' +
                "testId='" + testId + '\'' +
                ", action='" + action + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
