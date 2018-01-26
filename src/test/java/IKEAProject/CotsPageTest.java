package IKEAProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFiles.BrowserInvoke;
import pageObject.CotsPage;
import pageObject.HomePage;
import pageObject.SingaporePage;

public class CotsPageTest extends BrowserInvoke{
	
	@BeforeTest
	
	public void Initialize(){
		try{
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}


	@Test
	
	public void validateCotsPage() throws InterruptedException{
		HomePage hp =new HomePage(driver);
		hp.homePageNavigation();
		SingaporePage sp = new SingaporePage(driver);
		Thread.sleep(5000);
		sp.selectCountry();
		sp.validateSubProductsOfBabyProducts();
		CotsPage cp =new CotsPage(driver);
		Assert.assertTrue(cp.getPageTitle());
		cp.verifyBuyableOnlineRadioButtonIsCheckedOnClick();
		Thread.sleep(5000);
		cp.getProductCots();
		
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
}
	


