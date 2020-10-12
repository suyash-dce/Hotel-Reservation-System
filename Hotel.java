package com.capgemini.hotelreservation;

public class Hotel {
	private String name;
	private int weekdayRateRegular, weekendRateRegular, weekdayRateReward, weekendRateReward, ratings;

	public Hotel() {
	}

	// Parameterized Constructor
	public Hotel(String name, int weekdayRateRegular, int weekendRateRegular, int weekdayRateReward,
			int weekendRateReward, int ratings) {
		super();
		this.name = name;
		this.weekdayRateRegular = weekdayRateRegular;
		this.weekendRateRegular = weekendRateRegular;
		this.weekdayRateReward = weekdayRateReward;
		this.weekendRateReward = weekendRateReward;
		this.ratings = ratings;
	}

	// Name Getter
	public String getName() {
		return name;
	}

	// Name Setter
	public void setName(String name) {
		this.name = name;
	}

	// Getter for Weekday Regular Customer Rates
	public int getWeekdayRateRegular() {
		return weekdayRateRegular;
	}

	// Setter for Weekday Regular Customer Rates
	public void setWeekdayRateRegular(int weekdayRateRegular) {
		this.weekdayRateRegular = weekdayRateRegular;
	}

	// Getter for Weekend Regular Customer Rates
	public int getWeekendRateRegular() {
		return weekendRateRegular;
	}

	// Setter for Weekend Regular Customer Rates
	public void setWeekendRateRegular(int weekendRateRegular) {
		this.weekendRateRegular = weekendRateRegular;
	}

	// Getter for Weekday Reward Customer Rates
	public int getWeekdayRateReward() {
		return weekdayRateReward;
	}

	// Setter for Weekday Reward Customer Rates
	public void setWeekdayRateReward(int weekdayRateReward) {
		this.weekdayRateReward = weekdayRateReward;
	}

	// Getter for Weekend Reward Customer Rates
	public int getWeekendRateReward() {
		return weekendRateReward;
	}

	// Setter for Weekend Reward Customer Rates
	public void setWeekendRateReward(int weekendRateReward) {
		this.weekendRateReward = weekendRateReward;
	}

	// Getter for Ratings
	public int getRatings() {
		return ratings;
	}

	// Setter for Ratings
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
}
