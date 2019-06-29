package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class JobSearchResultsPage {

  public static By labelResultNumber = By.cssSelector("#main-content > div.search-page > div > div > div.container "
      + "> content > div > div > div.col-md-8.search-page-job-list > div:nth-child(1) > div.col-sm-6.job-count-info");

  public static By containerRadius = By.cssSelector("#main-content > div.search-page > div > div > div.container > "
      + "content > div > div > div.d-none.d-md-block.col-sm-4.search-page-filter > div > div:nth-child(6) > div");

  public static By butRadius5Mi = By.cssSelector("#main-content > div.search-page > div > div > div.container > "
      + "content > div > div > div.d-none.d-md-block.col-sm-4.search-page-filter > div > div:nth-child(6) > div > "
      + "fieldset > div.buttons-group > button:nth-child(1)");

  public static By containerResults = By.cssSelector("#main-content > div.search-page > div > div > div.container > "
      + "content > div > div > div.col-md-8.search-page-job-list");

  public static By containerEmptySearch = By.cssSelector("#search-empty");
}
