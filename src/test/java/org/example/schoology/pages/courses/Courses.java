package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Courses extends AbstractPage {
    @FindBy(css = "a.create-course-btn")
    private WebElement createCourseButton;

    public CreateCoursePopup clickCreateCourseButton() {
        action.click(createCourseButton);
        return new CreateCoursePopup();
    }

    public String getCourseTitle(final String courseName) {
        String xPath = String.format("//span[text()='%s']", courseName);
        return action.getText(By.xpath(xPath));
    }
}
