package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.AssertionGroup;
import org.testng.asserts.SoftAssert;

public class CommonHooks {

    private AssertionGroup assertionGroup;

    public CommonHooks(final AssertionGroup assertionGroup) {
        this.assertionGroup = assertionGroup;
    }

    @Before(value = "@softAssert")
    public void beforeSoftAssert() {
        assertionGroup.setAssertion(new SoftAssert());
    }

    @After(value = "@softAssert")
    public void afterSoftAssert() {
        ((SoftAssert) assertionGroup.getAssertion()).assertAll();
    }
}
