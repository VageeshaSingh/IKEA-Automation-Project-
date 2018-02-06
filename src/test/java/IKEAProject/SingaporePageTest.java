package IKEAProject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFiles.BrowserInvoke;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.SingaporePage;

public class SingaporePageTest extends BrowserInvoke {
	
	HomePage hp = new HomePage(driver);
	SingaporePage sp = new SingaporePage(driver);

	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void validateCountry() throws InterruptedException {
		
		hp.homePageNavigation();
		Thread.sleep(5000);
		sp.selectCountry();
		boolean pageTitle = sp.verifySingaporePageTitle();
		System.out.println(pageTitle);
		Thread.sleep(5000);
		if(pageTitle){
		sp.validateProductRangeUnderProducMenuBar();
		Thread.sleep(5000);
		}
		else{
			System.out.println("Singapore Page not found");
		}
		
		sp.validateSubProductsOfBabyProducts();
		

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
