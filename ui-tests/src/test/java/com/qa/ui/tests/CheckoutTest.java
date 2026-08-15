package com.qa.ui.tests;

import com.qa.ui.pages.CartPage;
import com.qa.ui.pages.CheckoutPage;
import com.qa.ui.pages.InventoryPage;
import com.qa.ui.pages.LoginPage;
import com.qa.ui.utils.Config;
import com.qa.ui.utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest {

  private InventoryPage inventory;

  @BeforeMethod
  public void setUp() {
    DriverFactory.getDriver().manage().window().maximize();
    inventory = new LoginPage(DriverFactory.getDriver())
        .open()
        .enterUsername(Config.username())
        .enterPassword(Config.password())
        .submitLogin();
    assertTrue(inventory.isLoaded());
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    DriverFactory.quitDriver();
  }

  @Test(description = "TC-CART-001 Add item updates cart badge")
  public void addItemUpdatesBadge() {
    inventory.addBackpackToCart();
    assertEquals(inventory.cartItemCount(), 1);
  }

  @Test(description = "TC-CHECKOUT-001 Complete checkout flow")
  public void completeCheckout() {
    CartPage cart = inventory.addBackpackToCart().openCart();
    assertTrue(cart.isLoaded());
    assertEquals(cart.lineItemCount(), 1);

    CheckoutPage checkout = cart.proceedToCheckout()
        .fillShipping("Alex", "Rivera", "560001")
        .finishOrder();

    assertEquals(checkout.confirmationMessage(), "Thank you for your order!");
  }
}
