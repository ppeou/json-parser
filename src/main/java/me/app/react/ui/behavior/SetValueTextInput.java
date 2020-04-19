package me.app.react.ui.behavior;

public class SetValueTextInput implements SetValueComponent {

    public void perform(String testId, String value) {
        System.out.println(testId + ":: set value for text-input :: " + value);
        System.out.println("\tget WebElement by TestID");
        System.out.println("\tget Grid Cell by XPATH //[@data-testid=testid]//ancestor::[@role=gridcell]");
        System.out.println("\tclick on WebELement");
        System.out.println("\tsleep 1000");
        System.out.println("\tget Input XPATH from Grid Cell Element .//div//div//input");
        System.out.println("\tset value to list");

    }
}
