package com.lsantana.CucumberSelenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
	
	public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
