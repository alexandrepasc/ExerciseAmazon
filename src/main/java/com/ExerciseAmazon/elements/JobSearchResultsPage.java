package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class JobSearchResultsPage {

  public static By labelResultNumber = By.cssSelector("#main-content > div.search-page > div > div > div.container "
      + "> content > div > div > div.col-md-8.search-page-job-list > div:nth-child(1) > div.col-sm-6.job-count-info");
}
