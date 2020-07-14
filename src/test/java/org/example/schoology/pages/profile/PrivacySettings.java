package org.example.schoology.pages.profile;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivacySettings extends ViewList {

    private static final String USER_PRIVACY_SETTING = "//label[text()='%s']/ancestor::tr/td[contains(@class,'%s')]";
    private static final By USER_PRIVACY_SCHOOL_SETTING_NOT_SELECTED =
            By.xpath("//td[@class='value-name-school' and not(contains(@class,'selected'))]");

    private static final HashMap<String, String> PRIVACY_SETTING_CLASS = new HashMap<>();

    static {
        PRIVACY_SETTING_CLASS.put("connections", "value-name-user");
        PRIVACY_SETTING_CLASS.put("no one", "value-name-nobody");
        PRIVACY_SETTING_CLASS.put("school", "value-name-school");
    }

    public PrivacySettings() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
    }

    private PrivacySettings setUserPrivacySetting(final Map<String, String> privacySetting) {
        WebElement userPrivacySetting = driver.findElement(
                By.xpath(String.format(USER_PRIVACY_SETTING, privacySetting.get("user privacy setting"),
                        PRIVACY_SETTING_CLASS.get(privacySetting.get("setting")))));
        action.scrollToElement(userPrivacySetting);
        action.click(userPrivacySetting);
        return this;
    }

    public PrivacySettings setUserPrivacySettings(final List<Map<String, String>> privacySettings) {
        privacySettings.forEach(this::setUserPrivacySetting);
        action.click(submitButton);
        return this;
    }

    public boolean getUserPrivacySettingOptionSelected(final Map<String, String> privacySetting) {
        By userPrivacySetting = By.xpath(String.format(USER_PRIVACY_SETTING, privacySetting.get("user privacy setting"),
                        PRIVACY_SETTING_CLASS.get(privacySetting.get("setting"))));

        return driver.findElement(userPrivacySetting).getAttribute("class").contains("selected");
    }

    public PrivacySettings resetUserPrivacySetting(){
        List<WebElement> schoolPrivacySettingsNotSelected = driver.findElements(USER_PRIVACY_SCHOOL_SETTING_NOT_SELECTED);
        schoolPrivacySettingsNotSelected.forEach(setting -> action.click(setting));
        action.click(submitButton);
        return this;
    }
}
