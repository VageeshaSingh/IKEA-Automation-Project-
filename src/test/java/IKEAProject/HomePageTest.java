package IKEAProject;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFiles.BrowserInvoke;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.SingaporePage;

public class HomePageTest extends BrowserInvoke {
	static String className = BrowserInvoke.class.getName();
	//public Logger log = LogManager.getLogger(className);

	@BeforeTest
/* Launch the URL */
	public void Initilize() throws IOException {
		driver = initializeDriver();
		//log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));

	}

	@Test

	public void homePageNavigationTest() throws InterruptedException {
		//log.info(" Navigated to website");
		/* Goto home page class and call the methds */
		HomePage hp = new HomePage(driver);
		hp.homePageNavigation();
		String actualtext = hp.getLinkText();
		String expectedtext = "I want to choose another location";
		Assert.assertEquals(expectedtext, actualtext);
		System.out.println(" Test case passed : successfully clicked on chosing country link");

		// Thread.sleep(5000);

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
