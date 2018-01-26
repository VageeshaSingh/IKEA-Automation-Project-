package pageObject;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFiles.BrowserInvoke;
import junit.framework.Assert;
import pageObject.SingaporePage;

public class HomePage {

	public WebDriver driver;

	By GoToLoc = By.xpath("html/body/section/div/div[3]/div[2]/a[2]");

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void homePageNavigation() throws InterruptedException {
/* click on the chose location link*/
		driver.findElement(GoToLoc).click();
	}

	public String getLinkText() {
		/* get and return the text of chosing location link */
		return driver.findElement(GoToLoc).getText();
	}

}
