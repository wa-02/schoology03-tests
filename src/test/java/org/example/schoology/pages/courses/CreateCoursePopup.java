package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

        action.click(createButtonField);
    }

    private void fillFields(final Map<String, Step> stepsMap) {
        for(Step step : stepsMap.values()) {
            step.execute();
        }
    }

    public void setCourseName(final String courseName) {
        action.setText(courseNameTextField, courseName);
    }

    public void setSectionName(final String section) {
        action.setText(sectionNameTextField, section);
    }

    public void setArea(final String area) {
        action.selectDropDown(subjectAreaDropdownField, area);
    }

    public void setLevel(final String level) {
        action.selectDropDown(levelDropdownField, level);
    }
}
