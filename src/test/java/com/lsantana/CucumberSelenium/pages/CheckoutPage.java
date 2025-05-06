package com.lsantana.CucumberSelenium.pages;

import java.util.List;

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

	@FindBy(className = "inventory_item_price")
	List<WebElement> prices;

	@FindBy(className = "summary_subtotal_label")
	WebElement itemTotal;

	@FindBy(className = "summary_tax_label")
	WebElement tax;

	@FindBy(className = "summary_total_label")
	WebElement total;
	
	@FindBy(className = "inventory_item_name")
	List<WebElement> itemNames;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
		btnCheckout.click();
	}

	public void fillFisrtName(String firstName) {
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
	
	public void fillPersonalInformation(String firstName, String lastName, String postalCode) {
		fillFisrtName(firstName);
		fillLastName(lastName);
		fillPostalCode(postalCode);
		clickContinue();
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

	public int getProductsNumberOnCheckout() {
		return itemNames.size();
	}

	private float getFloatValueFromElement(WebElement element) {
		return Float.parseFloat(element.getText().replaceAll("[^\\d.]", ""));
	}

	public float getSumOfProducts() {
		float sum = 0;
		for (WebElement element : prices) {
			sum += Float.parseFloat(element.getText().replace("$", "")); 
		}
		return sum;
	}

	public float getItemTotal() {
		return getFloatValueFromElement(itemTotal);
	}

	public float getTax() {
		return getFloatValueFromElement(tax);
	}

	public float getPriceTotal() {
		return getFloatValueFromElement(total);
	}

}
