package me.app.testaction;

import me.app.testcase.TestComponent;

public interface TestAction {
    boolean execute(TestComponent component, String action, String value);
}
