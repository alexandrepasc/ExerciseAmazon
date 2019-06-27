package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SearchJobTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui", "userMail", "userPassword" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui, String user, String pwd)
      throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
      throws Exception {

    afterTest();
  }
}
