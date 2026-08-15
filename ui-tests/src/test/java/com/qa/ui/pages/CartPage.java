package com.qa.ui.pages;

import com.qa.ui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

  private final WebDriver driver;

  private static final By PAGE_TITLE = By.cssSelector(".title");
  private static final By CHECKOUT_BUTTON = By.id("checkout");
  private static final By CART_ITEM = By.cssSelector(".cart_item");

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isLoaded() {
    return Waits.urlContains(driver, "cart.html")
        && Waits.visible(driver, PAGE_TITLE).getText().equalsIgnoreCase("Your Cart");
  }

  public int lineItemCount() {
    return driver.findElements(CART_ITEM).size();
  }

  public CheckoutPage proceedToCheckout() {
    Waits.click(driver, CHECKOUT_BUTTON);
    Waits.urlContains(driver, "checkout-step-one.html");
    return new CheckoutPage(driver);
  }
}
