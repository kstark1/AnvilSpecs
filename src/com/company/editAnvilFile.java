package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class editAnvilFile {
    public static void main(String[] args){
        try {
            File inputFile = new File("twoPeople.anvil");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); // removes empty text nodes and joins adjacent nodes


            NodeList trackLi = doc.getElementsByTagName("track");

            System.out.println(trackLi.getLength());

            NodeList wordsLi = ((Element)trackLi.item(0)).getElementsByTagName("el");

            System.out.println(wordsLi.getLength());

            Element wordsEl = (Element) wordsLi.item(0);

            System.out.println(wordsEl.getAttribute("start"));

            // modify xml file ==> adds 2 seconds to the start and end times
            Float var = Float.parseFloat(wordsEl.getAttribute("start")) + 2;
            Float varEnd = Float.parseFloat(wordsEl.getAttribute("end")) + 2;

            wordsEl.setAttribute("start",var.toString());
            wordsEl.setAttribute("end", varEnd.toString());
            System.out.println(wordsEl.getAttribute("start"));

            // Writes the information into a new file
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult("twoPeople.anvil");
            tf.transform(domSource, sr);

/*
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);*/



        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}
