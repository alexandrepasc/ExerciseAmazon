package com.ExerciseAmazon.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

  public static void scrollToElement(WebDriver driver, WebElement element)
    throws Exception {

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
  }

  public static String getHomeUkUrl() {

    return "https://www.amazon.co.uk/";
  }

  public static String getHomeComUrl() {

    return "https://www.amazon.com";
  }
}
