package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Courses extends AbstractPage {

    @FindBy(css = "a.courses-enroll")
    private WebElement joinACourseButton;

    @FindBy(css = "a.create-course-btn")
    private WebElement createCourseButton;

    @FindBy(css = "div.action-links-unfold")
    private WebElement groupsAction;

    @FindBy(css = "ul[style='display: block;'] li.action-delete")
    private WebElement groupDeleteAction;

    @FindBy(css = "input#edit-submit")
    private WebElement deleteConfirmButton;

    public CreateCoursePopup clickCreateCourseButton() {
        action.click(createCourseButton);
        return new CreateCoursePopup();
    }

    public String getCourseTitle(final String courseName) {
        String xPath = String.format("//span[text()='%s']", courseName);
        return action.getText(By.xpath(xPath));
    }

    public void deleteCourse(final String courseName) {
        action.click(groupsAction);
        action.click(groupDeleteAction);
        action.click(deleteConfirmButton);
    }

    public JoinACourse clickJoinACourse() {
        action.click(joinACourseButton);
        return new JoinACourse();
    }
}
