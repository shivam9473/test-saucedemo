package com.qa.ui.listeners;

import com.qa.ui.utils.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = DriverFactory.getDriver();
    if (!(driver instanceof TakesScreenshot screenshot)) {
      return;
    }

    byte[] png = screenshot.getScreenshotAs(OutputType.BYTES);
    String name = result.getMethod().getMethodName();
    String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    Path dir = Path.of("target", "screenshots");
    Path file = dir.resolve(name + "-" + stamp + ".png");

    try {
      Files.createDirectories(dir);
      Files.write(file, png);
      System.err.println("Saved failure screenshot: " + file.toAbsolutePath());
    } catch (IOException e) {
      System.err.println("Could not save screenshot: " + e.getMessage());
    }
  }
}
