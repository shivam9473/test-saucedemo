package com.qa.ui.pages;

import com.qa.ui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

  private final WebDriver driver;

  private static final By PAGE_TITLE = By.cssSelector(".title");
  private static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
  private static final By ADD_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
  private static final By CART_LINK = By.cssSelector(".shopping_cart_link");
  private static final By MENU_BUTTON = By.id("react-burger-menu-btn");
  private static final By LOGOUT_LINK = By.id("logout_sidebar_link");
  private static final By LOGIN_USERNAME = By.id("user-name");

  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isLoaded() {
    return Waits.urlContains(driver, "inventory.html")
        && Waits.visible(driver, PAGE_TITLE).getText().equalsIgnoreCase("Products");
  }

  public InventoryPage addBackpackToCart() {
    Waits.click(driver, ADD_BACKPACK);
    Waits.visible(driver, CART_BADGE);
    return this;
  }

  public int cartItemCount() {
    return Integer.parseInt(Waits.visible(driver, CART_BADGE).getText());
  }

  public CartPage openCart() {
    Waits.click(driver, CART_LINK);
    Waits.urlContains(driver, "cart.html");
    return new CartPage(driver);
  }

  public LoginPage logout() {
    Waits.click(driver, MENU_BUTTON);
    Waits.clickable(driver, LOGOUT_LINK);
    Waits.click(driver, LOGOUT_LINK);
    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(15))
        .until(d -> !d.getCurrentUrl().contains("inventory.html"));
    Waits.visible(driver, LOGIN_USERNAME);
    return new LoginPage(driver);
  }
}
