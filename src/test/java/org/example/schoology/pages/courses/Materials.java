package org.example.schoology.pages.courses;

import org.apache.commons.lang3.StringUtils;
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

    @FindBy(css = "span.enrollment-code")
    private WebElement accessCodeField;

    @FindBy(css = "div.course-content-action-links")
    private WebElement addMaterialsDropdownField;

    @FindBy(css = "div.folder-title")
    private WebElement folderTitleField;

    private String accessCode;


    public String getTitle() {
        return action.getText(pageTitleField);
    }

    public ImportFromResourcesPopup clickImportFromResources() {
        action.click(addMaterialsButton);
        action.click(importFromResourceOption);
        return new ImportFromResourcesPopup();
    }

    public boolean getAccessCode() {
        accessCode = action.getText(accessCodeField);
        return StringUtils.isNotEmpty(accessCode);
    }

    public boolean isResourceDisplayed(final String resourceName, final String resourceDescription) {
        return action.isElementPresent(By.xpath(String.format(RESOURCE_XPATH, resourceName, resourceDescription)),
                3);
    }

    public boolean getAccessCode() {
        accessCode = action.getText(accessCodeField);
        return StringUtils.isNotEmpty(accessCode);
    }

    public CreateFolder addMaterial(String materialName) {
        action.selectDropDown(addMaterialsDropdownField, materialName);
        return new CreateFolder();
    }

    public String getAccessCodeString() {
        return accessCode;
    }

    public String getFolderTitle() {
        return action.getText(folderTitleField);
    }
}
