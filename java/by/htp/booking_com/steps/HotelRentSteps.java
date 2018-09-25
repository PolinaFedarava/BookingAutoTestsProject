package by.htp.booking_com.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.Augmenter;
import by.htp.booking_com.driver.DriverSingletone;
import by.htp.booking_com.pages.HomePage;
import by.htp.booking_com.pages.SearchResultPage;

public class HotelRentSteps {

	 private WebDriver driver;
	 
	 int numberXstarsHotel;
	 int numberOfHotelsOnPage;
 
	public void initBrowser() {
		driver = DriverSingletone.getDriver();
	}

	 public WebDriver getDriver() {
	 return driver;
	 }
	
	 public void closeDriver() {
	 DriverSingletone.closeDriver();
	 }
	 
	public void openMainPage() {
		HomePage mainPage = new HomePage(driver);
		mainPage.openPage();
		System.out.println("Main page is opened");
	}
	public void numberOfHotelsOnPage() {
		HomePage mainPage = new HomePage(driver);
		 numberOfHotelsOnPage = mainPage.numberOfHotelsOnPage();
	}

	public void numberOfXStarsHotelsOnTable(int numberStarHotel) {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		String numberXstarsHotelStr = searchResultPage.numberXstarsHotel( numberStarHotel);
		numberXstarsHotel = Integer.valueOf(numberXstarsHotelStr);
	}
	
	 public void selectStarsHotel(int selectionStar) {
	 SearchResultPage searchResultPage = new SearchResultPage(driver);
	 searchResultPage.selectStarsHotel(selectionStar);
	 System.out.println("Hotels with five stars are selected");
	 }
	
	public boolean compareNumberHotels() {
		System.out.println("numberOfHotelsOnPage: " + numberOfHotelsOnPage);
		System.out.println("numberXstarsHotel: " + numberXstarsHotel);
		if (numberXstarsHotel == numberOfHotelsOnPage) {
		System.out.println("number5starsHotel and numberOfHotelsOnPage are equal");
		return true;	
		}
		else {
			System.out.println("number5starsHotel and numberOfHotelsOnPage are not equal");
			return false;	
		}
	}

	 public String captureScreen() {
	 String path;
	 try {
	 WebDriver augmentedDriver = new Augmenter().augment(driver);
	 File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	 path = "./target/screenshots/" + source.getName();
	 FileUtils.copyFile(source, new File("D:\\screenshot\\screenshot.png"));
	 }
	 catch(IOException e) {
	 path = "Failed to capture screenshot: " + e.getMessage();
	 }
	 return path;
	 }

	 public void setGuests(int numberOfRooms, int adultGuests, int childrenGuests)
	 {
	 HomePage mainPage = new HomePage(driver);
	 mainPage.selectNumberOfRooms(numberOfRooms);
	 mainPage.selectNumberOfAdultGuests(adultGuests);
	 mainPage.selectNumberOfChildrenGuests(childrenGuests);
	 mainPage.clickOnFindHotels();
	 System.out.println("Searching hotels is started");
	 }

	public void addDestination(String dest) {
		HomePage mainPage = new HomePage(driver);
		mainPage.sendDestination(dest);
	}
	
	public void addDates (String ArrivalDate, String DepartureDate) {
		HomePage mainPage = new HomePage(driver);
		mainPage.setArrivalDate(ArrivalDate);
		mainPage.setDepartureDate(DepartureDate);
	}

	 public void selectFilter() {
		 SearchResultPage searchResultPage = new SearchResultPage(driver);
		 searchResultPage.clickLowPrice();
		 System.out.println("Filter are selected");
		 }
	 
	 public void setCurrency(String currencyName) {
		 HomePage mainPage = new HomePage(driver);
		 mainPage.selectCurrency(currencyName);
		 }
	 
	 public void setLanguage(String language) {
		 HomePage mainPage = new HomePage(driver);
		 mainPage.selectLanguage(language);
		 }
	 
}
