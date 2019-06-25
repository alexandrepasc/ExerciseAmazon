package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.ItemDetailsPage;
import com.ExerciseAmazon.elements.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchBookTest()
    throws Exception {

    element = new Elements(driver);

    element.click(HomePage.selectSearchIn);
    element.click(HomePage.selectSearchInBooks);

    element.sendKeys(HomePage.inputSearch, "chasing Excellence");

    element.click(HomePage.butSearch);

    Assert.assertTrue(element.getText(SearchResultPage.labelResultNumber).contains("results"));

    //TODO Check this later
    WebElement[] elements = element.getElements(SearchResultPage.listResults);
    for (int i = 0; i < elements.length; i++) {

      if (elements[i].getText().contains("Bergeron")) {
        System.out.println(i);
        elements[i].findElement(By.className("a-link-normal")).click();
        //element.click(SearchResultPage.listResults, i);

        break;
      }
    }

    Assert.assertTrue(element.checkElement(ItemDetailsPage.labelTitle));

    if (element.checkElement(ItemDetailsPage.popupKindle)) {

      element.click(ItemDetailsPage.butPopupKindleClose);
    }
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
