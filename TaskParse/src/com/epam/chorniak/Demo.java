package com.epam.chorniak;

public class Demo {

	public static void main(String[] args) {
		String parser = "DOM";
		AbstractFlowerBuilder abs;
		FlowerBuilderFactory fbuilder = new FlowerBuilderFactory();
		abs = fbuilder.createFlowerBuilder(parser);
		//System.out.println(abs.reader());
		JSONReader j = new JSONReader();
		//j.read();
		//System.out.println(j.list);
		
		
		j.write();

	}

}
