package me.app.testcase;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseTestCase {
    public void add(BaseTestCase baseTestCase) {
        throw new UnsupportedOperationException();
    }

    public void remove(BaseTestCase baseTestCase) {
        throw new UnsupportedOperationException();
    }

    public BaseTestCase getCase(int testCaseIndex) {
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


    public boolean run() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException();
    }
}
