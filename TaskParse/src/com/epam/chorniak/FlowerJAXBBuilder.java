package com.epam.chorniak;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
 

import java.util.List;

public class FlowerJAXBBuilder extends AbstractFlowerBuilder {
	

	public List<Flower> reader() {
		
		try
        {
            File file = new File("flowers.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Flower.class);
 
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Flower f = (Flower)jaxbUnmarshaller.unmarshal(file);
 
            System.out.println("name: " + f.getName() +
                    "(soil=" + f.getSoil() +
                    "'origin,='" + f.getOrigin() +
                    "'colorofthestalk,='" + f.getColorOfTheStalk() +
                    "'colorofleaves,='" + f.getColorOfLeaves() +
                    "'averagesize,='" + f.getSize() +
                    "'temperature,='" + f.getTemperature() +
                    "'photophilous,='" + f.getPhotophilous() +
                    "'wateringaweek,='" + f.getWatering() +
                    "'multiplying,='" + f.getMultiplying() +
                    
                    "')");
           // list.add(f);
        }
        catch (JAXBException jaxbe)
        {
            System.out.println(jaxbe.getLocalizedMessage());
            jaxbe.printStackTrace();
        }

		
		return list; 

	}

}
