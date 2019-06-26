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
    CLICKABLE
  }

  public static void waitingUntil(WebDriver driver_, By by_, int time_, WaitUntil what_) {
    WebDriverWait wait = new WebDriverWait(driver_, time_);
    switch (what_) {
      case VISIBILITY:
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_));
        break;
      case CLICKABLE:
        wait.until(ExpectedConditions.elementToBeClickable(by_));
        break;
    }
  }

  public static void doLogin(String user, String pwd, Elements element)
    throws Exception {

    for (int i = 0; i < user.length(); i++) {
      element.sendKeys(LoginPage.inputMail, Character.toString(user.charAt(i)));
      Thread.sleep(150);
    }

    for (int i = 0; i < pwd.length(); i++) {
      element.sendKeys(LoginPage.inputPassword, Character.toString(pwd.charAt(i)));
      Thread.sleep(150);
    }

    element.click(LoginPage.butLogin);
  }

  public static String getHomeUkUrl() {

    return "https://www.amazon.co.uk/";
  }

  public static String getHomeComUrl() {

    return "https://www.amazon.com";
  }
}
