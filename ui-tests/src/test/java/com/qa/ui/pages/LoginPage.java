package com.qa.ui.pages;

import com.qa.ui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  private final WebDriver driver;

  private static final By USERNAME = By.id("user-name");
  private static final By PASSWORD = By.id("password");
  private static final By LOGIN_BUTTON = By.id("login-button");
  private static final By ERROR_BANNER = By.cssSelector("[data-test='error']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage open() {
    driver.get(com.qa.ui.utils.Config.baseUrl());
    return this;
  }

  public LoginPage enterUsername(String username) {
    Waits.visible(driver, USERNAME).clear();
    driver.findElement(USERNAME).sendKeys(username);
    return this;
  }

  public LoginPage enterPassword(String password) {
    Waits.visible(driver, PASSWORD).clear();
    driver.findElement(PASSWORD).sendKeys(password);
    return this;
  }

  public InventoryPage submitLogin() {
    Waits.click(driver, LOGIN_BUTTON);
    return new InventoryPage(driver);
  }

  public LoginPage submitLoginExpectingError() {
    Waits.click(driver, LOGIN_BUTTON);
    return this;
  }

  public String errorMessage() {
    return Waits.visible(driver, ERROR_BANNER).getText();
  }

  public boolean isLoaded() {
    return Waits.visible(driver, USERNAME).isDisplayed()
        && Waits.visible(driver, LOGIN_BUTTON).isDisplayed();
  }
}
