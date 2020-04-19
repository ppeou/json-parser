package me.app.react.ui.behavior;

public class ClickBlankElement implements ClickComponent {

    public void perform(String testId) {
        System.out.println(testId + "::: click text-input");
    }
}
