package org.example.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebdriverAction {

    private WebDriver driver;

    private WebDriverWait wait;

    public WebdriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public String getText(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getText(final By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void setText(final WebElement webElement, final String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void setText(final By locator, final String text) {
        setText(driver.findElement(locator), text);
    }

    public void selectDropDown(final WebElement webElement, final String option) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select selectField = new Select(webElement);
        selectField.selectByVisibleText(option);
    }

    public void scrollToElement(final WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView("
                + "{ behavior: 'auto', block: 'center', inline: 'center'});", webElement);
    }

    public boolean isSubMenuExpanded(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return Boolean.parseBoolean(driver.findElement(locator).getAttribute("aria-expanded"));
    }

    public boolean isElementPresent(final By locator, final int waitTime) {
        try {
			// Changing timeout
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
			// Restore timeout
            driver.manage().timeouts().implicitlyWait(AbstractPage.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public void selectCheckBox(final By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (!checkbox.isSelected()) {
            click(checkbox);
        }
    }
}
