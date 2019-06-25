package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class HomePage {

  public static By tagHtml = By.tagName("html");

  public static By butProfileMenu = By.id("nav-link-accountList");

  public static By labelProfileMenuName = By.cssSelector("#nav-link-accountList > span.nav-line-1");
}
