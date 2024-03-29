package com.ExerciseAmazon;

import com.ExerciseAmazon.common.Settings;
import com.ExerciseAmazon.common.TestSuite;
import com.ExerciseAmazon.common.XmlFile;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static Settings settings;

  public static void main(String[] args)
    throws Exception {

    settings = new Settings();

    settings = setConfig(args, settings);

    Map<String, String> options = new HashMap<>();
    options.put("browser", settings.getBrowser());
    options.put("gui", settings.getGui());
    options.put("userMail", settings.getUser());
    options.put("userPassword", settings.getPassword());

    XmlTest overviewTest;
    List<XmlClass> overviewClasses;

    XmlSuite suiteAuth = new XmlSuite();
    suiteAuth.setName("Authentication");
    suiteAuth.setParameters(options);
    overviewTest = new XmlTest(suiteAuth);
    overviewTest.setName("AuthSuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.AuthTest"));
    overviewTest.setXmlClasses(overviewClasses);

    XmlSuite suiteSearch = new XmlSuite();
    suiteSearch.setName("Search");
    suiteSearch.setParameters(options);
    overviewTest = new XmlTest(suiteSearch);
    overviewTest.setName("SearchSuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.SearchTest"));
    overviewTest.setXmlClasses(overviewClasses);

    XmlSuite suiteComments = new XmlSuite();
    suiteComments.setName("Comments");
    suiteComments.setParameters(options);
    overviewTest = new XmlTest(suiteComments);
    overviewTest.setName("CommentsSuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.CommentsTest"));
    overviewTest.setXmlClasses(overviewClasses);

    XmlSuite suiteAvengers = new XmlSuite();
    suiteAvengers.setName("Avengers");
    suiteAvengers.setParameters(options);
    overviewTest = new XmlTest(suiteAvengers);
    overviewTest.setName("AvengersSuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.AvengersTest"));
    overviewTest.setXmlClasses(overviewClasses);

    XmlSuite suiteShopBy = new XmlSuite();
    suiteShopBy.setName("ShopBy");
    suiteShopBy.setParameters(options);
    overviewTest = new XmlTest(suiteShopBy);
    overviewTest.setName("ShopBySuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.ShopDepartTest"));
    overviewTest.setXmlClasses(overviewClasses);

    XmlSuite suiteSearchJob = new XmlSuite();
    suiteSearchJob.setName("SearchJob");
    suiteSearchJob.setParameters(options);
    overviewTest = new XmlTest(suiteSearchJob);
    overviewTest.setName("SearchJobSuite");
    overviewClasses = new ArrayList<>();
    overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.SearchJobTest"));
    overviewTest.setXmlClasses(overviewClasses);

    List<XmlSuite> suites = new ArrayList<>();
    suites.add(suiteAuth);
    suites.add(suiteSearch);
    suites.add(suiteComments);
    suites.add(suiteAvengers);
    suites.add(suiteShopBy);
    suites.add(suiteSearchJob);

    TestNG testNG = new TestNG();
    testNG.setXmlSuites(suites);
    testNG.setVerbose(2);
    testNG.runSuitesLocally();

    //runTests();
  }

  private static void runTests() {

    TestSuite testSuite = new TestSuite(settings);

    testSuite.setSuiteName("Auth");

    Map<String, String> tests = new HashMap<>();
    tests.put("AuthTest", "AuthTest");
    testSuite.setTestPack(tests);

    testSuite.setSuite();

    testSuite.setSuites();

    testSuite.runTests();
  }

  private static Settings setConfig(String[] args, Settings settings) {

    try {

      if (args != null) {

        settings = getArgs(args, settings);
      } else {

        System.out.println("No arguments");
      }

      settings.setAppPath(getAppPath());

      settings = readSetting(settings);

      return settings;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return settings;
  }

  private static Settings getArgs(String[] args, Settings settings) {

    settings.setBrowser("firefox");
    settings.setGui("no");

    for (int i = 0; i < args.length; i++) {
      if ((args[i].toLowerCase().equals("firefox")) || (args[i].toLowerCase().equals("chrome"))) {

        settings.setBrowser(setBrowser(args[i].toLowerCase()));
      } else if ((args[i].toLowerCase().equals("yes")) || args[i].toLowerCase().equals("no")) {

        //System.out.println(args[i]);
        settings.setGui(setGui(args[i].toLowerCase()));
      }
    }

    return settings;
  }

  private static String setBrowser(String arg) {

    if (arg.equals("firefox")) {

      //browser = Browsers.FIREFOX;
      return "firefox";
    } else if (arg.equals("chrome")) {

      //browser = Browsers.CHROME;
      return "chrome";
    } else {

      //browser = Browsers.FIREFOX;
      return "firefox";
    }

    //return browser;
  }

  private static String setGui(String arg) {

    if (arg.equals("yes")) {

      return arg;
    } else if (arg.equals("no")) {

      return arg;
    } else {

      return "no";
    }
  }

  private static String getAppPath()
    throws Exception {

    String path = URLDecoder
        .decode(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(), "UTF-8");

    path = path.substring(1, path.lastIndexOf("/") + 1);

    if (path.contains("/classes/")) {
      path = path.substring(0, path.lastIndexOf("/ta"));
    }

    if (!Character.toString(path.charAt(path.length() - 1)).equals("/")) {
      path = path.concat("/");
    }

    return path;
  }

  private static Settings readSetting(Settings settings)
    throws Exception {

    Map<String, String> data = XmlFile.read(settings.getAppPath(), "setting");

    settings.setUser(data.get("email"));
    settings.setPassword(data.get("pwd"));

    return settings;
  }
}
