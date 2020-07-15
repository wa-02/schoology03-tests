package org.example.schoology.pages.questions;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class CreateEssayQuestion extends CreateQuestionAbstract {

    @FindBy(css = "#edit-character-limit-check")
    private WebElement characterLimitCheckBox;

    @FindBy(css = "#edit-character-limit")
    private WebElement characterLimitTextBox;

    @Override
    protected Map<String, Step> getStepsMap(Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.TITLE, () -> setTitle(questionMap.get(Constants.TITLE)));
        stepsMap.put(Constants.CHARACTER_LIMIT, () -> setCharacterLimit(questionMap.get(Constants.CHARACTER_LIMIT)));
        return stepsMap;
    }

    private void setCharacterLimit(final String characterLimit) {
        action.selectCheckBox(characterLimitCheckBox);
        action.setText(characterLimitTextBox, characterLimit);
    }
}
