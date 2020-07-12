package org.example.core;

import org.testng.asserts.Assertion;

public class AssertionGroup {

    private Assertion assertion;

    public AssertionGroup() {
        assertion = new Assertion();
    }

    public Assertion getAssertion() {
        return assertion;
    }

    public void setAssertion(final Assertion assertion) {
        this.assertion = assertion;
    }

}
