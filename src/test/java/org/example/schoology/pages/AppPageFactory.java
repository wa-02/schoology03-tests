package org.example.schoology.pages;

import org.example.schoology.constants.Constants.QuestionType;
import org.example.schoology.constants.Constants.ResourceType;
import org.example.schoology.pages.questions.CreateEssayQuestion;
import org.example.schoology.pages.questions.CreateMultipleChoiceQuestion;
import org.example.schoology.pages.questions.CreateOrderingQuestion;
import org.example.schoology.pages.questions.CreateQuestionAbstract;
import org.example.schoology.pages.questions.CreateTrueFalseQuestion;
import org.example.schoology.pages.resources.AddAssignmentResourcePopup;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.AddResourcePopupAbstract;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.example.schoology.pages.resources.QuestionResourceAbstract;
import org.example.schoology.pages.resources.QuizResource;

import java.util.HashMap;
import java.util.function.Supplier;

public class AppPageFactory {

    public static AddResourcePopupAbstract getAddResourcePopup(final String resourceType) {
        HashMap<ResourceType, Supplier<AddResourcePopupAbstract>> addResourcePopupMap = new HashMap<>();
        addResourcePopupMap.put(ResourceType.QUESTION_BANK, AddQuestionBankResourcePopup::new);
        addResourcePopupMap.put(ResourceType.TEST_QUIZ, AddTestQuizResourcePopup::new);
        addResourcePopupMap.put(ResourceType.ASSIGNMENT, AddAssignmentResourcePopup::new);
        return addResourcePopupMap.get(ResourceType.getResourceType(resourceType)).get();
    }

    public static QuestionResourceAbstract getQuestionResource(final String resourceType) {
        HashMap<ResourceType, Supplier<QuestionResourceAbstract>> questionResourceMap = new HashMap<>();
        questionResourceMap.put(ResourceType.QUESTION_BANK, QuestionBankResource::new);
        questionResourceMap.put(ResourceType.TEST_QUIZ, QuizResource::new);
        return questionResourceMap.get(ResourceType.getResourceType(resourceType)).get();
    }

    public static CreateQuestionAbstract getCreateQuestion(final String questionType) {
        HashMap<QuestionType, Supplier<CreateQuestionAbstract>> createQuestionMap = new HashMap<>();
        createQuestionMap.put(QuestionType.TRUE_FALSE, CreateTrueFalseQuestion::new);
        createQuestionMap.put(QuestionType.MULTIPLE_CHOICE, CreateMultipleChoiceQuestion::new);
        createQuestionMap.put(QuestionType.ORDERING, CreateOrderingQuestion::new);
        createQuestionMap.put(QuestionType.SHORT_ANSWER_ESSAY_QUESTION, CreateEssayQuestion::new);
        return createQuestionMap.get(QuestionType.getQuestionType(questionType)).get();
    }
}
