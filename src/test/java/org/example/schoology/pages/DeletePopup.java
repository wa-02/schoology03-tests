package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.MyResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePopup extends AbstractPage {

    @FindBy(css = "form[action*='delete'] #edit-submit")
    private WebElement deleteButton;

    public MyResources clickDeleteButton() {
        deleteButton.click();
        return new MyResources();
    }
}
