package me.app.react.ui;

import me.app.react.ui.component.BaseComponent;
import me.app.react.ui.component.ComponentFactory;

public class TestComponents {
    public static void main(String[] args) {
        BaseComponent firstName = ComponentFactory.create("textinput", "firstName");
        BaseComponent city = ComponentFactory.create("dropdown", "city");
        BaseComponent button = ComponentFactory.create("button", "save");

        firstName.clear();
        firstName.click();
        firstName.setValue("Hello");

        System.out.println("");

        city.clear();
        city.click();
        city.setValue("World");

        System.out.println("");

        button.click();
        button.clear();
        button.setValue("Hello");
    }
}
