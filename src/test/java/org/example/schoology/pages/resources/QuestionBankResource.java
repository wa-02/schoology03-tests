package org.example.schoology.pages.resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionBankResource extends QuestionResourceAbstract {

    @FindBy(css = "#toolbar-add-question")
    private WebElement addQuestionBtn;

    @FindBy(css = "div#collection-title span.active")
    private WebElement resourceName;

    protected WebElement getAddQuestionBtn() {
        return addQuestionBtn;
    }

    public String getResourceName() {
        return action.getText(resourceName);
    }

}
