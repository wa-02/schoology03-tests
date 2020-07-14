package org.example.schoology.pages.questions;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public abstract class CreateQuestionAbstract extends AbstractPage {

    @FindBy(css = "#edit-title_ifr")
    private WebElement titleIframe;

    @FindBy(css = "body[onload*='edit-title']")
    private WebElement titleBody;

    @FindBy(css = "#edit-submit")
    protected WebElement createQuestionButton;

    protected void setTitle(final String title) {
        String parentWindowHandle = driver.getWindowHandle();
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(titleIframe));
            action.setText(titleBody, title);
        } finally {
            driver.switchTo().window(parentWindowHandle);
        }
    }

    public QuestionBankResource createQuestion(Map<String, String> questionMap) {
        Map<String, Step> stepsMap = getStepsMap(questionMap);
        questionMap.keySet().forEach(keyField -> stepsMap.get(keyField).execute());
        action.click(createQuestionButton);
        return new QuestionBankResource();
    }

    protected abstract Map<String, Step> getStepsMap(final Map<String, String> questionMap);
}
