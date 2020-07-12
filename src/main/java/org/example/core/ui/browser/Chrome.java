package org.example.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.ui.browser.AbstractBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends AbstractBrowser {
	@Override
	WebDriver init() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
}
