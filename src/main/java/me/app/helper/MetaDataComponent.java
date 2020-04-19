package me.app.helper;

public class MetaDataComponent {
    public String component;
    public String label;
    public String testId;

    @Override
    public String toString() {
        return   testId + " / "
                + component + " / "
                + label;

    }
}
