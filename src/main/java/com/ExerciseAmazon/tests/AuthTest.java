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

    driver.get(Utils.getHomeUkUrl());

    element = new Elements(driver);

    element.click(HomePage.butProfileMenu);
  }

  @Parameters({ "userMail", "userPassword" })
  @Test(enabled = true, invocationCount = 1)
  public void createUserWithExistingCredentialsTest(String user, String pwd)
    throws Exception {

    element = new Elements(driver);

    element.click(LoginPage.butCreateAccount);

    Assert.assertTrue(driver.getCurrentUrl().contains("register"), ErrorText.PAGE.getText());

    element.sendKeys(RegisterPage.inputName, "Test Amazon");

    element.sendKeys(RegisterPage.inputMail, user);

    element.sendKeys(RegisterPage.inputPassword, "123123123");

    element.sendKeys(RegisterPage.inputPasswordCheck, "123123123");

    element.click(RegisterPage.butContinue);

    Assert.assertTrue(element.checkElement(RegisterPage.labelFeedback), ErrorText.ELEMENT.getText());

    Assert.assertEquals(element.getText(RegisterPage.labelFeedback),
        Translations.labelRegisterMailExistsFeedback(element), ErrorText.VALUE.getText());
  }

  @Parameters({ "userMail", "userPassword" })
  @Test(enabled = true, invocationCount = 1)
  public void loginWithWrongPassword(String user, String pwd)
    throws Exception {

    //0 driver.get(Utils.getHomeComUrl());

    //element.click(HomePage.butProfileMenu);

    element = new Elements(driver);

    Assert.assertTrue(driver.getCurrentUrl().contains("signin"), ErrorText.PAGE.getText());

    element.sendKeys(LoginPage.inputMail, user);
    element.sendKeys(LoginPage.inputPassword, "qwefghbnm");
    element.click(LoginPage.butLogin);

    Assert.assertTrue(element.checkElement(LoginPage.divLoginFeedback), ErrorText.ELEMENT.getText());

    Assert.assertEquals(element.getText(LoginPage.divLoginFeedbackSms), Translations.divLoginFeedback(element),
        ErrorText.VALUE.getText());
  }

  @Parameters({ "userMail", "userPassword" })
  @Test(enabled = true, invocationCount = 1)
  public void loginWithRightPassword(String user, String pwd)
    throws Exception {

    //driver.get(Utils.getHomeComUrl());

    //element.click(HomePage.butProfileMenu);

    element = new Elements(driver);

    Assert.assertTrue(driver.getCurrentUrl().contains("signin"), ErrorText.PAGE.getText());

    element.sendKeys(LoginPage.inputMail, user);
    element.sendKeys(LoginPage.inputPassword, pwd);
    element.click(LoginPage.butLogin);

    Assert.assertTrue(element.checkElement(HomePage.labelProfileMenuName), ErrorText.ELEMENT.getText());

    Assert.assertNotEquals(element.getText(HomePage.labelProfileMenuName), "Sign in", ErrorText.VALUE.getText());
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
