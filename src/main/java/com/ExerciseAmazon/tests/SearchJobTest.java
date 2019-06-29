package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.JobSearchHomePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchJobTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getJobSearchUrl());
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchPortugalSetubalTest()
    throws Exception {

    element = new Elements(driver);

    String search = "Portugal, setubal";
    //Assert.assertTrue(element.checkElement(JobSearchHomePage.inputLocation));
    element.sendKeys(JobSearchHomePage.inputLocation, search);

    //return Normalizer.normalize(string, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    WebElement[] results = element.getElement(JobSearchHomePage.selectLocation)
        .findElements(JobSearchHomePage.selectLocationList).toArray(new WebElement[0]);
    System.out.println(results.length);
    for (WebElement result : results) {

      if (StringUtils.stripAccents(search).toLowerCase().contains(StringUtils
          .stripAccents(result.findElement(JobSearchHomePage.selectLocationTitle1).getText().toLowerCase()))) {

        if (StringUtils.stripAccents(search).toLowerCase().contains(StringUtils
            .stripAccents(result.findElement(JobSearchHomePage.selectLocationTitle2).getText().toLowerCase()))) {

          result.click();
          break;
        }
      }
      //System.out.println("result: " + result.getText());

      //System.out.println("title2: " + result.findElement(JobSearchHomePage.selectLocationTitle2).getText());
    }
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
