package me.app.react.ui.component;

import me.app.react.ui.behavior.ClickElement;

public class Button extends BaseComponent {
    public Button(String testId) {
        super(testId);
    }

    protected void createComponent() {
        this.clickComponent = new ClickElement();
    }
}
