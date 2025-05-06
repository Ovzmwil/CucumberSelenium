package com.lsantana.CucumberSelenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> products;

	@FindBy(xpath = "//div[@class='inventory_item_description']")
	List<WebElement> descriptions;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> prices;

	@FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
	List<WebElement> btnsAddToCart;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement btnShoppingCartBadge;
	
	@FindBy(id = "react-burger-menu-btn")
	WebElement btnBurgerMenu;
	
	@FindBy(id = "logout_sidebar_link")
	WebElement btnLogout;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void addAllProductsToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(btnsAddToCart.get(0)));
		System.out.println(btnsAddToCart.size());
		for (WebElement element : btnsAddToCart) {
			element.click();
		}
	}

	public String getNumberOfProductsInCart() {
		return btnShoppingCartBadge.getText();
	}

	public void clickCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnShoppingCartBadge));
		btnShoppingCartBadge.click();
	}

	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(btnBurgerMenu));
		btnBurgerMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		btnLogout.click();
	}
}
