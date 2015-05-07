package com.epam.chorniak;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FlowerSAXBuilder extends AbstractFlowerBuilder {
Flower f;
	public List<Flower> reader() {
		
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();

			DefaultHandler defaultHandler = new DefaultHandler() {
				boolean bflower = false;
				boolean bname = false;
				boolean bsoil = false;
				boolean borigin = false;
				boolean bcolorofthestalk = false;
				boolean bcolorofleaves = false;
				boolean baveragesize = false;
				boolean btemperature = false;
				boolean bphotophilous = false;
				boolean bwateringaweek = false;
				boolean bmultiplying = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					System.out.println("Start element: " + qName);
					if (qName.equalsIgnoreCase("flower")) {
						bflower = true;
					}
					if (qName.equalsIgnoreCase("name")) {
						bname = true;
						System.out.println("1");
					}
					if (qName.equalsIgnoreCase("soil")) {
						bsoil = true;
					}
					if (qName.equalsIgnoreCase("origin")) {
						borigin = true;
					}
					if (qName.equalsIgnoreCase("colorofthestalk")) {
						bcolorofthestalk = true;
					}
					if (qName.equalsIgnoreCase("colorofleaves")) {
						bcolorofleaves = true;
					}
					if (qName.equalsIgnoreCase("averagesize")) {
						baveragesize = true;
					}
					if (qName.equalsIgnoreCase("temperature")) {
						btemperature = true;
					}
					if (qName.equalsIgnoreCase("photophilous")) {
						bphotophilous = true;
					}
					if (qName.equalsIgnoreCase("wateringaweek")) {
						bwateringaweek = true;
					}
					if (qName.equalsIgnoreCase("multiplying")) {
						bmultiplying = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					System.out.println("End element: " + qName);
					
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if(bflower){
						f = new Flower();
						list.add(f);
						bflower = false;
						
					}
					
					if (bname) {
						f.setName(new String(ch, start, length));
						bname = false;
					}
					if (bsoil) {
						f.setSoil(new String(ch, start, length));
						bsoil = false;
					}
					if (borigin) {
						f.setOrigin(new String(ch, start, length));
						borigin = false;
					}
					if (bcolorofthestalk) {
						f.setColorOfTheStalk(new String(ch, start, length));
						bcolorofthestalk = false;
					}
					if (bcolorofleaves) {
						f.setColorOfLeaves(new String(ch, start, length));
						bcolorofleaves = false;
					}
					if (baveragesize) {
						f.setSize(Integer.parseInt(new String(ch, start, length)));
						baveragesize = false;
					}
					if (btemperature) {
						f.setTemperature(Integer.parseInt(new String(ch, start, length)));
						btemperature = false;
					}
					if (bphotophilous) {
						f.setPhotophilous(new String(ch, start, length));
						bphotophilous = false;
					}
					if (bwateringaweek) {
						f.setWatering(Integer.parseInt(new String(ch, start, length)));
						bwateringaweek = false;
					}
					if (bmultiplying) {
						f.setMultiplying(new String(ch, start, length));
						bmultiplying = false;
					}

					
				}
			};

			saxParser.parse("flowers.xml", defaultHandler);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return list;

	}

}
