package org.example.schoology.pages.questions;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class CreateTrueFalseQuestion extends CreateQuestionAbstract {

    @FindBy(css = "#edit-correct")
    private WebElement correctAnswerSelect;

    @Override
    public Map<String, Step> getStepsMap(final Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.TITLE, () -> setTitle(questionMap.get(Constants.TITLE)));
        stepsMap.put(Constants.CORRECT_ANSWER, () -> selectCorrectAnswer(questionMap.get(Constants.CORRECT_ANSWER)));
        return stepsMap;
    }

    private void selectCorrectAnswer(final String correctAnswer) {
        action.selectDropDown(correctAnswerSelect, correctAnswer);
    }
}
