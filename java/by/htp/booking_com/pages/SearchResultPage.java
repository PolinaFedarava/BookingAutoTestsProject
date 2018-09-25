package by.htp.booking_com.pages;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstractPage {

	@FindBy(xpath = "//a[@data-id='class-5']")
	private WebElement fiveStarsHotelsCheckBox;

	@FindBy(xpath = "//a[@data-id='class-4']")
	private WebElement fourStarsHotelsCheckBox;

	@FindBy(xpath = "//a[@data-id='class-3']")
	private WebElement threeStarsHotelsCheckBox;

	@FindBy(xpath = "//a[@data-id='class-2']")
	private WebElement twoStarsHotelsCheckBox;

	@FindBy(xpath = "//a[@data-id='class-0']")
	private WebElement withoutStarsHotelsCheckBox;

	@FindBy(xpath = "//*[@class='sort_option']")
	private WebElement sortOptionButton;

	@FindBy(xpath = "//*[@class='sort_suboption js-mtv_sorting_option .sort_suboption']")
	private WebElement relaxationButton;

	@FindBy(xpath = "//a[contains(text(),'Самая низкая цена в начале')]")
	//@FindBy(xpath = "//*[@id='sort_by']/ul/li[2]/a)]")
	private WebElement lowPriceButton;

	@FindBy(xpath = "//*[@data-id='class-5']/div/span[2]")
	private WebElement number5StarsHotel;

	@FindBy(xpath = "//*[@data-id='class-4']/div/span[2]")
	private WebElement number4StarsHotel;
	
	@FindBy(xpath = "//*[@data-id='class-2']/div/span[2]")
	private WebElement number3StarsHotel;
	
	@FindBy(xpath = "//*[@data-id='class-0']/div/span[2]")
	private WebElement number2StarsHotel;
	
	@FindBy(xpath = "//*[@data-id='class-5']/div/span[2]")
	private WebElement numberWithoutStarsHotel;
	
	public String numberXstarsHotel(int numberStarHotel) {
		switch (numberStarHotel) {
		case (0):
			return numberWithoutStarsHotel.getAttribute("innerText");
		case (2):
			return number2StarsHotel.getAttribute("innerText");
		case (3):
			return number3StarsHotel.getAttribute("innerText");
		case (4):
			return number4StarsHotel.getAttribute("innerText");
		case (5):
			return number5StarsHotel.getAttribute("innerText");
		}
		return null;
	
	}

	public void clickLowPrice() {

		lowPriceButton.click();
	}



	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='hotellist_inner']/div"));
		return searchResults;
	}

	public void selectStarsHotel(int selectionStar) {
		switch (selectionStar) {
		case (1):
			waitAndClickButton(withoutStarsHotelsCheckBox);
			;
			break;
		case (2):
			waitAndClickButton(twoStarsHotelsCheckBox);
			;
			break;
		case (3):
			waitAndClickButton(threeStarsHotelsCheckBox);
			;
			break;
		case (4):
			waitAndClickButton(fourStarsHotelsCheckBox);
			;
			break;
		case (5):
			waitAndClickButton(fiveStarsHotelsCheckBox);
			;
			break;
		}
	}

	public void waitAndClickButton(WebElement button) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(button));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	} 
	
	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
