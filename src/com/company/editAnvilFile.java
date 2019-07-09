package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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


            // adding a new element
            NodeList trackLi = doc.getElementsByTagName("track");
           // System.out.println(trackLi.getLength());
            NodeList wordsLi = ((Element)trackLi.item(0)).getElementsByTagName("el");

            Element wordsEl = (Element) trackLi.item(0);

           /* Element el = doc.createElement("el");
            el.setAttribute("index", "1");
            el.setAttribute("start", "30");
            el.setAttribute("end", "45"); */

           //wordsEl.appendChild(el);





/*
            // changing the source of the video, initially using video from downloads file
            NodeList videoLi = doc.getElementsByTagName("video");
            Element video = (Element) videoLi.item(0);
            System.out.println(video.getAttribute("src"));
            video.setAttribute("src", "smallTP (1).avi");
            System.out.println(video.getAttribute("src"));


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
            System.out.println(wordsEl.getAttribute("start")); */

/*
            // Writes the information into a new file
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult("twoPeople.anvil");
            tf.transform(domSource, sr); */



        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}
