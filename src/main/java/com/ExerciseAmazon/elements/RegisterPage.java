package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class RegisterPage {

  public static By inputName = By.id("ap_customer_name");

  public static By inputMail = By.id("ap_email");

  public static By inputPassword = By.id("ap_password");

  public static By inputPasswordCheck = By.id("ap_password_check");

  public static By butContinue = By.id("continue");

  public static By labelFeedback = By.cssSelector(
      "#authportal-main-section > div:nth-child(2) > div > div.a-section.a-spacing-large > div > div > h4");
}
