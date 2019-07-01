package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.ItemDetailsPage;
import com.ExerciseAmazon.elements.LoginPage;

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

  //TODO My account doesnt have eligibility to post a comment
  @Parameters({ "userMail", "userPassword" })
  @Test(enabled = true, invocationCount = 1)
  public void addCommentTest(String user, String pwd)
    throws Exception {

    driver.get(
        "https://www.amazon.co.uk/Chasing-Excellence-Building-Fittest-Athletes/dp/1619617277/ref=sr_1_1?keywords=chasing+Excellence&qid=1561493875&s=books&sr=1-1");

    Thread.sleep(1000);
    element = new Elements(driver);

    Utils.waitingUntil(driver, ItemDetailsPage.butPopupKindleClose, 25, Utils.WaitUntil.CLICKABLE);
    element.click(ItemDetailsPage.butPopupKindleClose);

    Utils.scrollToElement(driver, element.getElement(ItemDetailsPage.labelAddReviewTitle));
    element.click(ItemDetailsPage.butAddReview2);

    //element.sendKeys(LoginPage.inputMail, user);
    for (int i = 0; i < user.length(); i++) {
      element.sendKeys(LoginPage.inputMail, Character.toString(user.charAt(i)));
      Thread.sleep(250);
    }
    //element.sendKeys(LoginPage.inputPassword, pwd);
    for (int i = 0; i < pwd.length(); i++) {
      element.sendKeys(LoginPage.inputPassword, Character.toString(pwd.charAt(i)));
    }
    element.click(LoginPage.butLogin);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
