package org.example.schoology.pages.questions;

import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateMultipleChoiceQuestion extends CreateQuestionAbstract {

    private MultipleOptionsComponent multipleOptionsComponent;

    private static final String CHOICE_CSS = "#edit-multiple-choice-choice-%s-text";

    private static final String CORRECT_CHOICE_XPATH =
            "//tr[.//div[contains(text(),'%s')] and contains(@class,'mult-choice')]//input[@type='checkbox']";

    public CreateMultipleChoiceQuestion() {
        super();
        multipleOptionsComponent = new MultipleOptionsComponent();
    }

    @Override
    public Map<String, Step> getStepsMap(final Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("Title", () -> setTitle(questionMap.get("Title")));
        stepsMap.put("Choices", () -> setChoices(questionMap.get("Choices")));
        stepsMap.put("Correct Answers", () -> selectCorrectAnswers(questionMap.get("Correct Answers")));
        return stepsMap;
    }

    private void selectCorrectAnswers(final String correctAnswers) {
        String[] correctAnswersArray = correctAnswers.split(", ");
        Arrays.stream(correctAnswersArray).forEach(correctAnswer -> {
            try {
                action.selectCheckBox(By.xpath(String.format(CORRECT_CHOICE_XPATH, correctAnswer)));
            } catch (StaleElementReferenceException e) {
                action.selectCheckBox(By.xpath(String.format(CORRECT_CHOICE_XPATH, correctAnswer)));
            }
        });
    }

    private void setChoices(final String choices) {
        multipleOptionsComponent.setOptions(CHOICE_CSS, choices);
    }
}
