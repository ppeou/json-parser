package me.app.csvtest;

import me.app.react.ui.component.BaseComponent;
import me.app.react.ui.component.ComponentFactory;

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

    public boolean run() {

        BaseComponent element = ComponentFactory.create(componentType, testId);
        if(action.equalsIgnoreCase("click")) {
            element.click();
        } else if(action.equalsIgnoreCase("clear")) {
            element.clear();
        } else if(action.equalsIgnoreCase("setValue")) {
            element.setValue(value);
        } else {
            element.doNoAction(action, value);
        }

        return true;
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
