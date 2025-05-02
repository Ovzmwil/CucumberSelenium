package com.lsantana.CucumberSelenium;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.lsantana.CucumberSelenium.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

	private WebDriver driver;

	LoginPage loginPage;
	ProductsPage productsPage;
	CheckoutPage checkoutPage;

	@Given("I go to the login page of Swag Labs")
	public void i_go_to_the_login_page_of_swag_labs() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		checkoutPage = new CheckoutPage(driver);

		loginPage.goToLoginPage("https://www.saucedemo.com");

	}
	@Given("I fill the field username {string}")
	public void i_fill_the_field_username(String username) {
		loginPage.fillUsername(username);
	}
	@Given("I fill the field password {string}")
	public void i_fill_the_field_password(String password) {
		loginPage.fillPassword(password);
	}
	@Given("I click login button")
	public void i_click_login_button() {
		loginPage.clickLogin();
	}
	@Then("an error message should open")
	public void an_error_message_should_open() {
		assertThat(loginPage.errorButtonIsPresent()).isEqualTo(true);
	}
	@Given("I add all products to the cart")
	public void i_add_all_products_to_the_cart() {
		productsPage.addAllProductsToCart();
	}
	@Given("I go to the checkout page")
	public void i_go_to_the_checkout_page() {
		productsPage.clickCartButton();
	}
	@Given("I click checkout button")
	public void i_click_checkout_button() {
		checkoutPage.clickCheckout();
	}
	@Given("I fill the field firstName {string}")
	public void i_fill_the_field_first_name(String firstName) {
		checkoutPage.fillFirtName(firstName);
	}
	@Given("I fill the field lastName {string}")
	public void i_fill_the_field_last_name(String lastName) {
		checkoutPage.fillLastName(lastName);
	}
	@Given("I fill the field postalCode {string}")
	public void i_fill_the_field_postal_code(String postalCode) {
		checkoutPage.fillPostalCode(postalCode);
	}
	@Given("I click continue button")
	public void i_click_continue_button() {
		checkoutPage.clickContinue();
	}
	@Given("I click finish button")
	public void i_click_finish_button() {
		checkoutPage.clickFinish();
	}
	@Then("the checkout is completed")
	public void the_checkout_is_completed() {
		assertThat(checkoutPage.getCheckoutTitle()).contains("Complete!");
	}
	@Then("a message informing my purchase is done should be visible")
	public void a_message_informing_my_purchase_is_done_should_be_visible() {
		assertThat(checkoutPage.getThankingMessage()).contains("Thank you for your order!");
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit(); 
		}
	}
}
