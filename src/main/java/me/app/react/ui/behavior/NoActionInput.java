package me.app.react.ui.behavior;

public class NoActionInput implements NoActionComponent {
    public void perform(String testId, String action, String value) {
        System.out.println(testId + ":: Unknown Action " + action + " -- " + value);
    }
}
