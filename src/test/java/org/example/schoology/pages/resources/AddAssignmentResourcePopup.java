package org.example.schoology.pages.resources;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class AddAssignmentResourcePopup extends AddResourcePopupAbstract {

    @FindBy(css = "#edit-template-fields-title")
    private WebElement resourceNameTextField;

    @FindBy(css = "#edit-template-fields-body_ifr")
    private WebElement descriptionIframe;

    @FindBy(css = "#tinymce")
    private WebElement descriptionBody;

    private void setName(final String name) {
        action.setText(resourceNameTextField, name);
    }

    private void setDescription(final String description) {
        String parentWindowHandle = driver.getWindowHandle();
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionIframe));
            action.setText(descriptionBody, description);
        } finally {
            driver.switchTo().window(parentWindowHandle);
        }
    }

    @Override
    protected Map<String, Step> getStepsMap(Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.NAME, () -> setName(resourceMap.get(Constants.NAME)));
        stepsMap.put(Constants.DESCRIPTION, () -> setDescription(resourceMap.get(Constants.DESCRIPTION)));
        return stepsMap;
    }
}
