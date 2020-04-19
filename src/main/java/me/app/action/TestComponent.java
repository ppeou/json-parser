package me.app.action;

public class TestComponent {
    private String testId;
    private String componentType;

    public TestComponent(String testId, String componentType) {
        this.testId = testId;
        this.componentType = componentType;
    }


    public String getTestId() {
        return testId;
    }

    public String getComponentType() {
        return componentType;
    }
}
