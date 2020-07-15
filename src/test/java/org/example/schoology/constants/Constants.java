package org.example.schoology.constants;

import org.example.core.StringHelper;

public final class Constants {

    public enum ResourceType {
        QUESTION_BANK,
        TEST_QUIZ,
        ASSIGNMENT;

        public static ResourceType getResourceType(final String resourceType) {
            return ResourceType.valueOf(StringHelper.convertToUpperUnderscore(resourceType));
        }
    }

    public enum QuestionType {

        FILL_IN_THE_BLANK,
        MATCHING,
        MULTIPLE_CHOICE,
        ORDERING,
        SHORT_ANSWER_ESSAY_QUESTION,
        TRUE_FALSE;

        public static QuestionType getQuestionType(final String questionType) {
            return QuestionType.valueOf(StringHelper.convertToUpperUnderscore(questionType));
        }
    }

    public static final String CHARACTER_LIMIT = "Character Limit";

    public static final String CHOICES = "Choices";

    public static final String CORRECT_ANSWER = "Correct Answer";

    public static final String CORRECT_ANSWERS = "Correct Answers";

    public static final String DESCRIPTION = "Description";

    public static final String ENABLE_QUESTION_TRACKING = "Enable Question Tracking";

    public static final String ITEMS = "Items";

    public static final String NAME = "Name";

    public static final String QUESTION_TYPE = "Question Type";

    public static final String RESOURCES = "Resources";

    public static final String RESOURCE_KEY = "ResourceKey";

    public static final String TITLE = "Title";

    public static final String YES = "Yes";
}
