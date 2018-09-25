package by.htp.booking_com.steps;

import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

	 protected WebDriver driver;

	    public AbstractStep(WebDriver driver) {
	        this.driver = driver;
	    }
}
