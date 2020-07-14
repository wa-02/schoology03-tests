package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Materials extends AbstractPage {
    @FindBy(css = "h2.page-title a")
    private WebElement pageTitleField;

    public String getTitle() {
        return action.getText(pageTitleField);
    }
}
