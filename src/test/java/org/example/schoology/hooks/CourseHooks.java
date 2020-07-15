package org.example.schoology.hooks;

import io.cucumber.java.After;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.DeletePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.courses.Courses;

public class CourseHooks {

    private ScenarioContext context;
    private Courses courses;

    public CourseHooks(final ScenarioContext context, final Courses courses) {
        this.context = context;
        this.courses = courses;
    }

    @After(value = "@deleteCourse")
    public void deleteCourse() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        SubMenu submenu = new Home().clickMenu("Courses");
        submenu.clickLink("My Courses");
        DeletePopup deleteCoursePopup = new Courses().clickDeleteCourse(context.getValue("CourseKey"));
        deleteCoursePopup.clickDeleteButton();
    }

    @After(value = "@deleteCourseFromMyList")
    public void deleteCourseFromMyList() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        SubMenu submenu = new Home().clickMenu("Courses");
        submenu.clickLink("My Courses");
        courses.clickDeleteCourse(context.getValue("CourseKey"));
    }
}
