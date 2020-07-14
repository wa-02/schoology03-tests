package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportFromResourcesPopup extends AbstractPage {

    private static final String RESOURCE_CHECK_BOX_XPATH =
            "//span[text()='%s']/preceding-sibling::input[@type='checkbox']";

    @FindBy(css = "#edit-submit-buttons-submit")
    private WebElement importButton;

    @FindBy(css = "#edit-submit")
    private WebElement confirmImportButton;

    public void importResource(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_CHECK_BOX_XPATH, resourceName)));
        action.click(importButton);
        action.click(confirmImportButton);
    }
}
