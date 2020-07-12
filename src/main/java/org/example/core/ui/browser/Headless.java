package org.example.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.ui.browser.AbstractBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless extends AbstractBrowser {

	@Override
	WebDriver init() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		return new ChromeDriver(options);
	}
}
