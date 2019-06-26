package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class ItemDetailsPage {

  public static By popupKindle = By.id("a-popover-2");

  public static By butPopupKindleClose = By.cssSelector("#a-popover-2 > div > header > button");

  public static By labelTitle = By.id("productTitle");

  public static By butAllReviews = By.cssSelector("#reviews-medley-footer > div.a-row.a-spacing-large > a");

  public static By labelAddReviewTitle = By
      .cssSelector("#reviewsMedley > div > div.a-fixed-left-grid-col.a-col-left > h3");

  public static By butAddReview = By.id("a-autoid-17");

  public static By butAddReview2 = By
      .cssSelector("#reviewsMedley > div > div.a-fixed-left-grid-col.a-col-left > div:nth-child(8)");
}
