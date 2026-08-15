package com.qa.ui.pages;

import com.qa.ui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

  private final WebDriver driver;

  private static final By FIRST_NAME = By.id("first-name");
  private static final By LAST_NAME = By.id("last-name");
  private static final By POSTAL_CODE = By.id("postal-code");
  private static final By CONTINUE_BUTTON = By.id("continue");
  private static final By FINISH_BUTTON = By.id("finish");
  private static final By COMPLETE_HEADER = By.cssSelector(".complete-header");

  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
  }

  public CheckoutPage fillShipping(String first, String last, String zip) {
    Waits.type(driver, FIRST_NAME, first);
    Waits.type(driver, LAST_NAME, last);
    Waits.type(driver, POSTAL_CODE, zip);
    Waits.click(driver, CONTINUE_BUTTON);
    Waits.visible(driver, FINISH_BUTTON);
    return this;
  }

  public CheckoutPage finishOrder() {
    Waits.click(driver, FINISH_BUTTON);
    return this;
  }

  public String confirmationMessage() {
    return Waits.visible(driver, COMPLETE_HEADER).getText();
  }
}
