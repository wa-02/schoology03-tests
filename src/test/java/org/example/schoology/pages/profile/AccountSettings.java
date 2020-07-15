package org.example.schoology.pages.profile;

import org.example.schoology.pages.Step;
import org.example.schoology.pages.ViewList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AccountSettings extends ViewList {

    @FindBy(css = "#edit-user-name-title")
    private WebElement titleDropDown;

    @FindBy(css = "#edit-user-name-middle")
    private WebElement middleNameTextField;

    @FindBy(css = "#edit-user-login-identifiers-username")
    private WebElement userNameTextField;

    @FindBy(css = "#edit-user-mail-alternate")
    private WebElement altEmailTextField;

    private void selectTitle(final String title) {
        action.selectDropDown(titleDropDown, title);
    }

    private void setMiddleName(final String middleName) {
        action.setText(middleNameTextField, middleName);
    }

    private void setUserName(final String name) {
        userNameTextField.sendKeys(name);
    }

    private void setAlternativeEmail(final String altEmail) {
        action.setText(altEmailTextField, altEmail);
    }

    public AccountSettings fill(final Map<String, String> settings) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("username", () -> setUserName(settings.get("username")));
        stepsMap.put("middle name", () -> setMiddleName(settings.get("middle name")));
        stepsMap.put("title", () -> selectTitle(settings.get("title")));
        stepsMap.put("alternative name", () -> selectTitle(settings.get("alternative name")));

        for (final String keyField : settings.keySet()) {
            stepsMap.get(keyField).execute();
        }
        clickSubmitButton();
        return this;
    }
}
