package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class JobSearchHomePage {

  public static By inputSearch = By.cssSelector("#home-search > div > form > div.row.nopadding.location-search-bar > "
      + "div.col-12.col-md-8 > div > span > input");

  public static By selectSearch = By.cssSelector("#home-search > div > form > div.row.nopadding.location-search-bar > "
      + "div.col-12.col-md-8 > div > span > div > div");

  public static By selectSearchList = By.cssSelector("div");

  public static By inputLocation = By.cssSelector("#home-search > div > form > div.row.nopadding.location-search-bar "
      + "> div.col-12.col-md-4 > div > span > input");

  public static By selectLocation = By.cssSelector("#home-search > div > form > div.row.nopadding.location-search-bar "
      + "> div.col-12.col-md-4 > div > span > div > div");

  public static By selectLocationList = By.cssSelector("div > div");

  public static By selectLocationTitle1 = By.cssSelector("div:nth-child(2)");

  public static By selectLocationTitle2 = By.cssSelector("div:nth-child(3)");

  public static By butSearch = By.id("search-button");
}
