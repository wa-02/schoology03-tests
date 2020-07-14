package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.profile.Notifications;
import org.example.schoology.pages.profile.PrivacySettings;

public class ProfileHooks {

    private ScenarioContext context;

    public ProfileHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios

    }

    @After(value = "@resetNotifications")
    public void resetNotifications() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        SubMenu subMenu = new Home().clickProfileMenu();
        subMenu.clickProfileLink("settings");
        subMenu.clickAccountLink("notifications");
        Notifications notifications = new Notifications();
        notifications.resetNotifications();
    }

    @After(value = "@resetUserPrivacySetting")
    public void resetUserPrivacySetting() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        SubMenu subMenu = new Home().clickProfileMenu();
        subMenu.clickProfileLink("settings");
        subMenu.clickAccountLink("privacy");
        PrivacySettings privacySettings = new PrivacySettings();
        privacySettings.resetUserPrivacySetting();
    }
}
