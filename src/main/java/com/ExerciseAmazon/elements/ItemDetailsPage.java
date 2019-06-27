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

  public static By butVideoWatchTrailer = By.cssSelector("#dv-action-box > div > div > div > div._1y_Ulh.Ri9l84._2WW1HP"
      + ">div > span > a");

  public static By labelVideoDescription = By.cssSelector("#a-page > div.avu-content.avu-section > div > div > div."
      + "DVWebNode-detail-atf-wrapper.DVWebNode > div.av-detail-section > div > div.avu-full-width.dv-dp-node-synopsis "
      + "> p");
}
