package me.app.react.ui.component;

import me.app.react.ui.behavior.*;

public class UnknownElement extends BaseComponent {
    public UnknownElement(String testId) {
        super(testId);
    }

    protected void createComponent() {
        this.clearComponent = new ClearBlankElement();
        this.clickComponent = new ClickBlankElement();
        this.setValueComponent = new SetValueBlankElement();
        this.noActionComponent = new NoActionInput();
    }
}
