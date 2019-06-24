package com.ExerciseAmazon;

import com.ExerciseAmazon.common.Browsers;

import java.net.URLDecoder;

public class Main {

  static Browsers browser;
  static boolean gui;

  public static void main(String[] args)
    throws Exception {

    if (args != null) {

      getArgs(args);
    } else {
      System.out.println("No arguments");
    }

//    System.out.println(
//        URLDecoder.decode(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(), "UTF-8"));
  }

  private static void getArgs(String[] args) {

    for (int i = 0; i < args.length; i++) {
      if ((args[i].toLowerCase().equals("firefox")) || (args[i].toLowerCase().equals("chrome"))) {

        browser = setBrowser(args[i].toLowerCase());
        System.out.println(browser);
      } else if ((args[i].toLowerCase().equals("yes")) || args[i].toLowerCase().equals("no")) {

        gui = setGui(args[i].toLowerCase());
        System.out.println(gui);
      }
    }
  }

  private static Browsers setBrowser(String arg) {

    Browsers browser;

    if (arg.equals(Browsers.FIREFOX.text)) {

      //browser = Browsers.FIREFOX;
      return Browsers.FIREFOX;
    } else if (arg.equals(Browsers.CHROME.text)) {

      //browser = Browsers.CHROME;
      return Browsers.CHROME;
    } else {

      //browser = Browsers.FIREFOX;
      return Browsers.FIREFOX;
    }

    //return browser;
  }

  private static boolean setGui(String arg) {

    boolean gui;

    if (arg.equals("yes")) {

      return true;
    } else if (arg.equals("no")) {

      return false;
    } else {

      return false;
    }
  }
}
