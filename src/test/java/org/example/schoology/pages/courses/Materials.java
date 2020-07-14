package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.ImportFromResourcesPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Materials extends AbstractPage {
    private static final String RESOURCE_XPATH =
            "//div[div[@class='item-title']/a[text()='%s']]/div[@class='item-body ']/p[text()='%s']";

    @FindBy(css = "h2.page-title a")
    private WebElement pageTitleField;

    @FindBy(css = ".course-content-action-links .action-links-unfold")
    private WebElement addMaterialsButton;

    @FindBy(css = ".import-library")
    private WebElement importFromResourceOption;


    public String getTitle() {
        return action.getText(pageTitleField);
    }

    public ImportFromResourcesPopup clickImportFromResources() {
        action.click(addMaterialsButton);
        action.click(importFromResourceOption);
        return new ImportFromResourcesPopup();
    }

    public boolean isResourceDisplayed(final String resourceName, final String resourceDescription) {
        return action.isElementPresent(By.xpath(String.format(RESOURCE_XPATH, resourceName, resourceDescription)),
                3);
    }
}
