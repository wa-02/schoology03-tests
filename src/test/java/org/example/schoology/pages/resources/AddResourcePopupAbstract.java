package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public abstract class AddResourcePopupAbstract extends AbstractPage {

    private static final String RESOURCE_NAME_XPATH = "//*[text()='%s']";

    @FindBy(css = "input[class='form-submit'][id='edit-submit']")
    protected WebElement submitButton;

    public MyResources addResource(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = getStepsMap(resourceMap);

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
        submitButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(RESOURCE_NAME_XPATH,
                resourceMap.get("Name")))));
        return new MyResources();
    }

    protected abstract Map<String, Step> getStepsMap(final Map<String, String> resourceMap);
}
