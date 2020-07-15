package org.example.schoology.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.profile.AccountSettings;
import org.example.schoology.pages.profile.Notifications;
import org.example.schoology.pages.profile.PrivacySettings;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Map;

public class ProfileStepDefs {

    private final AccountSettings accountSettings;
    private final Notifications notifications;
    private final PrivacySettings privacySettings;

    private Assertion assertion;

    public ProfileStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                           final AccountSettings accountSettings, final Notifications notifications,
                           final PrivacySettings privacySettings) {
        assertion = assertionGroup.getAssertion();
        this.accountSettings = accountSettings;
        this.notifications = notifications;
        this.privacySettings = privacySettings;
    }

    @When("I edit the following information in the Accounting Settings:")
    public void editAccountSettings(final Map<String, String> datatable) {
        this.accountSettings.fill(datatable);
    }

    @When("I edit the following notifications:")
    public void editNotifications(final DataTable datatable) {
        this.notifications.setNotifications(datatable.asMaps());
    }

    @Then("I should see the following notifications:")
    public void verifyNotificationsDisplayed(final List<Map<String, String>> notifications) {
        notifications.forEach(notification -> {
            assertion.assertEquals(this.notifications.getNotificationOptionSelected(notification),
                    notification.get("option"), "Notification option");
        });
    }

    @When("I edit the following user privacy settings:")
    public void editUserPrivacySettings(final  List<Map<String, String>> privacySettings) {
        this.privacySettings.setUserPrivacySettings(privacySettings);
    }

    @Then("I should see the following user privacy settings selected:")
    public void verifyUserPrivacySettingsDisplayed(final List<Map<String, String>> privacySettings) {
        privacySettings.forEach(privacySetting -> {
            assertion.assertTrue(this.privacySettings.getUserPrivacySettingOptionSelected(privacySetting), "User Privacy Setting");
        });
    }
}
