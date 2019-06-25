package com.ExerciseAmazon.common;

public class Settings {

  private String browser;

  //private boolean gui;
  private String gui;

  private String appPath;

  private String user;

  private String password;

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }

//  public boolean getGui() {
//    return gui;
//  }
//
//  public void setGui(boolean gui) {
//    this.gui = gui;
//  }

  public String getGui() {
    return gui;
  }

  public void setGui(String gui) {
    this.gui = gui;
  }

  public String getAppPath() {
    return appPath;
  }

  public void setAppPath(String appPath) {
    this.appPath = appPath;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
