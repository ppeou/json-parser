package me.app.react.ui.component;

import me.app.react.ui.behavior.*;

public abstract class BaseComponent {
    private String testId;
    private String componentType;

    protected ClearComponent clearComponent = new ClearBlankElement();
    protected ClickComponent clickComponent = new ClickBlankElement();
    protected SetValueComponent setValueComponent = new SetValueBlankElement();
    protected NoActionComponent noActionComponent = new NoActionInput();

    protected abstract void createComponent();

    public BaseComponent(String testId) {
        this.testId = testId;
        createComponent();
    }


    public String getTestId() {
        return testId;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public void setClearComponent(ClearComponent newClearComponent) {
        this.clearComponent = newClearComponent;
    }

    public void setNoActionComponent(NoActionComponent noActionComponent) {
        this.noActionComponent = noActionComponent;
    }

    public void clear() {
        clearComponent.perform(testId);
    }

    public void click() {
        clickComponent.perform(testId);
    }

    public void setValue(String value) {
        setValueComponent.perform(testId, value);
    }

    public void doNoAction(String action, String value) {
        noActionComponent.perform(testId, action, value);
    }

}
