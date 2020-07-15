package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.AppPageFactory;
import org.example.schoology.pages.questions.CreateQuestionAbstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public abstract class QuestionResourceAbstract extends AbstractPage {
    private static final String QUESTION_TYPE_CSS = "a[href*='question_type=%s']";

    private static final String QUESTION_TITLE_XPATH =
            "//td[div[contains(@class,'component-title') and p[text()='%s']]]";

    private static final By QUESTION_TYPE_BY = By.cssSelector(".component-type");

    private static final Map<String, String> QUESTION_TYPE_HREF = new HashMap<>();
    static {
        QUESTION_TYPE_HREF.put("True/False", "true_false");
        QUESTION_TYPE_HREF.put("Multiple Choice", "multiple_choice");
        QUESTION_TYPE_HREF.put("Ordering", "ordering");
        QUESTION_TYPE_HREF.put("Short-Answer/Essay Question", "essay");
        QUESTION_TYPE_HREF.put("Fill in the Blank", "fitb");
        QUESTION_TYPE_HREF.put("Matching", "matching");
    }

    @FindBy(css = "div#collection-title span.active")
    private WebElement resourceName;

    public CreateQuestionAbstract openCreateQuestion(final String questionType) {
        action.click(getAddQuestionBtn());
        action.click(By.cssSelector(String.format(QUESTION_TYPE_CSS, QUESTION_TYPE_HREF.get(questionType))));
        return AppPageFactory.getCreateQuestion(questionType);
    }

    protected abstract WebElement getAddQuestionBtn();

    public abstract String getResourceName();

    public boolean isQuestionDisplayed(final String questionTitle) {
        return action.isElementPresent(By.xpath(String.format(QUESTION_TITLE_XPATH, questionTitle)), 3);
    }

    public String getQuestionTypeByTitle(final String questionTitle) {
        WebElement question = driver.findElement(By.xpath(String.format(QUESTION_TITLE_XPATH, questionTitle)));
        return action.getText(question.findElement(QUESTION_TYPE_BY));
    }
}
