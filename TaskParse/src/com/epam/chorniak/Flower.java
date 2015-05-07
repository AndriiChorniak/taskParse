package com.epam.chorniak;

public class Flower {
	private String name;
	private String soil;
	private String origin;
	private String colorOfTheStalk;
	private String colorOfLeaves;
	private int size;
	private int temperature;
	private String photophilous;
	private int watering;
	private String multiplying;

	public Flower(String name, String soil, String origin,
			String colorOfTheStalk, String colorOfLeaves, int size,
			int temperature, String photophilous, int watering,
			String multiplying) {
		super();
		this.name = name;
		this.soil = soil;
		this.origin = origin;
		this.colorOfTheStalk = colorOfTheStalk;
		this.colorOfLeaves = colorOfLeaves;
		this.size = size;
		this.temperature = temperature;
		this.photophilous = photophilous;
		this.watering = watering;
		this.multiplying = multiplying;
	}
	public Flower(){}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSoil() {
		return soil;
	}
	public void setSoil(String soil) {
		this.soil = soil;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getColorOfTheStalk() {
		return colorOfTheStalk;
	}
	public void setColorOfTheStalk(String colorOfTheStalk) {
		this.colorOfTheStalk = colorOfTheStalk;
	}
	public String getColorOfLeaves() {
		return colorOfLeaves;
	}
	public void setColorOfLeaves(String colorOfLeaves) {
		this.colorOfLeaves = colorOfLeaves;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getPhotophilous() {
		return photophilous;
	}
	public void setPhotophilous(String photophilous) {
		this.photophilous = photophilous;
	}
	public int getWatering() {
		return watering;
	}
	public void setWatering(int watering) {
		this.watering = watering;
	}
	public String getMultiplying() {
		return multiplying;
	}
	public void setMultiplying(String multiplying) {
		this.multiplying = multiplying;
	}
	@Override
	public String toString() {
		return "Flower [name=" + name + ", soil=" + soil + ", origin=" + origin
				+ ", colorOfTheStalk=" + colorOfTheStalk + ", colorOfLeaves="
				+ colorOfLeaves + ", size=" + size + ", temperature="
				+ temperature + ", photophilous=" + photophilous
				+ ", watering=" + watering + ", multiplying=" + multiplying
				+ "]";
	}
	

}
