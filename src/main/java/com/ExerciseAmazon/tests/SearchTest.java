package com.ExerciseAmazon.tests;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.common.ErrorText;
import com.ExerciseAmazon.common.PreTest;
import com.ExerciseAmazon.common.Utils;
import com.ExerciseAmazon.elements.HomePage;
import com.ExerciseAmazon.elements.ItemDetailsPage;
import com.ExerciseAmazon.elements.ReviewsPage;
import com.ExerciseAmazon.elements.SearchResultPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends PreTest {

  private Elements element;

  @Parameters({ "browser", "gui" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, String gui)
    throws Exception {

    beforeTest(browser, gui);

    driver.get(Utils.getHomeUkUrl());
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchBookTest()
    throws Exception {

    element = new Elements(driver);

    element.click(HomePage.selectSearchIn);
    element.click(HomePage.selectSearchInBooks);

    element.sendKeys(HomePage.inputSearch, "chasing Excellence");

    element.click(HomePage.butSearch);

    Assert.assertTrue(element.getText(SearchResultPage.labelResultNumber).contains("results"));

    //TODO Check this later
    WebElement[] elements = element.getElements(SearchResultPage.listResults);
    for (int i = 0; i < elements.length; i++) {

      if (elements[i].getText().contains("Bergeron")) {

        elements[i].findElement(SearchResultPage.listResultsImage).click();

        break;
      }
    }

    Assert.assertTrue(element.checkElement(ItemDetailsPage.labelTitle));

    Utils.scrollToElement(driver, element.getElement(ItemDetailsPage.butAllReviews));

    if (element.checkElement(ItemDetailsPage.popupKindle)) {

      element.click(ItemDetailsPage.butPopupKindleClose);
    }
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchReviewsTest()
    throws Exception {

    driver.get(
        "https://www.amazon.co.uk/Chasing-Excellence-Building-Fittest-Athletes/product-reviews/1619617277/ref=cm_cr_getr_d_paging_btm_prev_1?ie=UTF8&reviewerType=all_reviews&pageNumber=1");

    element = new Elements(driver);

    while (!searchReviews()) {

      if (element.getElement(ReviewsPage.butNext).isEnabled()) {

        element.click(ReviewsPage.butNext);
      }
    }
  }

  private boolean searchReviews()
    throws Exception {

    driver.navigate().refresh();

    element = new Elements(driver);

    WebElement[] elements;

    elements = element.getElements(driver, ReviewsPage.listResultsItems);

    String aux;
    for (WebElement elem : elements) {
      //System.out.println(elem.getText());
      aux = elem.findElement(ReviewsPage.listResultsItemsUser).getText();
      if (aux.contains("Cerith Leighton Watkins")) {
        System.out.println("found");
        Assert.assertTrue(true);
        return true;
      }
    }
    //System.out.println("page");

    return false;
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchReviewFor1Star()
    throws Exception {

    driver.get("https://www.amazon.co.uk/Chasing-Excellence-Building-Fittest-Athletes/product-reviews/1619617277/ref=cm"
        + "_cr_dp_d_show_all_btm?ie=UTF8&reviewerType=all_reviews");

    element = new Elements(driver);

    element.click(ReviewsPage.butFilterStars);
    element.click(ReviewsPage.listFilterStars1Star);

    Assert.assertTrue(element.getText(ReviewsPage.labelResultNumber).contains("reviews"), ErrorText.VALUE.getText());
  }

  @Test(enabled = true, invocationCount = 1)
  public void searchReviewForDate()
    throws Exception {

    driver.get("https://www.amazon.co.uk/Chasing-Excellence-Building-Fittest-Athletes/product-reviews/1619617277/ref=cm"
        + "_cr_dp_d_show_all_btm?ie=UTF8&reviewerType=all_reviews");

    element = new Elements(driver);

    while (!scrollReviewsPage()) {

      if (element.getElement(ReviewsPage.butNext).isEnabled()) {

        element.click(ReviewsPage.butNext);
      }
    }
  }

  private boolean scrollReviewsPage()
    throws Exception {

    driver.navigate().refresh();

    element = new Elements(driver);

    WebElement[] elements;

    elements = element.getElements(driver, ReviewsPage.listResultsItems);

    String aux;
    for (WebElement elem : elements) {

      aux = elem.findElement(ReviewsPage.listResultsItemsDate).getText();

      if (aux.contains("17 September 2017")) {

        System.out.println("found");

        Assert.assertTrue(true);
        return true;
      }
    }

    return false;
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod()
    throws Exception {

    afterTest();
  }
}
