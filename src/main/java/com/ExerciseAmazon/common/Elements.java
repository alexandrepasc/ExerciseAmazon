package com.ExerciseAmazon.common;

import org.openqa.selenium.*;

public class Elements {

  private static WebDriver driver;

  public Elements(WebDriver driver) {
    this.driver = driver;
  }

  public static WebElement getElement(By by) {
    try {

      return driver.findElement(by);

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static WebElement getElement(By by, int numb) {
    try {

      return driver.findElements(by).toArray(new WebElement[0])[numb];
    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static WebElement[] getElements(By by) {
    try {

      return driver.findElements(by).toArray(new WebElement[0]);

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static WebElement[] getElements(WebDriver driver, By by) {
    try {

      return driver.findElements(by).toArray(new WebElement[0]);

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static String getText(By by) {
    try {

      return getElement(by).getText();

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static String getText(By by, int numb) {
    try {

      return getElements(by)[numb].getText();

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static boolean click(By by) {
    try {

      getElement(by).click();
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (ElementClickInterceptedException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean click(By by, int numb) {
    try {

      getElements(by)[numb].click();
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (ElementClickInterceptedException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean sendKeys(By by, String text) {
    try {

      getElement(by).sendKeys(text);
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean sendKeys(By by, int text) {
    try {

      getElement(by).sendKeys(Integer.toString(text));
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean sendKeys(By by, String text, int numb) {
    try {

      getElements(by)[numb].sendKeys(text);
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean sendKeys(By by, int text, int numb) {
    try {

      getElements(by)[numb].sendKeys(Integer.toString(text));
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean clear(By by) {
    try {

      getElement(by).clear();

      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean clear(By by, int numb) {
    try {

      getElements(by)[numb].clear();

      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static String getAttribute(By by, String attribute) {
    try {

      return getElement(by).getAttribute(attribute);

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static String getAttribute(By by, String attribute, int numb) {
    try {

      return getElements(by)[numb].getAttribute(attribute);

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return null;

    } catch (Exception e) {
      return null;
    }
  }

  public static String getCssValue(By by, String value) {

    try {

      return getElement(by).getCssValue(value);

    } catch (StaleElementReferenceException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public static String getCssValue(By by, String value, int numb) {

    try {

      return getElements(by)[numb].getCssValue(value);

    } catch (StaleElementReferenceException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public static Point getLocation(By by) {

    try {

      return getElement(by).getLocation();

    } catch (StaleElementReferenceException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public static Point getLocation(By by, int numb) {

    try {

      return getElements(by)[numb].getLocation();

    } catch (StaleElementReferenceException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public static boolean isVisible(By by) {
    try {

      return getElement(by).isDisplayed();

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isVisible(By by, int numb) {
    try {

      return getElements(by)[numb].isDisplayed();

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isPresent(By by) {
    try {

      getElement(by).getLocation();
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isPresent(By by, int numb) {
    try {

      getElements(by)[numb].getLocation();
      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean checkElement(By by) {
    try {

      if (!isPresent(by)) {
        return false;
      }

      if (!isVisible(by)) {
        return false;
      }

      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }

  public static boolean checkElement(By by, int numb) {
    try {

      if (!isPresent(by, numb)) {
        return false;
      }

      if (!isVisible(by, numb)) {
        return false;
      }

      return true;

    } catch (StaleElementReferenceException e) {

      e.printStackTrace();
      return false;

    } catch (Exception e) {
      return false;
    }
  }
}
