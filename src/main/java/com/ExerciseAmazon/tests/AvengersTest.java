package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.ItemDetailsPage;
import com.ExerciseAmazon.elements.SearchResultPage;
import com.ExerciseAmazon.elements.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AvengersTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui", "userMail", "userPassword" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui, String user, String pwd)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());

    element = new Elements(driver);

    element.click(HomePage.butProfileMenu);

    Utils.doLogin(user, pwd, element);
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchAvengersTest()
    throws Exception {

    element = new Elements(driver);

    element.sendKeys(HomePage.inputSearch, "avengers");

    element.click(HomePage.butSearch);

    Assert.assertTrue(element.getText(SearchResultPage.labelResultNumber).contains("results"));

    while (!scrollAvengersResults()) {
      if (element.getElement(SearchResultPage.butNext).isEnabled()) {

        element.click(SearchResultPage.butNext);
      }
    }
  }

  private boolean scrollAvengersResults()
    throws Exception {

    driver.navigate().refresh();

    element = new Elements(driver);

    WebElement[] elements = element.getElements(SearchResultPage.listResults);

    for (WebElement elem : elements) {

      if (elem.getText().contains("Avengers Assemble")) {//"Avengers Assemble"

        elem.findElement(By.className("a-link-normal")).click();

        System.out.println("found");

        Assert.assertTrue(true);
        return true;
      }
    }

    return false;
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchDescriptionTest()
    throws Exception {

    driver.get("https://www.amazon.co.uk/Avengers-Assemble-Robert-Downey-Jr/dp/B00FYO5NWW/ref=sr_1_1?keywords=avengers&"
        + "qid=1561577859&s=gateway&sr=8-1");

    element = new Elements(driver);

    Assert.assertTrue(element.getText(ItemDetailsPage.labelVideoDescription).contains("S.H.I.E.L.D"),
        ErrorText.VALUE.getText());
  }

  @Test(enabled = true, invocationCount = 1)
  public void trailerTest()
    throws Exception {

    driver.get("https://www.amazon.co.uk/Avengers-Assemble-Robert-Downey-Jr/dp/B00FYO5NWW/ref=sr_1_1?keywords=avengers&"
        + "qid=1561577859&s=gateway&sr=8-1");

    element = new Elements(driver);

    element.click(ItemDetailsPage.butVideoWatchTrailer);

    Utils.waitingUntil(driver, VideoPage.containerVideo, 20, Utils.WaitUntil.VISIBILITY);
    Utils.waitingUntil(driver, VideoPage.butForward, 20, Utils.WaitUntil.CLICKABLE);

    Assert.assertTrue(element.checkElement(VideoPage.butForward));
    element.click(VideoPage.butForward);

    element.click(VideoPage.butPause);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
