package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.ShopByDepartmentPage;
import com.ExerciseAmazon.translation.Translations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

public class ShopDepartTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui", "userMail", "userPassword" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui, String user, String pwd)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());

    element = new Elements(driver);

    //element.click(HomePage.butProfileMenu);

    //Utils.doLogin(user, pwd, element);
  }

  @Test(enabled = true, invocationCount = 1)
  public void openFitnessViewTest()
    throws Exception {

    //driver.get("https://www.amazon.co.uk/");

    element = new Elements(driver);

    Utils.waitingUntil(driver, HomePage.selectSgopByArrow, 20, Utils.WaitUntil.VISIBILITY);

    Actions action = new Actions(driver);
    action.moveToElement(element.getElement(HomePage.butDeliver)).pause(50).build().perform();
    action.moveToElement(element.getElement(HomePage.selectShopBy), 5, 5)
        .moveToElement(element.getElement(HomePage.selectShopBy)).build().perform();

    //    element.click(HomePage.selectShopBy);
    Utils.waitingUntil(driver, HomePage.selectShopBySportsOut, 20, Utils.WaitUntil.VISIBILITY);
    action.moveToElement(element.getElement(HomePage.selectShopBySportsOut)).build().perform();

    //element.click(HomePage.selectShopBySportsOut);
    element.click(HomePage.selectShopByFitness);

    Assert.assertEquals(element.getText(HomePage.labelSearchIn), Translations.selectSearchInFitness(element),
        ErrorText.VALUE.getText());

    element.click(ShopByDepartmentPage.butFeatureBrandSeeMore);
    Assert.assertEquals(element.getText(ShopByDepartmentPage.labelFeatureBrandTitle),
        Translations.labelFeatureBrandTopBrandTitle(element), ErrorText.VALUE.getText());

    element.click(ShopByDepartmentPage.butFeatureBrandA);
    Assert.assertEquals(element.getText(ShopByDepartmentPage.labelFeatureBrandTitle),
        Translations.labelFeatureBrandATitle(element), ErrorText.VALUE.getText());

    String brand = "Adidas";

    Assert.assertTrue(
        element.getText(ShopByDepartmentPage.containerFeatureBrand).toLowerCase().contains(brand.toLowerCase()),
        ErrorText.VALUE.getText());

    WebElement[] columns = element.getElement(ShopByDepartmentPage.containerFeatureBrand)
        .findElements(ShopByDepartmentPage.columnsFeatureBrand).toArray(new WebElement[0]);
    for (WebElement column : columns) {

      WebElement[] rows = column.findElements(ShopByDepartmentPage.itemsFeatureBrand).toArray(new WebElement[0]);
      for (WebElement row : rows) {

        if (row.getText().toLowerCase().contains(brand.toLowerCase())) {
          System.out.println(row.getText().toLowerCase());
          Utils.scrollToElement(driver, row);
          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("brandScreenshot.png"));

          break;
        }
      }
    }
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
