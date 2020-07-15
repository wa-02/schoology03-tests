package org.example.schoology.pages.questions;

import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;

import java.util.HashMap;
import java.util.Map;

public class CreateOrderingQuestion extends CreateQuestionAbstract {

    private MultipleOptionsComponent multipleOptionsComponent;

    private static final String CHOICE_CSS = "#edit-ordering-choices-%s-text";

    public CreateOrderingQuestion() {
        super();
        multipleOptionsComponent = new MultipleOptionsComponent();
    }

    @Override
    public Map<String, Step> getStepsMap(Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.TITLE, () -> setTitle(questionMap.get(Constants.TITLE)));
        stepsMap.put(Constants.ITEMS, () -> setItems(questionMap.get(Constants.ITEMS)));
        return stepsMap;
    }

    private void setItems(final String items) {
        multipleOptionsComponent.setOptions(CHOICE_CSS, items);
    }
}
