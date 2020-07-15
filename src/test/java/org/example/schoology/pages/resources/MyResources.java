package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.AppPageFactory;
import org.example.schoology.pages.DeletePopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class MyResources extends AbstractPage {

    private static final String RESOURCES_ACTIONS_BUTTON =
            "//a[text()='%s']/ancestor::tr//div[@class='action-links-unfold ']/span";
    private static final String RESOURCE_LINK = "a[href*='%s']";
    private static final String RESOURCE_NAME_LINK = "//a[text()='%s']";

    private static final Map<String, String> SPECIAL_RESOURCE_TYPE_FOR_LOCATOR = new HashMap<>();
    static {
        SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.put("test/quiz", "/assessment");
        SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.put("assessment", "/assessment-v2");
    }

    @FindBy(xpath = "//div[ul[@id='toolbar-add-list']]")
    private WebElement addResources;

    @FindBy(css = "ul[style='display: block;'] .action-delete")
    private WebElement deleteResource;

    @FindBy(css = ".message-text")
    private WebElement messageText;

    @FindBy(css = ".messages-close-btn")
    private WebElement closeMessageButton;

    public AddResourcePopupAbstract clickAddResources(final String resourceType) {
        String resourceTypeModified = resourceType.toLowerCase();
        resourceTypeModified = SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.getOrDefault(resourceTypeModified,
                resourceTypeModified.replaceAll(" ", "_"));
        addResources.click();
        driver.findElement(By.cssSelector(String.format(RESOURCE_LINK, resourceTypeModified))).click();
        return AppPageFactory.getAddResourcePopup(resourceType);
    }

    public DeletePopup deleteResource(final String resourceName) {
        WebElement resourcesActionsButton = driver.findElement(By.xpath(String.format(RESOURCES_ACTIONS_BUTTON, resourceName)));

        resourcesActionsButton.click();
        deleteResource.click();
        return new DeletePopup();
    }

    public void openQuestionBankResource(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_NAME_LINK, resourceName)));
    }
}
