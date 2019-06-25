package com.ExerciseAmazon.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class PreTest {

  public static WebDriver driver;

  public static void beforeTest(String browser, String gui) {
    switch (browser) {
      case "firefox":
        firefox(gui);
        break;
      case "chrome":
        chrome(gui);
        break;
    }

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1366, 768));
  }

  static void firefox(String gui) {

    switch (gui) {
      case "yes":
        driver = new FirefoxDriver();
        break;
      case "no":
        firefoxHeadless();
        break;
    }
  }

  public static void firefoxHeadless() {

    FirefoxBinary firefoxBinary = new FirefoxBinary();
    firefoxBinary.addCommandLineOptions("--headless");
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setBinary(firefoxBinary);

    driver = new FirefoxDriver(firefoxOptions);
  }

  static void chrome(String gui) {

    switch (gui) {
      case "yes":
        driver = new ChromeDriver();
        break;
      case "no":
        chromeHeadless();
        break;
    }
  }

  public static void chromeHeadless() {

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");

    driver = new ChromeDriver(chromeOptions);
  }

  public static void afterTest() {
    driver.quit();
  }
}
