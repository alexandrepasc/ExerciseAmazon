package com.ExerciseAmazon.common;

import org.testng.ISuite;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO Need to check if it could work
public class TestSuite {

  private String suiteName;

  private String[] className;

  private String classTestName;

  private Map<String, String> testPack;

  private XmlSuite suite;

  private List<XmlSuite> suites;

  private Settings settings;

  public TestSuite(Settings settings) {

    this.suite = new XmlSuite();

    this.settings = settings;
  }

  public void setSuites() {

    suites.add(suite);
  }

  public void setSuite() {

    suite.setName(getSuiteName());

    List<XmlClass> overviewClasses = new ArrayList<>();
    XmlTest overviewTest;

    Map<String, String> options = new HashMap<>();
    options.put("browser", "firefox");
    options.put("gui", "no");

    suite.setParameters(options);

    for (Map.Entry<String, String> entry : getTestPack().entrySet()) {

      overviewTest = new XmlTest(suite);
      overviewTest.setName(entry.getKey());

      overviewClasses = new ArrayList<>();
      overviewClasses.add(new XmlClass("com.ExerciseAmazon.tests.".concat(entry.getValue())));

      overviewTest.setXmlClasses(overviewClasses);
    }
  }

  public void runTests() {

    TestNG testNG = new TestNG();
    testNG.setXmlSuites(suites);
    testNG.setVerbose(2);
    List<ISuite> iSuits = testNG.runSuitesLocally();
  }

  public String getSuiteName() {
    return suiteName;
  }

  public void setSuiteName(String suiteName) {
    this.suiteName = suiteName;
  }

  public Map<String, String> getTestPack() {
    return testPack;
  }

  public void setTestPack(Map<String, String> testPack) {
    this.testPack = testPack;
  }
}
