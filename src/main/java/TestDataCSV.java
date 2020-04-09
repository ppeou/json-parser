public class TestDataCSV {
    String action;
    String testId;
    String value;

    public TestDataCSV(String action, String testId, String value) {
        this.action = action;
        this.testId = testId;
        this.value = value;
    }

    @Override
    public String toString() {
        return testId + " / " + action + " / " + value;
    }
}
