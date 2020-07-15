package org.example.schoology.steps.courses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.courses.Materials;
import org.example.schoology.pages.resources.MyResources;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CourseStepDefs {
    private final ScenarioContext context;

    //Pages
    private Courses courses;
    private Home home;
    private Materials materials;

    public CourseStepDefs(final SharedDriver driver, final Courses courses, final Materials materials,
                          final ScenarioContext context) {
        this.courses = courses;
        this.materials = materials;
        home = new Home();
        this.context = context;
    }

    @When("I create a course with:")
    public void iCreateACourseWith(final Map<String, String> courseFieldData) {
        SubMenu submenu = home.clickMenu("Courses");
        submenu.clickLink("My Courses");
        CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
        createCoursePopup.create(courseFieldData);
        context.setContext("CourseKey", courseFieldData.get("name"));
    }

    @And("I should see {string} in the page title")
    public void iShouldSeeInThePageTitle(final String titleExpected) {
        String title = materials.getTitle();
        assertEquals(title, titleExpected);
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

    @And("I should see the Access Code")
    public void iShouldSeeTheAccessCode() {
        assertTrue(materials.getAccessCode());
    }

    @When("I join a Course")
    public void iJoinACourse() {
        SubMenu submenu = home.clickMenu("Courses");
        submenu.clickLink("My Courses");
        JoinACourse joinCourse = courses.clickJoinACourse();
        joinCourse.joinCourse(materials.getAccessCodeString());
    }

    @When("I add a folder with:")
    public void iAddAFolderWith(final Map<String, String> folderFields) {
        CreateFolder folder = materials.addMaterial("Add Folder");
        folder.create(folderFields);
    }

    @Then("I should see the folder {string}")
    public void iShouldSeeTheFolder(final String folder) {
        assertEquals(materials.getFolderTitle(), folder);
    }

    // Delete Course Defs
    @When("I delete the course {string}")
    public void iDeleteAllCreated(final String menuName) {
        SubMenu submenu = home.clickMenu("Courses");
        submenu.clickLink("My Courses");
        courses.deleteCourse(menuName);
    }
}
