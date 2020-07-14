package org.example.schoology.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.AppPageFactory;
import org.example.schoology.pages.questions.ImportQuestionPopup;
import org.example.schoology.pages.resources.AddResourcePopupAbstract;
import org.example.schoology.pages.questions.CreateQuestionAbstract;
import org.example.schoology.pages.resources.ImportFromQuestionBanks;
import org.example.schoology.pages.resources.MyResources;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.example.schoology.pages.resources.QuestionResourceAbstract;
import org.example.schoology.pages.resources.QuizResource;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Map;

public class ResourceStepDefs {

    private final ScenarioContext context;

    private final Assertion assertion;

    // Pages
    MyResources myResources;
    QuestionBankResource questionBankResource;
    QuizResource quizResource;

    public ResourceStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                            final ScenarioContext context) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
    }

    @When("I create a {string} resource with:")
    public void createResource(final String resourceType, final Map<String, String> resourceMap) {
        myResources = new MyResources();
        AddResourcePopupAbstract addResourcePopup = myResources.clickAddResources(resourceType);
        addResourcePopup.addResource(resourceMap);
        context.setContext("ResourceKey", resourceMap.get("Name"));
    }

    @When("I open the {string} question bank resource")
    public void openResource(final String resourceName) {
        myResources = new MyResources();
        myResources.openQuestionBankResource(resourceName);
    }

    @When("I add a {string} question with:")
    public void addQuestion(final String questionType, final Map<String, String> questionMap) {
        questionBankResource = new QuestionBankResource();
        CreateQuestionAbstract createQuestion = questionBankResource.openCreateQuestion(questionType);
        questionBankResource = createQuestion.createQuestion(questionMap);
    }

    @When("I add the questions from {string} question bank")
    public void addQuestionFromQuestionBank(final String questionBankName, final List<String> questionTitles) {
        quizResource = new QuizResource();
        ImportQuestionPopup importQuestionPopup = quizResource.clickAddQuestionFromQuestionBank();
        myResources = importQuestionPopup.clickIndividualQuestions();
        myResources.openQuestionBankResource(questionBankName);
        ImportFromQuestionBanks importFromQuestionBanks = new ImportFromQuestionBanks();
        importFromQuestionBanks.addQuestions(questionTitles);
    }

    @Then("I should see the {string} {string} resource with questions:")
    public void verifyResourceIsCreated(final String resourceName, final String resourceType,
                                        final DataTable questionsTable) {
        QuestionResourceAbstract questionResource = AppPageFactory.getQuestionResource(resourceType);
        assertion.assertEquals(questionResource.getResourceName(), resourceName);
        questionsTable.asMaps().forEach(questionMap -> {
            assertion.assertTrue(questionResource.isQuestionDisplayed(questionMap.get("Title")));
            assertion.assertEquals(questionResource.getQuestionTypeByTitle(questionMap.get("Title")),
                    questionMap.get("Question Type"));
        });
    }
}
