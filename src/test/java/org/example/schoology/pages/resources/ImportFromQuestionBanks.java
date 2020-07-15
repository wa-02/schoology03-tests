package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ImportFromQuestionBanks extends AbstractPage {

    private static final String QUESTION_CHECK_BOX_XPATH =
            "//tr[contains(@class,'content_question') and .//p[text()='%s']]//input[@type='checkbox']";

    @FindBy(css = "#edit-submit-buttons-submit")
    private WebElement addQuestionsBtn;

    public void addQuestions(final List<String> questionTitles) {
        questionTitles.forEach(question -> action.selectCheckBox(By.xpath(String.format(QUESTION_CHECK_BOX_XPATH, question))));
        action.click(addQuestionsBtn);
    }
}
