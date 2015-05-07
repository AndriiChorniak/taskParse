package com.epam.chorniak;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.*;

public class FlowerDOMBuilder extends AbstractFlowerBuilder {
	
	
	public List<Flower> reader(){
        try
        {
            File xmlFile = new File("flowers.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
 
            System.out.println("root element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
            System.out.println("--------------------");
            for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
            {
                Node node = nodeList.item(tmp);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                    String soil = element.getElementsByTagName("soil").item(0).getChildNodes().item(0).getNodeValue();
                    String origin = element.getElementsByTagName("origin").item(0).getChildNodes().item(0).getNodeValue();
                    String colorofthestalk = element.getElementsByTagName("colorofthestalk").item(0).getChildNodes().item(0).getNodeValue();
                    String colorofleaves = element.getElementsByTagName("colorofleaves").item(0).getChildNodes().item(0).getNodeValue();
                    int averagesize = Integer.parseInt(element.getElementsByTagName("averagesize").item(0).getChildNodes().item(0).getNodeValue());
                    int temperature = Integer.parseInt(element.getElementsByTagName("temperature").item(0).getChildNodes().item(0).getNodeValue());
                    String photophilous = element.getElementsByTagName("photophilous").item(0).getChildNodes().item(0).getNodeValue();
                    int wateringaweek = Integer.parseInt(element.getElementsByTagName("wateringaweek").item(0).getChildNodes().item(0).getNodeValue());
                    String multiplying = element.getElementsByTagName("multiplying").item(0).getChildNodes().item(0).getNodeValue();
                    
                  
                    list.add(new Flower(name, soil, origin, colorofthestalk, colorofleaves, averagesize, temperature, photophilous, wateringaweek, multiplying));
                    
                   
                    
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return list;

	}

}
