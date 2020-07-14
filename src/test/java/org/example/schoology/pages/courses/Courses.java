package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.DeletePopup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Courses extends AbstractPage {

    private static final String COURSE_ACTIONS_BUTTON = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";

    @FindBy(css = "a.create-course-btn")
    private WebElement createCourseButton;

    @FindBy(css = "ul[style=\"display: block;\"] .action-delete")
    private WebElement deleteCourse;

    public CreateCoursePopup clickCreateCourseButton() {
        action.click(createCourseButton);
        return new CreateCoursePopup();
    }

    public String getCourseTitle(final String courseName) {
        String xPath = String.format("//span[text()='%s']", courseName);
        return action.getText(By.xpath(xPath));
    }


    public DeletePopup clickDeleteCourse(String courseName) {
        WebElement courseActionsButton = driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName)));
        action.scrollToElement(courseActionsButton);
        action.click(courseActionsButton);
        deleteCourse.click();
        return new DeletePopup();
    }
}
