package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class HomePage {

  public static By tagHtml = By.tagName("html");

  public static By butProfileMenu = By.id("nav-link-accountList");

  public static By labelProfileMenuName = By.cssSelector("#nav-link-accountList > span.nav-line-1");

  public static By inputSearch = By.id("twotabsearchtextbox");

  public static By butSearch = By.cssSelector("#nav-search > form > div.nav-right > div > input");

  public static By selectSearchIn = By.id("searchDropdownBox");

  public static By selectSearchInList = By.cssSelector("#searchDropdownBox > option");

  public static By selectSearchInBooks = By.cssSelector("#searchDropdownBox > option:nth-child(10)");
}
