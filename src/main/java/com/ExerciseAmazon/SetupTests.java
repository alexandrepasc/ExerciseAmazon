package com.ExerciseAmazon;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TODO Need to check if it could work
public class SetupTests {

  public static void getTests() {

    Class[] classes = getClasses();

    for (int i = 0; i < classes.length; i++) {
      System.out.println();
    }
  }

  private static Class[] getClasses() {

    String pckgname = "com.ExerciseAmazon.common";

    File directory = getPackageDirectory(pckgname);

    if (!directory.exists()) {
      throw new IllegalArgumentException("Could not get directory resource for package.");
    }

    return getClassesInPackage(pckgname, directory);
  }

  private static File getPackageDirectory(String pckgname) {
    ClassLoader cld = Thread.currentThread().getContextClassLoader();
    if (cld == null) {
      throw new IllegalStateException("Can't get class loader.");
    }

    URL resource = cld.getResource(pckgname.replace('.', '/'));
    if (resource == null) {
      throw new RuntimeException("Package " + pckgname + " not found on classpath.");
    }

    return new File(resource.getFile());
  }

  private static Class[] getClassesInPackage(String pckgname, File directory) {
    List<Class> classes = new ArrayList<>();
    for (String filename : directory.list()) {
      if (filename.endsWith(".class")) {
        String classname = buildClassname(pckgname, filename);
        try {
          classes.add(Class.forName(classname));
        } catch (ClassNotFoundException e) {
          System.err.println("Error creating class " + classname);
        }
      }
    }
    return classes.toArray(new Class[classes.size()]);
  }

  private static String buildClassname(String pckgname, String filename) {
    return pckgname + '.' + filename.replace(".class", "");
  }
}
