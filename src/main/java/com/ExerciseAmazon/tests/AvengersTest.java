package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
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

  @Test(enabled = false, invocationCount = 1)
  public void searchAvengersTest()
    throws Exception {

  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
