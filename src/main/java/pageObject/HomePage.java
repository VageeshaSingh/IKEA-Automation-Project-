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

public class HomePage extends BasePage {

	public WebDriver driver;

	String GoToLoc = "html/body/section/div/div[3]/div[2]/a[2]";

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void homePageNavigation() throws InterruptedException {
		
		/* click on the chose location link */
		
		WebElement w = helper.findElemetByXpath(GoToLoc);
		w.click();
	}

	public String getLinkText() {
		
		/* get and return the text of choosing location link */
		
		return helper.findElemetByXpath(GoToLoc).getText();
		
	}
	
	public void isValid(){
	}
	
}



