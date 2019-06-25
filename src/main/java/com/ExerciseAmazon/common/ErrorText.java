package com.ExerciseAmazon.common;

public enum ErrorText {

  PAGE("Not correct page"),
  ELEMENT("Element NOT present or visible"),
  VALUE("Not the same value"),
  WRONG("Something went WRONG"),
  SELECTED("Element NOT selected");

  private String text;

  public String getText() {
    return this.text;
  }

  ErrorText(String text) {
    this.text = text;
  }
}
