package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class SearchResultPage {

  public static By labelResultNumber = By.cssSelector(
      "#search > span > h1 > div > div.sg-col-14-of-20.sg-col-26-of-32.sg-col-18-of-24.sg-col.sg-col-22-of-28.s-breadcrumb.sg-col-10-of-16.sg-col-30-of-36.sg-col-6-of-12 > div > div > span:nth-child(1)");

  public static By listResults = By.cssSelector(
      "#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-result-list.s-search-results.sg-row > div");

  public static By listResultsItemWriter = By.cssSelector(
      "div:nth-child(1) > div > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > div > a");

  public static By butNext = By.cssSelector("#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20"
      + ".sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > "
      + "span:nth-child(9) > div > div > div > ul > li.a-last");
}
