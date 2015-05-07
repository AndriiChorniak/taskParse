package com.epam.chorniak;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFlowerBuilder {
	protected  List<Flower> list = new ArrayList<Flower>();
	public abstract List<Flower> reader();

}
