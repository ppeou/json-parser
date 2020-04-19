package me.app.react.ui.behavior;

public class ClickElement implements ClickComponent {

    public void perform(String testId) {
        System.out.println(testId + "::: click generic-element");
    }
}
