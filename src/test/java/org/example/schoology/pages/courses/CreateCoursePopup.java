package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateCoursePopup extends AbstractPage {
    @FindBy(css = "input#edit-course-name")
    private WebElement courseNameTextField;

    @FindBy(css = "input#edit-section-name-1")
    private WebElement sectionNameTextField;

    @FindBy(css = "select#edit-subject-area")
    private WebElement subjectAreaDropdownField;

    @FindBy(css = "select#edit-grade-level-range-start")
    private WebElement levelDropdownField;

    @FindBy(css = "input#edit-submit")
    private WebElement createButtonField;

    public void create(final Map<String, String> courseFieldData) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setCourseName(courseFieldData.get("name")));
        stepsMap.put("section", () -> setSectionName(courseFieldData.get("section")));
        stepsMap.put("area", () -> setArea(courseFieldData.get("area")));
        stepsMap.put("level", () -> setLevel(courseFieldData.get("level")));

        fillFields(stepsMap);

        createButtonField.click();
    }

    private void fillFields(final Map<String, Step> stepsMap) {
        for(Step step : stepsMap.values()) {
            step.execute();
        }
    }

    public void setCourseName(final String courseName) {
        courseNameTextField.clear();
        courseNameTextField.sendKeys(courseName);
    }

    public void setSectionName(final String section) {
        sectionNameTextField.clear();
        sectionNameTextField.sendKeys(section);
    }

    public void setArea(final String area) {
        Select subjectArea = new Select(subjectAreaDropdownField);
        subjectArea.selectByVisibleText(area);
    }

    public void setLevel(final String level) {
        Select levelField = new Select(levelDropdownField);
        levelField.selectByVisibleText(level);
    }
}
