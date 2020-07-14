package org.example.schoology.pages.questions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MultipleOptionsComponent extends AbstractPage {

    private static final By OPTIONS_BY = By.cssSelector("div[id*='text-wrapper']");

    private static final String LAST_OPTION_CSS ="div[id*='%s-text-wrapper']";

    @FindBy(css = "#edit-num-choices")
    private WebElement choicesSelect;

    @FindBy(css = "#edit-add-choice")
    private WebElement addChoicesButton;

    @FindBy(css = "#edit-remove-blanks")
    private WebElement removeBlanks;


    private void addMoreChoices(int totalOptions) {
        int optionsToAdd = totalOptions - driver.findElements(OPTIONS_BY).size();
        if (optionsToAdd > 0) {
            action.selectDropDown(choicesSelect, String.valueOf(optionsToAdd));
            action.click(addChoicesButton);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format(LAST_OPTION_CSS,
                totalOptions - 1))));
    }

    private void clickRemoveBlanksButton() {
        action.click(removeBlanks);
        wait.until(ExpectedConditions.visibilityOfElementLocated(OPTIONS_BY));
    }

    public void setOptions(final String textAreaCss, final String options) {
        String[] optionArray = options.split(", ");

        addMoreChoices(optionArray.length);

        // Set values
        for (int i = 0; i < optionArray.length; i++) {
            action.setText(By.cssSelector(String.format(textAreaCss, i)), optionArray[i]);
        }
        clickRemoveBlanksButton();
    }
}
