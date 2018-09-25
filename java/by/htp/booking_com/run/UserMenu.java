package by.htp.booking_com.run;

import java.util.Scanner;

import by.htp.booking_com.tests.BookingHotelTests;
import by.htp.booking_com.tests.TestCurrent;

public class UserMenu {

	private static Scanner scanner = ScannerClass.getScanner();

	public static void run() {
		userInterraction();
	}

	private static void userInterraction() {
		int option = 0;
		boolean repeat = true;
		while (repeat) {
			System.out.println("Welcome to Booking.com tests!\n " + "Lets Go?:\n " + "1. Go:\n"+ "2. Stop Program:");
			option = scanner.nextInt();
			if (option == 1) {
				repeat = goTests();
			} else {
				scanner.close();
				break;
			}
		}
	}

	public static String selectDESTINATION() {
		String DESTINATION = null;
		System.out.println("Enter DESTINATION LOCATION");
		DESTINATION = scanner.next();
		return DESTINATION;
	}

	public static String selectDates(int param) {
		String Date = null;
		if (param == 1) {
			System.out.println("Enter arrival date in format dd-mm-yyyy");
		} else if (param == 2) {
			System.out.println("Enter departure date in format dd-mm-yyyy");
		}
			Date = scanner.next();
		return Date;
	}

	public static int setGuests(int var) {
		int number = 0;
		switch (var) {
		case (1):
			System.out.println("Enter number of rooms");
			break;
		case (2):
			System.out.println("Enter number adult guests");
			break;
		case (3):
			System.out.println("Enter children guests");
			break;
		}
			number = scanner.nextInt();
		return number;
	}

	private static int selectStarsHotel() {
		int number = 0;
		System.out.println("Select the number of stars." + "\n" + "Choose the item:" + "\n" + "1 - withoutStarsHotels"
				+ "\n" + "2 - twoStarsHotels" + "\n" + "3 - threeStarsHotels" + "\n" + "4 - fourStarsHotels" + "\n"
				+ "5 - fiveStarsHotels");
			number = scanner.nextInt();
		return number;
	}

	private static boolean goTests() {
		BookingHotelTests simpleTest = new BookingHotelTests();
		
		String DESTINATION = selectDESTINATION();
		String ArrivalDate = selectDates(1);
		String DepartureDate = selectDates(2);
		
		int numberOfRooms = setGuests(1);
		int adultGuests = setGuests(2);
		int childrenGuests = setGuests(3);
		
		int starСhoice = 0;
		int selectionStar = 0;
		int numberStarHotel = 0;
		System.out.println("Do you want to choose the number of stars in the hotel?\n" + "1.Yes\n"+ "2.No");
		starСhoice = scanner.nextInt();
		if (starСhoice == 1) {
			 selectionStar = selectStarsHotel();
			 numberStarHotel = selectionStar;
		}	

		simpleTest.setUp();
		simpleTest.SimpleTest(DESTINATION, ArrivalDate, DepartureDate, numberOfRooms, adultGuests, childrenGuests,
				selectionStar, numberStarHotel);
		simpleTest.stopBrowser();
		return false;
	}

}
