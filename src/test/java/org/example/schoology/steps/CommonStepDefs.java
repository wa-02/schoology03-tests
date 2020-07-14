package org.example.schoology.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.testng.asserts.Assertion;

public class CommonStepDefs {

    private final Assertion assertion;

    private Home home;
    private SubMenu subMenu;

    public CommonStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup) {
        assertion = assertionGroup.getAssertion();
    }

    @Given("I log in as {string} user")
    public void logInAsUser(final String account) {
        Login login = new Login();
        home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
                Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
    }

    @When("I navigate to {string}")
    public void navigateToPageInSubMenu(final String menu) {
        subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
    }

    @When("I navigate to {string} in the Profile Menu")
    public void navigateToPageInProfileSubMenu(final String menu) {
        subMenu = home.clickProfileMenu();
        subMenu.clickProfileLink(menu);
    }

    @When("I navigate to {string} in the Account Menu")
    public void navigateToPageInAccountSubMenu(final String menu) {
        subMenu.clickAccountLink(menu);
    }


    @Then("I should see the {string} message")
    public void verifyMessageIsDisplayed(final String message) {
        assertion.assertEquals(message, new ViewList().getMessage(), "Message banner");
    }
}
