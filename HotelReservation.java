package com.capgemini.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {

	private final static Hotel LAKEWOOD = new Hotel("Lakewood", 110, 90, 80, 80, 3);
	private final static Hotel BRIDGEWOOD = new Hotel("BridgeWood", 150, 50, 110, 50, 4);
	private final static Hotel RIDGEWOOD = new Hotel("Ridgewood", 220, 150, 100, 40, 5);

	static List<Hotel> hotelList = new ArrayList<>() {
		{
			add(LAKEWOOD);
			add(BRIDGEWOOD);
			add(RIDGEWOOD);
		}
	};

	public long totalDays(String start, String end) {
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		sdf.setLenient(false);
		try {
			startDate = sdf.parse(start);
			endDate = sdf.parse(end);
		} catch (ParseException e) {
			System.err.println("Wrong Date format. Enter like -> 5Jan2011");
		}

		return (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24 + 1;
	}

	public long weekendDays(String start, String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		LocalDate s = sdf.parse(start).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate e = sdf.parse(end).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long weekendDays = 0;
		for (LocalDate date = s; date.isBefore(e.plusDays(1)); date = date.plusDays(1)) {
			DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			switch (day) {
			case SATURDAY:
				weekendDays++;
				break;
			case SUNDAY:
				weekendDays++;
				break;
			default:
				break;
			}
		}
		return weekendDays;
	}

	public long rentCalculateRegular(Hotel hotel, long days, long weekendDays) {
		return hotel.getWeekdayRateRegular() * (days - weekendDays) + hotel.getWeekendRateRegular() * weekendDays;
	}

	public long rentCalculateReward(Hotel hotel, long days, long weekendDays) {
		return hotel.getWeekdayRateReward() * (days - weekendDays) + hotel.getWeekendRateReward() * weekendDays;
	}

	public void cheapestHotelRegular(String start, String end) throws ParseException {
		long days, minRent;
		days = totalDays(start, end);
		long weekendDays = weekendDays(start, end);

		List<Long> rentList = hotelList.stream().map(hotel -> rentCalculateRegular(hotel, days, weekendDays))
				.collect(Collectors.toList());
		minRent = Collections.min(rentList);
		List<Hotel> cheapestHotels = hotelList.stream()
				.filter(hotel -> rentCalculateRegular(hotel, days, weekendDays) == minRent)
				.collect(Collectors.toList());

		System.out.print("Cheapest Hotel(s): ");
		for (Hotel hotel : cheapestHotels)
			System.out.print(hotel.getName() + " ");
		System.out.println(", Total Cost: $" + minRent);
	}

	public void cheapestBestRatedHotelRegular(String start, String end) throws ParseException {
		long days, minRent;
		days = totalDays(start, end);
		long weekendDays = weekendDays(start, end);

		List<Long> rentList = hotelList.stream().map(hotel -> rentCalculateRegular(hotel, days, weekendDays))
				.collect(Collectors.toList());
		minRent = Collections.min(rentList);
		List<Hotel> cheapestHotels = hotelList.stream()
				.filter(hotel -> rentCalculateRegular(hotel, days, weekendDays) == minRent)
				.collect(Collectors.toList());
		Hotel cheapestHotel = cheapestHotels.stream().max(Comparator.comparing(Hotel::getRatings)).orElse(null);
		System.out.print("Regular Customer => Cheapest Hotel(s): ");
		System.out.print(cheapestHotel.getName() + ", Rating: " + cheapestHotel.getRatings());
		System.out.println(" and Total Cost: $" + minRent);
	}

	public void bestRatedHotelRegular(String start, String end) throws ParseException {
		Hotel bestRatedHotel = hotelList.stream().max(Comparator.comparing(Hotel::getRatings)).orElse(null);

		System.out.println("Best Rated Hotel for Regular Customer: " + bestRatedHotel.getName() + "; Total Cost: $"
				+ rentCalculateRegular(bestRatedHotel, totalDays(start, end), weekendDays(start, end)));
	}

	public void cheapestBestRatedHotelReward(String start, String end) throws ParseException {
		long days, minRent;
		days = totalDays(start, end);
		long weekendDays = weekendDays(start, end);

		List<Long> rentList = hotelList.stream().map(hotel -> rentCalculateReward(hotel, days, weekendDays))
				.collect(Collectors.toList());
		minRent = Collections.min(rentList);
		List<Hotel> cheapestHotels = hotelList.stream()
				.filter(hotel -> rentCalculateReward(hotel, days, weekendDays) == minRent).collect(Collectors.toList());
		Hotel cheapestHotel = cheapestHotels.stream().max(Comparator.comparing(Hotel::getRatings)).orElse(null);
		System.out.print("Reward Customer => Cheapest Hotel(s): ");
		System.out.print(cheapestHotel.getName() + ", Rating: " + cheapestHotel.getRatings());
		System.out.println(" and Total Cost: $" + minRent);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("Welcome to Hotel Reservation Program");
		String startDate = "11Sep2020";
		String endDate = "12Sep2020";
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.cheapestBestRatedHotelReward(startDate, endDate);
	}
}
