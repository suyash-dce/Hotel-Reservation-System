package com.capgemini.hotelreservation;

public class Hotel {
	private String name;
	private int regularRates;
	private int weekendRate;
	public Hotel() {
	}
	
	//Parameterized Constructor
	public Hotel(String name, int regularRates, int weekedRate) {
		this.name = name;
		this.regularRates = regularRates;
		this.weekendRate = weekedRate;
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
	
	//Getter for Weekend Rates
	public int getWeekendRates() {
		return weekendRate;
	}
	
	//Setter for Weekend Rates
	public void setWeekendRates(int regularRates) {
		this.weekendRate = regularRates;
	}
}
