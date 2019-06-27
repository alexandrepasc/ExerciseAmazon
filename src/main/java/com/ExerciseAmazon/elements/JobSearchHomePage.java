package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class JobSearchHomePage {

  public static By inputSearch = By.id("search_typeahead");

  public static By inputLocation = By.id("location-typeahead");

  public static By selectLocation = By.cssSelector("#home-search > div > form > div.row.nopadding.location-search-bar "
      + "> div.col-12.col-md-4 > div > span > div > div");

  public static By selectLocationList = By.cssSelector("div");

  public static By butSearch = By.id("search-button");
}
