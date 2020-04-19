package me.app.testaction;

import me.app.testcase.TestComponent;

public class TestActionUnknown implements TestAction {
    public boolean execute(TestComponent component, String action, String value) {
        System.out.println("\t\t[warning][unknown action] "
                + component.getTestId() + ", "
                + component.getComponentType() + ", "
                + action + ", "
                + value + "");

        return false;
    }
}
