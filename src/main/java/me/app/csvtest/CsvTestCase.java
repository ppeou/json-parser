package me.app.csvtest;

public abstract class CsvTestCase {
    public void add(CsvTestCase csvTestCase) {
        throw new UnsupportedOperationException();
    }

    public void remove(CsvTestCase csvTestCase) {
        throw new UnsupportedOperationException();
    }

    public CsvTestCase getCase(int testCaseIndex) {
        throw new UnsupportedOperationException();
    }

    public String getAction() {
        throw new UnsupportedOperationException();
    }

    public String getTestId() {
        throw new UnsupportedOperationException();
    }

    public String getValue() {
        throw new UnsupportedOperationException();
    }


    public boolean run() {
        throw new UnsupportedOperationException();
    }
}
