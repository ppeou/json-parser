package me.app.csvtest;

import me.app.react.ui.component.BaseComponent;

public interface TestAction {
    boolean execute(BaseComponent component, String action, String value);
}
