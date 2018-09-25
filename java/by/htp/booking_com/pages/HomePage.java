package by.htp.booking_com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

	private final String BASE_URL = "https://www.booking.com/";

	 @FindBy(id = "ss")
	 private WebElement destinationField;

	 @FindBy(xpath = "//*[@class='sb-searchbox__button  ']")
	 private WebElement findHotels;
	
	 @FindBy(xpath = "//div[@data-mode='checkin']//button")
	 private WebElement checkInButton;

	 @FindBy(xpath = "//div[@data-mode='checkout']//button")
	 private WebElement checkOutButton;
	
	 @FindBy(xpath = "//*[@class='xp__guests__count']")
	 private WebElement guestsCount;
	
	 @FindBy(id = "no_rooms")
	 private WebElement roomsField;
	
	 @FindBy(id = "group_adults")
	 private WebElement AdultsField;
	
	 @FindBy(id = "group_children")
	 private WebElement ChildrenField;
	
	 @FindBy(xpath = "//*[@data-id='currency_selector']/a")
	 private WebElement currencyButton;
	
	 @FindBy(xpath = "//*[@data-id='currency_selector']/input")
	 private WebElement currencyValue;
	
	 @FindBy(xpath = "//*[@data-id='language_selector']/a")
	 private WebElement languageButton;
	
	 @FindBy(xpath = "//*[@class='currency_list']/li")
	 private List<WebElement> allCurrencies;
	
	 @FindBy(className = "sr-hotel__name")
	 private List<WebElement> listHotels;

	 @FindBy(xpath = "//*[@class='language_flags']/li")
	 private List<WebElement> allLanguages;
	 
	 public HomePage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(this.driver, this);
		}

	public void clickCheckInDate(String dateIN) {
		checkInButton.click();
	}

	public void selectNumberOfRooms(int numberOfRooms) {
		guestsCount.click();
		Select dropdownRooms = new Select(roomsField);
		dropdownRooms.selectByVisibleText(String.valueOf(numberOfRooms));
	}

	public void selectNumberOfAdultGuests(int adultGuests) {
		Select dropdownAdults = new Select(AdultsField);
		dropdownAdults.selectByVisibleText(String.valueOf(adultGuests));
	}

	public void selectNumberOfChildrenGuests(int childrenGuests) {
		Select dropdownChildren = new Select(ChildrenField);
		dropdownChildren.selectByVisibleText(String.valueOf(childrenGuests));
	}

	public void setArrivalDate(String dateIN) {

		checkInButton.click();
		checkInButton.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(dateIN.replaceAll("\\D", ""));
	}

	public void setDepartureDate(String dateOUT) {
		checkOutButton.click();
		checkOutButton.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(dateOUT.replaceAll("\\D", ""));
	}

	public void sendDestination(String dest) {
		destinationField.click();
		System.out.println("destckick");
		destinationField.clear();

		destinationField.sendKeys(dest);
		System.out.println("destKey");
	}

	public void clickOnFindHotels() {
		findHotels.click();
	}

	@Override
	public void openPage() {
	driver.navigate().to(BASE_URL);
	//driver.get(BASE_URL);
	}

	public int numberOfHotelsOnPage() {
		return listHotels.size();
	}

	public boolean selectCurrency(String currencyName) {
		String actualCurrency = currencyValue.getAttribute("value");
		if (!actualCurrency.equals(currencyName.toUpperCase())) {
			waitAndClickButton(currencyButton);
			return setCurrency(currencyName);
		}
		return true;
	}

	public boolean selectLanguage(String language) {
		waitAndClickButton(languageButton);
		return setLanguage(language);
	}

	private boolean setCurrency(String currencyName) {
		for (WebElement cur : allCurrencies) {
			if (currencyName.equalsIgnoreCase(cur.getAttribute("data-lang"))) {
				waitAndClickButton(cur.findElement(By.tagName("a")));
				return true;
			}
		}
		return false;
	}

	private boolean setLanguage(String language) {
		for (WebElement lang : allLanguages) {
			if (lang.getText().equalsIgnoreCase(language)) {
				waitAndClickButton(lang.findElement(By.tagName("a")));
				return true;
			}
		}
		return false;
	}

	public void waitAndClickButton(WebElement button) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(button));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

}
