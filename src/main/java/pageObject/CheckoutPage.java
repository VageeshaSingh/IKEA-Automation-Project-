package pageObject;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private static WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * validate if user is on the check out page by getting the current url of
	 * page
	 */
	public String validatePageURL() {
		return driver.getCurrentUrl();
	}

}
