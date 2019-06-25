package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui)
    throws Exception {

    beforeTest(browser, gui);
  }

  @Test(enabled = true, invocationCount = 1)
  public void createUserWrong()
    throws Exception {

    element = new Elements(driver);

    driver.get(Utils.getHomeUrl());

    //Assert.assertTrue(element.checkElement(HomePage.butProfileMenu), ErrorText.ELEMENT.getText());

    element.click(HomePage.butProfileMenu);

    element.click(LoginPage.butCreateAccount);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
