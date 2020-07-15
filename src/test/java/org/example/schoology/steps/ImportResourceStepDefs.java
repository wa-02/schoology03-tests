package org.example.schoology.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.courses.Materials;
import org.example.schoology.pages.resources.ImportFromResourcesPopup;
import org.example.schoology.pages.resources.MyResources;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.example.schoology.pages.resources.QuizResource;
import org.testng.asserts.Assertion;

public class ImportResourceStepDefs {

    private final ScenarioContext context;

    private final Assertion assertion;

    //Pages
    private Materials materials;

    public ImportResourceStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                            final ScenarioContext context, final Materials materials) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.materials = materials;
    }

    @When("I import {string} from resources")
    public void importResource(final String resourceName) {
        ImportFromResourcesPopup importFromResourcesPopup = materials.clickImportFromResources();
        importFromResourcesPopup.importResource(resourceName);
    }

    @Then("I should see the {string} - {string} resource in {string} course")
    public void verifyResourceIsInCourse(final String resourceName, final String resourceDescription,
                                         final String courseName) {
        assertion.assertEquals(materials.getTitle(), courseName);
        assertion.assertTrue(materials.isResourceDisplayed(resourceName, resourceDescription));
    }
}
