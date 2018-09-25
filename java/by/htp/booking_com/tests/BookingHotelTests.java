package by.htp.booking_com.tests;

import java.util.Scanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.booking_com.run.ScannerClass;
import by.htp.booking_com.run.UserMenu;
import by.htp.booking_com.steps.HotelRentSteps;

public class BookingHotelTests {

		private HotelRentSteps steps = new HotelRentSteps();
		
		private static Scanner scanner = ScannerClass.getScanner();
		
		UserMenu scanName = new UserMenu ();

		@BeforeMethod
		public void setUp() {
			
			steps.initBrowser();
			System.out.println("init done");
		}

		@Test
		public void SimpleTest(String DESTINATION, String ArrivalDate, String DepartureDate, 
				int numberOfRooms, int adultGuests, int childrenGuests, int selectionStar, int numberStarHotel) {
			steps.openMainPage();
			TestCurrent currentTest = new TestCurrent ();
			currentTest.steps = steps; 
			int numberСurrentTest = 0;
			System.out.println("Do you want to change the language and currency?\n" + "1.Yes\n"+ "2.No");
			numberСurrentTest = scanner.nextInt();
			if (numberСurrentTest == 1) {
				currentTest.Current(); 
			}			
			steps.addDestination(DESTINATION);
			steps.addDates(ArrivalDate, DepartureDate);
			steps.setGuests( numberOfRooms, adultGuests,  childrenGuests);	
			
			if (selectionStar>0) {
			steps.selectStarsHotel(selectionStar);
			}
			
			if (numberStarHotel>0) {
			steps.numberOfXStarsHotelsOnTable(numberStarHotel);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			steps.numberOfHotelsOnPage();
			steps.compareNumberHotels();
			
			System.out.println("Do you want to apply the sorting for the price?\n" + "1.Yes\n"+ "2.No");
			int optionFilter = 0;
			optionFilter = scanner.nextInt();
			if (optionFilter == 1) {
			steps.selectFilter();}
			
			System.out.println("Do you want to fix the result screenshot?\n"+ "1.Yes\n"+ "2.No");
			int optionScreen = 0;
			optionScreen = scanner.nextInt();
			if (optionScreen == 1) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			steps.captureScreen();
			}
		}

		@AfterMethod
		public void stopBrowser() {
			steps.closeDriver();
		}
}
