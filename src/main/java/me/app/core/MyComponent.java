package me.app.core;

public class MyComponent {
    public String component;
    public String label;
    public String testId;
    public WebElement webElement;

    @Override
    public String toString() {
        return   testId + " / "
                + component + " / "
                + label + " / "
                + webElement.toString(testId);

    }
}
