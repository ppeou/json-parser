package me.app.react.ui.behavior;

public class SetValueBlankElement implements SetValueComponent {

    public void perform(String testId, String value) {
        System.out.println(testId + ":: set value not allowed " + value);
    }
}
