package me.app.testaction;

import me.app.testcase.TestComponent;

public class TestActionOpenUrl implements TestAction {
    public boolean execute(TestComponent component, String action, String value) {
        String prefix = "\t\t";
        System.out.println(prefix + "starting operation");
        System.out.println(prefix + prefix +" open URL:" + value);
        System.out.println(prefix + "done");
        return true;
    }
}
