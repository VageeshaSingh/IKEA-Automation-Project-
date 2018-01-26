package IKEAProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFiles.BrowserInvoke;
import pageObject.CotWithDrawersPage;
import pageObject.CotsPage;
import pageObject.HomePage;
import pageObject.ShoppingCartPage;
import pageObject.SingaporePage;

public class ShoppingCartPageTest extends BrowserInvoke {
	
@BeforeTest
	
	public void Initialize(){
		try {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void validateCotWithDrawersPage() throws InterruptedException{
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
		CotWithDrawersPage cwdp = new CotWithDrawersPage(driver);
		String actualTitle = cwdp.getTitleOfPage();
		System.out.println(actualTitle);
		String expectedTitle = "STUVA Cot with drawers - IKEA";
		Assert.assertTrue(expectedTitle.equals(actualTitle));
		cwdp.validateBackgroundColourOfBuyOnlineTextdBoxBeforeMouseHower();
		cwdp.enterQuantityInInputBox();
		cwdp.validateProductAddedInShppingCart();
		Thread.sleep(5000);
		cwdp.validateProductAvailabilityInStore();
		Thread.sleep(5000);
		cwdp.clickOnCartIcon();
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		String actualTitleOfScpPage = scp.validateTitleOfPage();
		String expectedTitleOfScpPage = "shopping cart - IKEA";
		Assert.assertEquals(actualTitleOfScpPage, expectedTitleOfScpPage);
		scp.clickOnCheckoutButton();
		
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}

}
