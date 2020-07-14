package org.example.schoology.pages.resources;

import org.example.schoology.pages.questions.ImportQuestionPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuizResource extends QuestionResourceAbstract {

    @FindBy(css = "div.action-links-unfold")
    private WebElement addQuestionBtn;

    @FindBy(css = "a[href*='import_from_bank']")
    private WebElement importFromBankOption;

    @FindBy(css = "h2.page-title")
    private WebElement resourceName;

    protected WebElement getAddQuestionBtn() {
        return addQuestionBtn;
    }

    @Override
    public String getResourceName() {
        return action.getText(resourceName);
    }

    public ImportQuestionPopup clickAddQuestionFromQuestionBank() {
        action.click(addQuestionBtn);
        action.click(importFromBankOption);
        return new ImportQuestionPopup();
    }
}
