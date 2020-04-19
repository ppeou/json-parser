package me.app.react.ui.component;

import me.app.react.ui.behavior.ClearTextInput;
import me.app.react.ui.behavior.ClickElement;
import me.app.react.ui.behavior.SetValueTextInput;

public class TextInput extends BaseComponent {

    public TextInput(String testId) {
        super(testId);
    }

    protected void createComponent() {
        this.clearComponent = new ClearTextInput();
        this.clickComponent = new ClickElement();
        this.setValueComponent = new SetValueTextInput();
    }
}
