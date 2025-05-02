package com.lsantana.CucumberSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@name='user-name']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='login-button']")
	WebElement btnLogin;

	@FindBy(xpath = "//*[@class='error-button']")
	WebElement btnError;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void goToLoginPage(String url) {
		driver.get(url);
	}

	public void fillUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(txtUsername));
		txtUsername.sendKeys(username);
	}

	public void fillPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public boolean errorButtonIsPresent() {
		return btnError.isDisplayed();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
