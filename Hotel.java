package com.capgemini.hotelreservation;

public class Hotel {
	private String name;
	private int regularRates;

	public Hotel() {
	}
	
	//Parameterized Constructor
	public Hotel(String name, int regularRates) {
		this.name = name;
		this.regularRates = regularRates;
	}
	
	//Name Getter
	public String getName() {
		return name;
	}
	
	//Name Setter
	public void setName(String name) {
		this.name = name;
	}
	
	//Getter for Regular Customer Rates
	public int getRegularRates() {
		return regularRates;
	}
	
	//Setter for Regular Customer Rates
	public void setRegularRates(int regularRates) {
		this.regularRates = regularRates;
	}

}
