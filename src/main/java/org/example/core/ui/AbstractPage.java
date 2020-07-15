package org.example.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

	@FindBy(css = "#edit-submit")
	protected WebElement submitButton;

	public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
	public static final int EXPLICIT_WAIT_IN_SECONDS = 20;

	protected WebDriver driver;

	protected WebDriverWait wait;

	protected WebdriverAction action;

	public AbstractPage() {
		this.driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, EXPLICIT_WAIT_IN_SECONDS);
		this.action = new WebdriverAction(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
