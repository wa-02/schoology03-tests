package org.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

	private static List<WebDriver> storedDrivers = new ArrayList<>();
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
	}

	public static void addDriver(WebDriver driver) {
		drivers.set(driver);
		storedDrivers.add(driver);
	}

	public static WebDriver getDriver() {
		return drivers.get();
	}

}
