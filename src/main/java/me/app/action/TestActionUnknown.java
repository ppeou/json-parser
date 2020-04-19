package me.app.action;

import me.app.react.ui.component.BaseComponent;

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
