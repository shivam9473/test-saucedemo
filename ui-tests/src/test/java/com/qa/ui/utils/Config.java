package com.qa.ui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {

  private static final Properties PROPS = new Properties();

  static {
    try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (in != null) {
        PROPS.load(in);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Could not load config.properties", e);
    }
  }

  private Config() {}

  public static String baseUrl() {
    return firstNonBlank(System.getProperty("baseUrl"), PROPS.getProperty("baseUrl"));
  }

  public static String browser() {
    return firstNonBlank(System.getProperty("browser"), PROPS.getProperty("browser", "chrome"));
  }

  public static boolean headless() {
    String value = firstNonBlank(System.getProperty("headless"), PROPS.getProperty("headless", "false"));
    return Boolean.parseBoolean(value);
  }

  public static String username() {
    return PROPS.getProperty("standard.user", "standard_user");
  }

  public static String password() {
    return PROPS.getProperty("standard.password", "secret_sauce");
  }

  private static String firstNonBlank(String a, String b) {
    if (a != null && !a.isBlank()) {
      return a;
    }
    return b;
  }
}
