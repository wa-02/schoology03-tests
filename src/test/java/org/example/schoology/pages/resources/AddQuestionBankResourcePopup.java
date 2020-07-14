package org.example.schoology.pages.resources;

import org.example.schoology.pages.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AddQuestionBankResourcePopup extends AddResourcePopupAbstract {

    @FindBy(css = "#edit-title")
    private WebElement resourceNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionTextArea;

    @FindBy(css = "#edit-enable-tracking" )
    private WebElement enableQuestionTrackingCheckBox;

    private void setName(final String name) {
        action.setText(resourceNameTextField, name);
    }

    private void setDescription(final String description) {
        descriptionTextArea.sendKeys(description);
    }


    private void enableQuestionTracking(final boolean enableQuestionTracking) {
        if (enableQuestionTracking != enableQuestionTrackingCheckBox.isSelected()) {
            action.click(enableQuestionTrackingCheckBox);
        }
    }

    @Override
    public Map<String, Step> getStepsMap(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("Name", () -> setName(resourceMap.get("Name")));
        stepsMap.put("Description", () -> setDescription(resourceMap.get("Description")));
        stepsMap.put("Enable Question Tracking", () -> enableQuestionTracking(resourceMap
                .get("Enable Question Tracking").equalsIgnoreCase("yes")));
        return stepsMap;
    }
}
