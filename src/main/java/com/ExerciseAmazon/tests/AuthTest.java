package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.LoginPage;
import com.ExerciseAmazon.elements.RegisterPage;
import com.ExerciseAmazon.translation.Translations;
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

    driver.get(Utils.getHomeUrl());

    element = new Elements(driver);

    element.click(HomePage.butProfileMenu);
  }

  @Parameters({ "userMail", "userPassword" })
  @Test(enabled = true, invocationCount = 1)
  public void createUserWithExistingCredentialsTest(String user, String pwd)
    throws Exception {

    element = new Elements(driver);

    element.click(LoginPage.butCreateAccount);

    Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    element.sendKeys(RegisterPage.inputName, "Test Amazon");

    element.sendKeys(RegisterPage.inputMail, user);

    element.sendKeys(RegisterPage.inputPassword, pwd);

    element.sendKeys(RegisterPage.inputPasswordCheck, pwd);

    element.click(RegisterPage.butContinue);

    Assert.assertTrue(element.checkElement(RegisterPage.labelFeedback), ErrorText.ELEMENT.getText());

    Assert.assertEquals(element.getText(RegisterPage.labelFeedback),
        Translations.labelRegisterMailExistsFeedback(element), ErrorText.VALUE.getText());
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
