package com.ExerciseAmazon.elements;

import org.openqa.selenium.By;

public class LoginPage {

  public static By inputMail = By.id("ap_email");

  public static By inputPassword = By.id("ap_password");

  public static By butLogin = By.id("signInSubmit");

  public static By divLoginFeedback = By.id("auth-error-message-box");

  public static By divLoginFeedbackSms = By.cssSelector("#auth-error-message-box > div > div > ul > li > span");

  public static By butCreateAccount = By.id("createAccountSubmit");

  public static By labelAddMobileTitle = By.cssSelector("#auth-account-fixup-phone-form > div > h1");

  public static By butAddMobileNotnow = By.id("ap-account-fixup-phone-skip-link");
}
