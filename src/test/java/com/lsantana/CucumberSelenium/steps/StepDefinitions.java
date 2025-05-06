package com.lsantana.CucumberSelenium.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import com.lsantana.CucumberSelenium.pages.*;
import com.lsantana.CucumberSelenium.util.DriverFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class StepDefinitions {

	private WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	CheckoutPage checkoutPage;

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@Given("I go to the login page of Swag Labs")
	public void i_go_to_the_login_page_of_swag_labs() {
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

	@Given("I try to login with {string} and {string}")
	public void i_try_to_login_with(String username, String password) {
		loginPage.fillUsername(username);
		loginPage.fillPassword(password);
		loginPage.clickLogin();
	}

	@Given("I login with valid credentials")
	public void i_login_with_valid_credentials() {
		loginPage.loginStandardUser();
	}

	@Given("I click login button")
	public void i_click_login_button() {
		loginPage.clickLogin();
	}
	@Then("an error message should open")
	public void an_error_message_should_open() {
		assertThat(loginPage.errorButtonIsPresent()).isTrue();
	}
	@Given("I add all products to the cart")
	public void i_add_all_products_to_the_cart() {
		productsPage.addAllProductsToCart();
	}
	@Given("I go to the checkout page")
	public void i_go_to_the_checkout_page() {
		productsPage.clickCartButton();
		checkoutPage.clickCheckout();
	}

	@Given("I fill the personal information {string}, {string}, {string}")
	public void i_fill_the_personal_information(String firstName, String lastName, String postalCode) {
		checkoutPage.fillPersonalInformation(firstName, lastName, postalCode);
	}
	@Given("I click finish button")
	public void i_click_finish_button() {
		checkoutPage.clickFinish();
	}
	@Given("I logout")
	public void i_logout() {
		productsPage.logout();
	}
	@Then("I go back to the login page")
	public void i_go_back_to_the_login_page() {
		assertThat(loginPage.loginButtonIsPresent()).isTrue();
	}
	@Then("the checkout is completed")
	public void the_checkout_is_completed() {
		assertThat(checkoutPage.getCheckoutTitle()).contains("Complete!");
	}
	@Then("I check the overview")
	public void i_check_the_overview() {
		float sumOfProducts = checkoutPage.getSumOfProducts();
		float itemTotal = checkoutPage.getItemTotal();
		float tax = checkoutPage.getTax();
		float priceTotal = checkoutPage.getPriceTotal();
		int itemsNumber = 6;

		assertThat(checkoutPage.getProductsNumberOnCheckout()).isEqualTo(itemsNumber);
		assertThat(sumOfProducts).isEqualTo(itemTotal);
		assertThat(tax).isCloseTo((priceTotal - sumOfProducts), offset(0.01F));
		assertThat(priceTotal).isCloseTo((itemTotal + tax), offset(0.01F));
	}
	@Then("a message informing my purchase is done should be visible")
	public void a_message_informing_my_purchase_is_done_should_be_visible() {
		assertThat(checkoutPage.getThankingMessage()).contains("Thank you for your order!");
	}
	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
