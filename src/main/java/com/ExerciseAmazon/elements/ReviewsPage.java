package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class ReviewsPage {

  public static By inputSearch = By.id("filterByKeywordTextBox");

  public static By butSearch = By.id("a-autoid-3");

  public static By butFilterStars = By.cssSelector(
      "#cm_cr-view_opt_sort_filter > div.a-section.a-spacing-mini.reviews-filter-by-options.aok-float-left > div.a-row."
      + "reviews-filter-by-dropdown > a.a-link-normal.star-rating-select > span > span");

  public static By listFilterStars = By.cssSelector("#a-popover-1 > div > div > ul > li");

  public static By listFilterStars1Star = By.cssSelector("#a-popover-1 > div > div > ul > li:nth-child(6)");

  public static By labelResultNumber = By.cssSelector("#filter-info-section > span:nth-child(1)");

  public static By listResults = By.id("cm_cr-review_list");

  public static By listResultsItems = By.cssSelector("#cm_cr-review_list > div.a-section");

  //public static By listResultsItemsUser = By.cssSelector("div > div > div:nth-child(1)");

  public static By listResultsItemsUser = By.xpath("div/div/div[1]");

  public static By listResultsItemsDate = By.xpath("div/div/span");

  public static By butNext = By.cssSelector("#cm_cr-pagination_bar > ul > li.a-last");
}
