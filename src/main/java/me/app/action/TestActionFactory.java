package me.app.action;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class TestActionFactory {
    private static final Map<String, Constructor<?>> availableTestActions =
            new HashMap<String, Constructor<?>>();

    static {
        {
            try {
                availableTestActions.put("textinput:setvalue", TestActionSetValueTextInput.class.getConstructor());
                availableTestActions.put("textinput:click", TestActionClickElement.class.getConstructor());
                availableTestActions.put("textinput:clear", TestActionClearTextInput.class.getConstructor());

                availableTestActions.put("dropdown:click", TestActionClickElement.class.getConstructor());
                availableTestActions.put("dropdown:clear", TestActionClearDropdown.class.getConstructor());
                availableTestActions.put("dropdown:setvalue", TestActionSetValueDropdown.class.getConstructor());

                availableTestActions.put("button:click", TestActionClickElement.class.getConstructor());
                availableTestActions.put("unknown:openurl", TestActionOpenUrl.class.getConstructor());
                availableTestActions.put("unknown:gotouserdetail", TestActionGoToUserDetail.class.getConstructor());

                availableTestActions.put("unknown", TestActionUnknown.class.getConstructor());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }


    public static TestAction create(String componentType, String actionName)  {
        TestAction testAction = null;

        try {
            Constructor<TestAction> constr = null;
            String id = (componentType + ":"+ actionName).toLowerCase();
            if(!availableTestActions.containsKey(id)) {
                id = "unknown";
            }
            constr = (Constructor<TestAction>) availableTestActions.get(id);
            testAction = constr.newInstance();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            return testAction;
        }
    }
}
