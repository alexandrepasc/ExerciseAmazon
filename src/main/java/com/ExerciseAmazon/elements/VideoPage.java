package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class VideoPage {

  public static By containerVideo = By.cssSelector("#dv-web-player > div > div:nth-child(1) > div > div > "
      + "div:nth-child(2) > div > div");

  public static By butForward = By.cssSelector("#dv-web-player > div > div:nth-child(1) > div > div > div:nth-child(2) "
      + "> div > div > div.pausedOverlay > div > div.fastSeekForward.hide");
}
