package com.ExerciseAmazon.common;

public enum Browsers {
  FIREFOX("firefox"),
  CHROME("chrome");

  public final String text;

  Browsers(String text) {

    this.text = text;
  }

  public final String getText() {
    return text;
  }
}
