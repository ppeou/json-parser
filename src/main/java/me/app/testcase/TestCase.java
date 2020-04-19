package me.app.testcase;

import me.app.testaction.TestAction;
import me.app.testaction.TestActionFactory;

public class TestCase extends BaseTestCase {

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
        boolean result = testAction.execute(element, action, value);

        System.out.println((result ? "[v] passed" : "[x] failed" ));

        return result;
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
