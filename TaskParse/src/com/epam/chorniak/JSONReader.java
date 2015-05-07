package com.epam.chorniak;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	List<Flower> list = new ArrayList<Flower>();
	Flower f;

	public void read() {
		try {

			FileReader reader = new FileReader("flowers.json");

			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			// get a String from the JSON object

			JSONArray lang = (JSONArray) jsonObject.get("flower");
			// take the elements of the json array

			for (int i = 0; i < lang.size(); i++) {
				JSONObject innerObj = (JSONObject) lang.get(i);
				System.out.println(innerObj);
				f = new Flower();
				String name = (String) innerObj.get("name");
				f.setName(name);
				String soil = (String) innerObj.get("soil");
				f.setSoil(soil);
				String origin = (String) innerObj.get("origin");
				f.setOrigin(origin);
				String colorofthestalk = (String) innerObj
						.get("colorofthestalk");
				f.setColorOfTheStalk(colorofthestalk);
				String colorofleaves = (String) innerObj.get("colorofleaves");
				f.setColorOfLeaves(colorofleaves);
				int averagesize = Integer.parseInt((String) innerObj
						.get("averagesize"));
				f.setSize(averagesize);
				int temperature = Integer.parseInt((String) innerObj
						.get("temperature"));
				f.setTemperature(temperature);
				String photophilous = (String) innerObj.get("photophilous");
				f.setPhotophilous(photophilous);
				int wateringaweek = Integer.parseInt((String) innerObj
						.get("wateringaweek"));
				f.setWatering(wateringaweek);
				String multiplying = (String) innerObj.get("multiplying");
				f.setMultiplying(multiplying);

				list.add(f);

			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		} catch (ParseException ex3) {
			ex3.printStackTrace();
		} catch (NullPointerException ex4) {
			ex4.printStackTrace();
		}

	}

	public void write() {
		JSONObject elem1 = new JSONObject();
		JSONObject elem2 = new JSONObject();
		JSONObject elem3 = new JSONObject();
		JSONArray flowers = new JSONArray();
		flowers.add(elem1);
		flowers.add(elem2);
		flowers.add(elem3);
		
		elem1.put("name", "lotos");
		elem1.put("soil", "podzolic");
		elem1.put("origin", "Australia");
		elem1.put("colorofthestalk", "green");
		elem1.put("colorofleaves", "white");
		elem1.put("averagesize", "40");
		elem1.put("temperature", "37");
		elem1.put("photophilous", "yes");
		elem1.put("wateringaweek", "3000");
		elem1.put("multiplying", "seed");
		
		elem2.put("name", "Tulpan");
		elem2.put("soil", "ground");
		elem2.put("origin", "Netherlands");
		elem2.put("colorofthestalk", "green");
		elem2.put("colorofleaves", "red");
		elem2.put("averagesize", "45");
		elem2.put("temperature", "31");
		elem2.put("photophilous", "yes");
		elem2.put("wateringaweek", "3200");
		elem2.put("multiplying", "leaves");
		
		elem3.put("name", "Ficus");
		elem3.put("soil", "sod-podzolic");
		elem3.put("origin", "India");
		elem3.put("colorofthestalk", "brown");
		elem3.put("colorofleaves", "green");
		elem3.put("averagesize", "30");
		elem3.put("temperature", "30");
		elem3.put("photophilous", "no");
		elem3.put("wateringaweek", "2100");
		elem3.put("multiplying", "cuttings");
		
		JSONObject elem = new JSONObject();
		elem.put("flower", flowers);
		
		try(FileWriter file =  new FileWriter("flowersWriter.json")) {
			file.write(elem.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + elem);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}