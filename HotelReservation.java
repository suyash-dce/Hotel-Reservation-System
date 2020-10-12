package com.capgemini.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {

	private final static Hotel LAKEWOOD = new Hotel("Lakewood", 110);
	private final static Hotel BRIDGEWOOD = new Hotel("BridgeWood", 150);
	private final static Hotel RIDGEWOOD = new Hotel("Ridgewood", 220);

	static List<Hotel> hotelList = new ArrayList<>() {
		{
			add(LAKEWOOD);
			add(BRIDGEWOOD);
			add(RIDGEWOOD);
		}
	};

	public static void cheapestHotel(String start, String end) throws ParseException {
		long days, minRent;
		Date startDate = null, endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		sdf.setLenient(false);

		try {
			startDate = sdf.parse(start);
			endDate = sdf.parse(end);
		} catch (ParseException e) {
			System.err.println("Wrong Date format. Enter like 5 Jan 2011");
		}
		days = (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24 + 1;

		List<Long> rentList = hotelList.stream().map(hotel -> hotel.getRegularRates() * days)
				.collect(Collectors.toList());
		minRent = Collections.min(rentList);
		Hotel cheapestHotel = hotelList.stream().filter(hotel -> hotel.getRegularRates() * days == minRent).findFirst()
				.orElse(null);

		System.out.println("Cheapest Hotel: " + cheapestHotel.getName() + ", Total Cost: " + minRent);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("Welcome to Hotel Reservation Program");
		Scanner sc = new Scanner(System.in);

		cheapestHotel(sc.next(), sc.next());

		sc.close();
	}
}
