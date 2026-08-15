package com.qa.ui.tests;

import com.qa.ui.pages.InventoryPage;
import com.qa.ui.pages.LoginPage;
import com.qa.ui.utils.Config;
import com.qa.ui.utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

  @BeforeMethod
  public void setUp() {
    DriverFactory.getDriver().manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    DriverFactory.quitDriver();
  }

  @Test(description = "TC-LOGIN-001 Valid credentials land on inventory page")
  public void validLoginOpensInventory() {
    InventoryPage inventory = new LoginPage(DriverFactory.getDriver())
        .open()
        .enterUsername(Config.username())
        .enterPassword(Config.password())
        .submitLogin();

    assertTrue(inventory.isLoaded(), "Inventory page should load after valid login");
  }

  @DataProvider(name = "invalidLogins")
  public Object[][] invalidLogins() {
    return new Object[][] {
        {"", "secret_sauce", "Username is required"},
        {"standard_user", "", "Password is required"},
        {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."}
    };
  }

  @Test(dataProvider = "invalidLogins", description = "TC-LOGIN-002 Negative login scenarios")
  public void invalidLoginShowsError(String user, String pass, String expectedFragment) {
    String message = new LoginPage(DriverFactory.getDriver())
        .open()
        .enterUsername(user)
        .enterPassword(pass)
        .submitLoginExpectingError()
        .errorMessage();

    assertTrue(message.contains(expectedFragment), "Unexpected error text: " + message);
  }

  @Test(description = "TC-LOGIN-003 Logout returns user to login screen")
  public void logoutReturnsToLogin() {
    LoginPage login = new LoginPage(DriverFactory.getDriver())
        .open()
        .enterUsername(Config.username())
        .enterPassword(Config.password())
        .submitLogin()
        .logout();

    assertTrue(login.isLoaded(), "Login page should appear after logout");
  }
}
