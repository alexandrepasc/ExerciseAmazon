package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class ReviewsPage {

  public static By inputSearch = By.id("filterByKeywordTextBox");

  public static By butSearch = By.id("a-autoid-3");

  public static By labelResultNumber = By.cssSelector("#filter-info-section > span");

  public static By listResults = By.id("cm_cr-review_list");

  public static By listResultsItems = By.cssSelector("#cm_cr-review_list > div.a-section");

  //public static By listResultsItemsUser = By.cssSelector("div > div > div:nth-child(1)");

  public static By listResultsItemsUser = By.xpath("div/div/div[1]");

  public static By butNext = By.cssSelector("#cm_cr-pagination_bar > ul > li.a-last");
}
