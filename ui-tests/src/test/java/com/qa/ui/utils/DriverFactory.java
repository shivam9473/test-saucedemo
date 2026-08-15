package com.qa.ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {

  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

  private DriverFactory() {}

  public static WebDriver getDriver() {
    if (DRIVER.get() == null) {
      DRIVER.set(createDriver());
    }
    return DRIVER.get();
  }

  public static void quitDriver() {
    WebDriver driver = DRIVER.get();
    if (driver != null) {
      driver.quit();
      DRIVER.remove();
    }
  }

  private static WebDriver createDriver() {
    String browser = Config.browser().toLowerCase();
    boolean headless = Config.headless();

    return switch (browser) {
      case "firefox" -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
          options.addArguments("-headless");
        }
        yield new FirefoxDriver(options);
      }
      default -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) {
          options.addArguments("--headless=new", "--window-size=1920,1080", "--disable-gpu");
        }
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        yield new ChromeDriver(options);
      }
    };
  }
}
