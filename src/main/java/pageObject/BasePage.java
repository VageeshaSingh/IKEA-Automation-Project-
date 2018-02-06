package pageObject;

import org.openqa.selenium.WebDriver;

import utils.HelperMethods;

abstract class BasePage {
	public static WebDriver driver;
	HelperMethods helper = new HelperMethods(driver);
	
	public abstract void isValid();
}

