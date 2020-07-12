package org.example.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.ui.browser.AbstractBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends AbstractBrowser {
	@Override
	WebDriver init() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}
