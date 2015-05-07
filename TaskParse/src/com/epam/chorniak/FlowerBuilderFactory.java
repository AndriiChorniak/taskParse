package com.epam.chorniak;

public class FlowerBuilderFactory {
	private enum TypeParser{
		SAX, JAXB, DOM, JDOM 
	}
	public AbstractFlowerBuilder createFlowerBuilder(String typeParser){
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case DOM:
		return new FlowerDOMBuilder();
		case JAXB:
		return new FlowerJAXBBuilder();
		case SAX:
		return new FlowerSAXBuilder();
		case JDOM:
			return new FlowerJDOMBuilder();
		default:
		throw new EnumConstantNotPresentException(
		type.getDeclaringClass(), type.name());
		}
		}


	}


