package com.company;

import org.json.simple.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static void main(String[] args) {
	// write your code here
       // String[][] li = {{"head","valuetype-def", "valueset", "value-el"}, {"body", "track-spec", "attributes", "group", "set-spec"}};
        try {
            File inputFile = new File("mySpec.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance(); //Factory ==> method for creating object
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); //
            //System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            //System.out.println("Children" + doc.getDocumentElement().getFirstChild().getChildNodes());

            Element classElement = doc.getDocumentElement();

            System.out.println(classElement.getNodeName());

            NodeList headLi = doc.getElementsByTagName("head");

            Node n1 = headLi.item(0);
            Element e1 = (Element) n1;

            NodeList valTypeLi = e1.getElementsByTagName("value-el");

            for (Integer i=0; i< valTypeLi.getLength(); i++){
                Node n = valTypeLi.item(i);
                Element e = (Element) n;
                System.out.println(n.getTextContent()); // prints out text contained ==>  <> __text___</>
                System.out.println(e.getAttribute("color"));
            }
/*
            for (Integer i=0; i<li.getLength(); i++){
                Node n = li.item(i);
                System.out.println("Current element: " + n.getNodeName());
                if (n.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) n;
                    System.out.println("Element: "+e.getAttribute("name"));
                }
            }*/
/*
            System.out.println(li.item(6).getNodeName()); // track gesture phrase

            Element e = (Element) li.item(6);

            System.out.println(e.getAttribute("name"));
            NodeList li1 = e.getElementsByTagName("attribute");

            System.out.println(li1.getLength());

            for (Integer i=0; i<li1.getLength(); i++){
                Node n = li1.item(i);
                Element var = (Element) n;
                System.out.println(var.getAttribute("name"));
            }*/





        }
        catch(Exception e){
            e.printStackTrace();
        }

        NewClass nc = new NewClass();
        nc.printText();
    }
}

class NewClass {
    public static void main(String[] args){
    }

    public void printText(){
        System.out.println("Hello World");
    }
}