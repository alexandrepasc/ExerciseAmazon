package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.JobSearchHomePage;
import com.ExerciseAmazon.elements.JobSearchResultsPage;

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

    for (WebElement result : results) {

      if (StringUtils.stripAccents(search).toLowerCase().contains(StringUtils
          .stripAccents(result.findElement(JobSearchHomePage.selectLocationTitle1).getText().toLowerCase()))) {

        if (StringUtils.stripAccents(search).toLowerCase().contains(StringUtils
            .stripAccents(result.findElement(JobSearchHomePage.selectLocationTitle2).getText().toLowerCase()))) {

          result.click();
          break;
        }
      }
    }

    Utils.waitingUntil(driver, JobSearchResultsPage.containerResults, 20, Utils.WaitUntil.VISIBILITY);

    Assert.assertTrue(driver.getCurrentUrl().contains("search?"), ErrorText.PAGE.getText());

    Assert.assertFalse(element.checkElement(JobSearchResultsPage.containerEmptySearch), "No results.");
    Assert.assertTrue(element.checkElement(JobSearchResultsPage.labelResultNumber), "No results.");
  }

  @Test(enabled = true, invocationCount = 1)
  public void changeDistanceTest()
    throws Exception {

    driver.get(Utils.getJobSearchUrl()
        .concat("/search?base_query=&loc_query=Setúbal%2C+Portugal&latitude=38.5247&longitude=-8.89423"));

    element = new Elements(driver);

    Utils.waitingUntil(driver, JobSearchResultsPage.containerRadius, 20, Utils.WaitUntil.VISIBILITY);
    element.click(JobSearchResultsPage.butRadius5Mi);

    Utils.waitingUntil(driver, JobSearchResultsPage.containerResults, 20, Utils.WaitUntil.VISIBILITY);

    Assert.assertTrue(element.checkElement(JobSearchResultsPage.containerEmptySearch), "We got results.");
    Assert.assertFalse(element.checkElement(JobSearchResultsPage.labelResultNumber), "We got results.");
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchSoftwareTest()
    throws Exception {

    element = new Elements(driver);

    String search = "software";

    element.sendKeys(JobSearchHomePage.inputSearch, search);

    //Assert.assertTrue(element.checkElement(JobSearchHomePage.selectSearch), ErrorText.ELEMENT.getText());

    WebElement[] results = element.getElement(JobSearchHomePage.selectSearch)
        .findElements(JobSearchHomePage.selectSearchList).toArray(new WebElement[0]);

    Assert.assertTrue(element.checkElement(results, 0));

    for (WebElement result : results) {

      if (result.getText().toLowerCase().contains("software Development")) {

        System.out.println("Contains Software Development");
        Assert.assertTrue(true);
        break;
      }
    }
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
