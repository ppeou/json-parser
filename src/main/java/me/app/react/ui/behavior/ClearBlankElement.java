package me.app.react.ui.behavior;

public class ClearBlankElement implements ClearComponent {
    public void perform(String testId) {

        System.out.println(testId + ":: no clear allowed");
    }
}
