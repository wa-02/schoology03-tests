package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.constants.Constants.QuestionType;
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

    private static final Map<QuestionType, String> QUESTION_TYPE_HREF = new HashMap<>();
    static {
        QUESTION_TYPE_HREF.put(QuestionType.TRUE_FALSE, "true_false");
        QUESTION_TYPE_HREF.put(QuestionType.MULTIPLE_CHOICE, "multiple_choice");
        QUESTION_TYPE_HREF.put(QuestionType.ORDERING, "ordering");
        QUESTION_TYPE_HREF.put(QuestionType.SHORT_ANSWER_ESSAY_QUESTION, "essay");
        QUESTION_TYPE_HREF.put(QuestionType.FILL_IN_THE_BLANK, "fitb");
        QUESTION_TYPE_HREF.put(QuestionType.MATCHING, "matching");
    }

    @FindBy(css = "div#collection-title span.active")
    private WebElement resourceName;

    public CreateQuestionAbstract openCreateQuestion(final String questionType) {
        action.click(getAddQuestionBtn());
        action.click(By.cssSelector(String.format(QUESTION_TYPE_CSS,
                QUESTION_TYPE_HREF.get(QuestionType.getQuestionType(questionType)))));
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
