package org.example.schoology.pages.questions;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.MyResources;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportQuestionPopup extends AbstractPage {

    @FindBy(css = "a[href*='import_from_resources/individual")
    private WebElement addIndividualQuestionBtn;

    public MyResources clickIndividualQuestions() {
        action.click(addIndividualQuestionBtn);
        return new MyResources();
    }
}
