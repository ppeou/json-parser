package me.app.react.ui.behavior;

public class SetValueDropdown implements SetValueComponent {

    public void perform(String testId, String value) {
        System.out.println(testId + ":: set value for dropdown :: " + value);
        System.out.println("\tget WebElement by TestID");
        System.out.println("\tget Dropdown List by XPATH: //body/[@role=dropdown]");
        System.out.println("\tset value to list");

    }
}
