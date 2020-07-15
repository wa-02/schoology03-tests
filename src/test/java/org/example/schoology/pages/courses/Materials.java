package org.example.schoology.pages.courses;

import org.apache.commons.lang3.StringUtils;
import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Materials extends AbstractPage {
    @FindBy(css = "h2.page-title a")
    private WebElement pageTitleField;

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
