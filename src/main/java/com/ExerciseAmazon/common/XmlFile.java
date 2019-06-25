package com.ExerciseAmazon.common;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlFile {

  public static Map<String, String> read(String path, String fileName)
    throws Exception {

    File xmlFile = new File(path + fileName.concat(".xml"));
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);
    doc.getDocumentElement().normalize();

    Map<String, String> data = new HashMap<String, String>();

    if (doc.hasChildNodes()) {

      for (int i = 0; i < doc.getChildNodes().getLength(); i++) {

        //        System.out.println(doc.getChildNodes().item(i).toString());
        Node tempNode_ = doc.getChildNodes().item(i);

        if (tempNode_.getNodeType() == Node.ELEMENT_NODE) {

          NodeList nList_ = tempNode_.getChildNodes();

          for (int x = 1; x < nList_.getLength(); x++) {
            if (nList_.item(x).getNodeType() == Node.ELEMENT_NODE) {

              System.out.println(nList_.item(x).getNodeName());
              System.out.println(nList_.item(x).getTextContent());

              data.put(nList_.item(x).getNodeName(), nList_.item(x).getTextContent());
            }
          }
        }
      }
    }

    return data;
  }
}
