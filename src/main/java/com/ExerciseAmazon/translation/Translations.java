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
}
