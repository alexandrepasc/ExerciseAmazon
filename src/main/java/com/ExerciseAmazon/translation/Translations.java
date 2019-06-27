package com.ExerciseAmazon.translation;

import com.ExerciseAmazon.common.Elements;
import com.ExerciseAmazon.elements.HomePage;

public class Translations {

  private static Languages getLanguage(Elements element)
    throws Exception {

    String language = element.getAttribute(HomePage.tagHtml, "lang");

    switch (language) {
      case "pt-pt":
        return Languages.PT;
      case "en-gb":
        return Languages.EN;
      default:
        return Languages.EN;
    }
  }

  public static String labelRegisterMailExistsFeedback(Elements element)
    throws Exception {

    switch (getLanguage(element)) {
      case PT:
        return "";
      case EN:
        return "E-mail address already in use";
      default:
        return null;
    }
  }

  public static String divLoginFeedback(Elements element)
    throws Exception {

    switch (getLanguage(element)) {
      case PT:
        return "";
      case EN:
        return "Your password is incorrect";
      default:
        return null;
    }
  }

  public static String selectSearchInFitness(Elements element)
    throws Exception {

    switch (getLanguage(element)) {
      case PT:
        return "";
      case EN:
        return "Fitness";
      default:
        return null;
    }
  }

  public static String labelFeatureBrandTopBrandTitle(Elements element)
    throws Exception {

    switch (getLanguage(element)) {
      case PT:
        return "";
      case EN:
        return "Top Brands";
      default:
        return null;
    }
  }

  public static String labelFeatureBrandATitle(Elements element)
      throws Exception {

    switch (getLanguage(element)) {
      case PT:
        return "";
      case EN:
        return "A";
      default:
        return null;
    }
  }
}
