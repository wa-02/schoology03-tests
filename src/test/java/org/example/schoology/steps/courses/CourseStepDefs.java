package org.example.schoology.steps.courses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.courses.Materials;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CourseStepDefs {
    private Courses courses;
    private Home home;
    private Materials materials;

    public CourseStepDefs(final SharedDriver driver, final Courses courses, final Materials materials, final ScenarioContext context) {
        this.courses = courses;
        this.materials = materials;
        home = new Home();
    }

    @When("I create a course with:")
    public void iCreateACourseWith(final Map<String, String> courseFieldData) {
        SubMenu submenu = home.clickMenu("Courses");
        submenu.clickLink("My Courses");
        CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
        createCoursePopup.create(courseFieldData);
    }

    @And("I should see {string} in the page title")
    public void iShouldSeeInThePageTitle(final String titleParam) {
        String title = materials.getTitle();
        assertEquals(title, titleParam);
    }

    @Then("I should see {string} in the submenu")
    public void iShouldSeeInTheSubmenu(final String courseTitle) {
        SubMenu submenu = home.clickMenu("Courses");
        assertEquals(submenu.getCourseTitle(courseTitle), courseTitle);
    }

    @And("I should see {string} in My Courses tab")
    public void iShouldSeeInMyCourseTab(final String courseTitle) {
        SubMenu submenu = home.clickMenu("Courses");
        submenu.clickLink("My Courses");
        assertEquals(courses.getCourseTitle(courseTitle), courseTitle);
    }
}
