package by.htp.booking_com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.booking_com.steps.HotelRentSteps;

public class TestCurrent {
	
	private static final String Currency_USD = "USD";
    private static final String Language = "English (US)";
 
	//private HotelRentSteps steps = new HotelRentSteps();
	
    public HotelRentSteps steps;
    
	@BeforeMethod
	public void setUp() {		
		steps.initBrowser();
	}

	@Test
	public void Current() {
		
		steps.setCurrency(Currency_USD);
		steps.setLanguage(Language);
	}

	@AfterMethod
	public void stopBrowser() {
		steps.closeDriver();
	}
}
