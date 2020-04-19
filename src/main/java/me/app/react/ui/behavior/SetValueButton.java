package me.app.react.ui.behavior;

public class SetValueButton implements SetValueComponent {
    public void perform(String testId, String value) {
        System.out.println(testId + ":: no set value allowed");
    }
}
