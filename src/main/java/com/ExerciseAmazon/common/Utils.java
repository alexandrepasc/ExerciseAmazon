package com.ExerciseAmazon.common;

import com.ExerciseAmazon.elements.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

  public static void scrollToElement(WebDriver driver, WebElement element)
    throws Exception {

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
  }

  public enum WaitUntil {
    VISIBILITY,
    CLICKABLE,
    ATTRIBUTE
  }

  public static void waitingUntil(WebDriver driver, By by, int time, WaitUntil what) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    switch (what) {
      case VISIBILITY:
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        break;
      case CLICKABLE:
        wait.until(ExpectedConditions.elementToBeClickable(by));
        break;
    }
  }

  public static void waitingUntil(WebDriver driver, By by, int time, WaitUntil what, String attribute,
      String attribValue) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    switch (what) {
      case ATTRIBUTE:
        wait.until(ExpectedConditions.attributeContains(by, attribute, attribValue));
        break;
    }
  }

  //TODO Check the view to add phone after login
  public static void doLogin(String user, String pwd, Elements element)
    throws Exception {

    for (int i = 0; i < user.length(); i++) {
      element.sendKeys(LoginPage.inputMail, Character.toString(user.charAt(i)));
      Thread.sleep(100);
    }

    for (int i = 0; i < pwd.length(); i++) {
      element.sendKeys(LoginPage.inputPassword, Character.toString(pwd.charAt(i)));
      Thread.sleep(100);
    }

    Thread.sleep(100);
    element.click(LoginPage.butLogin);
  }

  public static String getHomeUkUrl() {

    return "https://www.amazon.co.uk/";
  }

  public static String getHomeComUrl() {

    return "https://www.amazon.com";
  }
}
