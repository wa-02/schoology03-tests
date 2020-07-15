package org.example.schoology.pages.resources;

import org.example.schoology.pages.AbstractSchoologyModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportFromResourcesPopup extends AbstractSchoologyModal {

    private static final String RESOURCE_CHECK_BOX_XPATH =
            "//span[text()='%s']/preceding-sibling::input[@type='checkbox']";

    @FindBy(css = "#edit-submit-buttons-submit")
    private WebElement importButton;

    public void importResource(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_CHECK_BOX_XPATH, resourceName)));
        action.click(importButton);
        clickSubmitButton();
    }
}
