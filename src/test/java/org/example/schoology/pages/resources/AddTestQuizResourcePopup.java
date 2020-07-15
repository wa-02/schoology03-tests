package org.example.schoology.pages.resources;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AddTestQuizResourcePopup extends AddResourcePopupAbstract {

    @FindBy(css = "#edit-template-fields-title")
    private WebElement resourceNameTextField;

    @FindBy(css = "#edit-template-fields-max-points")
    private WebElement maxPointsTextField;

    private void setName(final String name) {
        action.setText(resourceNameTextField, name);
    }

    private void setMaxPoints(final String maxPoints) {
        action.setText(maxPointsTextField, maxPoints);
    }

    @Override
    protected Map<String, Step> getStepsMap(Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.NAME, () -> setName(resourceMap.get(Constants.NAME)));
        stepsMap.put("Max points", () -> setMaxPoints(resourceMap.get("Max points")));
        return stepsMap;
    }
}
