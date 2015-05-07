package com.epam.chorniak;

import org.jdom2.*;
import org.jdom2.output.*;
import org.jdom2.input.*;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FlowerJDOMBuilder extends AbstractFlowerBuilder {
	org.jdom2.Document jdomDoc;
	final String fileName = "flowers.xml";
	public List<Flower> reader() {
		
		try {
            //we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
            jdomDoc = useDOMParser(fileName);
            Element root = jdomDoc.getRootElement();
            List<Element> empListElements = root.getChildren("flower");
            
            for (Element empElement : empListElements) {
            	String name = empElement.getChildText("name");
                String soil = empElement.getChildText("soil");
                String origin = empElement.getChildText("origin");
                String colorofthestalk = empElement.getChildText("colorofthestalk");
                String colorofleaves = empElement.getChildText("colorofleaves");
                int averagesize = Integer.parseInt(empElement.getChildText("averagesize"));
                int temperature = Integer.parseInt(empElement.getChildText("temperature"));
                String photophilous = empElement.getChildText("photophilous");
                int wateringaweek = Integer.parseInt(empElement.getChildText("wateringaweek"));
                String multiplying = empElement.getChildText("multiplying");
            	
                Flower emp = new Flower(name, soil, origin, colorofthestalk, colorofleaves, averagesize, temperature, photophilous, wateringaweek, multiplying);
                
                list.add(emp);
            }
            //lets print Employees list information
            
        } catch (Exception e) {
            e.printStackTrace();
        }

		return list;

	}
	private static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //creating DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Node doc =  dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build((org.w3c.dom.Document) doc);
 
    }

}
