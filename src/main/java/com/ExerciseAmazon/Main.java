package com.ExerciseAmazon;

import com.ExerciseAmazon.common.Browsers;
import com.ExerciseAmazon.common.Settings;
import com.ExerciseAmazon.common.XmlFile;

import java.net.URLDecoder;
import java.util.Map;

public class Main {

  static Browsers browser;
  static boolean gui;
  public static Settings settings = new Settings();

  public static void main(String[] args)
    throws Exception {

    setConfig(args);
  }

  private static void setConfig(String[] args) {

    try {

      if (args != null) {

        getArgs(args);
      } else {

        System.out.println("No arguments");
      }

      settings.setAppPath(getAppPath());

      readSetting();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static void getArgs(String[] args) {

    for (int i = 0; i < args.length; i++) {
      if ((args[i].toLowerCase().equals("firefox")) || (args[i].toLowerCase().equals("chrome"))) {

        settings.setBrowser(setBrowser(args[i].toLowerCase()));
        System.out.println(settings.getBrowser());
      } else if ((args[i].toLowerCase().equals("yes")) || args[i].toLowerCase().equals("no")) {

        settings.setGui(setGui(args[i].toLowerCase()));
        System.out.println(settings.getGui());
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

  private static String getAppPath()
    throws Exception {

    String path = URLDecoder
        .decode(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(), "UTF-8");

    path = path.substring(1, path.lastIndexOf("/") + 1);
    System.out.println(path);

    return path;
  }

  private static void readSetting()
    throws Exception {

    Map<String, String> data = XmlFile.read(settings.getAppPath(), "setting");

    settings.setUser(data.get("email"));
    settings.setPassword(data.get("pwd"));
  }
}
