package me.app.action;

import me.app.react.ui.component.BaseComponent;

public class TestActionClearDropdown implements TestAction {
    public boolean execute(TestComponent component, String action, String value) {
        String prefix = "\t\t";
        System.out.println(prefix + "starting operation");
        System.out.println(prefix + prefix + "get WebElement by TestID");
        System.out.println(prefix + prefix + "get Grid Cell by XPATH //[@data-testid=testid]//ancestor::[@role=gridcell]");
        System.out.println(prefix + prefix + "click on WebELement");
        System.out.println(prefix + prefix + "sleep 1000");
        System.out.println(prefix + prefix + "get Input XPATH from Grid Cell Element //body//div[@role=dropdownlist]");
        System.out.println(prefix + prefix + "clear selection");
        System.out.println(prefix + "done");
        return true;
    }
}
