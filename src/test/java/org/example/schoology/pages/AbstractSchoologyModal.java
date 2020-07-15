package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractSchoologyModal extends AbstractPage {

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    protected void clickSubmitButton() {
        action.click(submitButton);
    }
}
