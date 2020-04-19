package me.app.action;

import me.app.react.ui.component.BaseComponent;

public class TestActionGoToUserDetail implements TestAction {
    public boolean execute(TestComponent component, String action, String value) {
        String prefix = "\t\t";
        System.out.println(prefix + "starting operation");
        System.out.println(prefix + prefix +" go to dashboard");
        System.out.println(prefix + prefix +" search for user: " + 1);
        System.out.println(prefix + prefix +" click on search result");
        System.out.println(prefix + prefix +" sleep 2 secs");
        System.out.println(prefix + "done");
        return true;
    }
}
