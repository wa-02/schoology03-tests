package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class CreateFolder extends AbstractPage {

    @FindBy(css = "input#edit-title")
    private WebElement titleTextField;

    @FindBy(css = "body#tinymce")
    private WebElement descriptionTextField;

    @FindBy(css = "select#edit-availability")
    private WebElement availabilityDropdownField;

    @FindBy(css = "input#edit-submit")
    private WebElement createButton;

    public void create(final Map<String, String> folderFields) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("title", () -> setTitle(folderFields.get("title")));
        stepsMap.put("color", () -> setFolderColor(folderFields.get("color")));
        stepsMap.put("Availability", () -> setAvailability(folderFields.get("Availability")));

        fillFields(stepsMap);

        action.click(createButton);
    }

    private void fillFields(final Map<String, Step> stepsMap) {
        for(Step step : stepsMap.values()) {
            step.execute();
        }
    }

    private void setTitle(String title) {
        action.setText(titleTextField, title);
    }

    private void setFolderColor(String color) {
        String cssSelector = String.format("div[data-color='%s']", color);
        action.click(By.cssSelector(cssSelector));
    }

    private void setAvailability(String availability) {
        action.selectDropDown(availabilityDropdownField, availability);
    }
}
