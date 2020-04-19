package me.app.react.ui.component;

public class ComponentFactory {
    public static BaseComponent create(String componentType, String testId) {
        if(componentType.equalsIgnoreCase("dropdown")) {
            return new DropDown(testId);
        } else if(componentType.equalsIgnoreCase("textinput")) {
            return new TextInput(testId);
        } else if(componentType.equalsIgnoreCase("button")) {
            return new Button(testId);
        }
        return new BlankElement(testId);
    }
}
