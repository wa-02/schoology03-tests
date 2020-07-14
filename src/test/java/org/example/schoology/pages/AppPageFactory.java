package org.example.schoology.pages;

import org.example.schoology.pages.resources.AddAssignmentResourcePopup;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.AddResourcePopupAbstract;
import org.example.schoology.pages.questions.CreateMultipleChoiceQuestion;
import org.example.schoology.pages.questions.CreateOrderingQuestion;
import org.example.schoology.pages.questions.CreateQuestionAbstract;
import org.example.schoology.pages.questions.CreateTrueFalseQuestion;
import org.example.schoology.pages.questions.CreateEssayQuestion;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.example.schoology.pages.resources.QuestionResourceAbstract;
import org.example.schoology.pages.resources.QuizResource;

import java.util.HashMap;
import java.util.function.Supplier;

public class AppPageFactory {

    public static AddResourcePopupAbstract getAddResourcePopup(final String resourceType) {
        HashMap<String, Supplier<AddResourcePopupAbstract>> addResourcePopupMap = new HashMap<>();
        addResourcePopupMap.put("Question Bank", AddQuestionBankResourcePopup::new);
        addResourcePopupMap.put("Test/Quiz", AddTestQuizResourcePopup::new);
        addResourcePopupMap.put("Assignment", AddAssignmentResourcePopup::new);
        return addResourcePopupMap.get(resourceType).get();
    }

    public static CreateQuestionAbstract getCreateQuestion(final String questionType) {
        HashMap<String, Supplier<CreateQuestionAbstract>> createQuestionMap = new HashMap<>();
        createQuestionMap.put("True/False", CreateTrueFalseQuestion::new);
        createQuestionMap.put("Multiple Choice", CreateMultipleChoiceQuestion::new);
        createQuestionMap.put("Ordering", CreateOrderingQuestion::new);
        createQuestionMap.put("Short-Answer/Essay Question", CreateEssayQuestion::new);
        return createQuestionMap.get(questionType).get();
    }

    public static QuestionResourceAbstract getQuestionResource(final String resourceType) {
        HashMap<String, Supplier<QuestionResourceAbstract>> questionResourceMap = new HashMap<>();
        questionResourceMap.put("Question Bank", QuestionBankResource::new);
        questionResourceMap.put("Test/Quiz", QuizResource::new);
        return questionResourceMap.get(resourceType).get();
    }
}
