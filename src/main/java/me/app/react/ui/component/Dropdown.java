package me.app.react.ui.component;

import me.app.react.ui.behavior.ClearDropdown;
import me.app.react.ui.behavior.ClickElement;
import me.app.react.ui.behavior.SetValueDropdown;

public class Dropdown extends BaseComponent {

    public Dropdown(String testId) {
        super(testId);
    }

    protected void createComponent() {
        this.clearComponent = new ClearDropdown();
        this.clickComponent = new ClickElement();
        this.setValueComponent = new SetValueDropdown();
    }
}