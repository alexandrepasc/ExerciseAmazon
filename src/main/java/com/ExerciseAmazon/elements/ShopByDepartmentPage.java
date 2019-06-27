package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class ShopByDepartmentPage {

  public static By butShopBySportsOut = By.cssSelector("#shopAllLinks > tbody > tr > td:nth-child(4) > div:nth-child(5)"
      + "> ul > li:nth-child(6) > a");

  public static By butFeatureBrandSeeMore = By.cssSelector("#leftNav > ul:nth-child(17) > li > span");

  public static By labelFeatureBrandTitle = By.cssSelector("#center > div:nth-child(1) > span.a-color-state");

  public static By butFeatureBrandA = By
      .cssSelector("#indexBarHeader > div > div > span:nth-child(4) > a:nth-child(1)");

  public static By containerFeatureBrand = By.id("refinementList");

  public static By columnsFeatureBrand = By.cssSelector("#ref_1632651031 > ul");

  public static By itemsFeatureBrand = By.cssSelector("li");
}
