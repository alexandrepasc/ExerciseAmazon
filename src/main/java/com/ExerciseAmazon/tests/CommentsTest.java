package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommentsTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());
  }

  @Test(enabled = true, invocationCount = 1)
  public void addCommentTest()
    throws Exception {

    driver.get(
        "https://www.amazon.co.uk/Chasing-Excellence-Building-Fittest-Athletes/dp/1619617277/ref=sr_1_1?keywords=chasing+Excellence&qid=1561493875&s=books&sr=1-1");

    element = new Elements(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
