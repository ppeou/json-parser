package me.app.react.ui.component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ComponentFactory {

    private static final Map<String, Constructor<?>> availableComponents=
            new HashMap<String, Constructor<?>>();

    static {
        {
            try {
                availableComponents.put("dropdown", Dropdown.class.getConstructor(String.class));
                availableComponents.put("textinput", TextInput.class.getConstructor(String.class));
                availableComponents.put("button", Button.class.getConstructor(String.class));
                availableComponents.put("unknown", UnknownElement.class.getConstructor(String.class));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }


    public static BaseComponent create(String componentType, String testId)  {
        BaseComponent element = null;

        try {
            Constructor<BaseComponent> constr = (Constructor<BaseComponent>) availableComponents.get(componentType);
            element = constr.newInstance(testId);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            return element;
        }
    }
}
