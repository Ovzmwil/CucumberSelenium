package com.lsantana.CucumberSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//button[@name='checkout']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@name='postalCode']")
	WebElement txtPostalCode;
	
	@FindBy(xpath = "//input[@name='continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//button[@name='finish']")
	WebElement btnFinish;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement msgThanking;
	
	@FindBy(xpath = "//*[@class='error-button']")
	WebElement btnError;
	
	@FindBy(xpath = "//*[@class='title']")
	WebElement checkoutTitle;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	public void clickCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
		btnCheckout.click();
	}
	
	public void fillFirtName(String firstName) {
		wait.until(ExpectedConditions.elementToBeClickable(txtFirstName));
		txtFirstName.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		wait.until(ExpectedConditions.elementToBeClickable(txtLastName));
		txtLastName.sendKeys(lastName);
	}
	
	public void fillPostalCode(String postalCode) {
		wait.until(ExpectedConditions.elementToBeClickable(txtPostalCode));
		txtPostalCode.sendKeys(postalCode);
	}
	
	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
		btnContinue.click();
	}
	
	public void clickFinish() {
		wait.until(ExpectedConditions.elementToBeClickable(btnFinish));
		btnFinish.click();
	}
	
	public boolean errorButtonIsPresent() {
		return btnError.isDisplayed();
	}
	
	public String getThankingMessage() {
		return msgThanking.getText();
	}
	
	public String getCheckoutTitle() {
		return checkoutTitle.getText();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
