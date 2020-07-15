package org.example.schoology.pages.resources;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
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
        stepsMap.put(Constants.NAME, () -> setName(resourceMap.get(Constants.NAME)));
        stepsMap.put(Constants.DESCRIPTION, () -> setDescription(resourceMap.get(Constants.DESCRIPTION)));
        stepsMap.put(Constants.ENABLE_QUESTION_TRACKING, () -> enableQuestionTracking(resourceMap
                .get(Constants.ENABLE_QUESTION_TRACKING).equalsIgnoreCase(Constants.YES)));
        return stepsMap;
    }
}
