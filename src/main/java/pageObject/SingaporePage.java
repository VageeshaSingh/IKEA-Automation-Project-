package pageObject;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SingaporePage extends BasePage{
	private static WebDriver driver;

	String region = "Singapore";
	String headerpath = "new-mainmenus";
	String headermenupath = ".//*[@id='mainPadding']/div[3]/div/div[2]/div[1]/ul[2]";
	String productRanges = ".//*[@id='subdropdown-products']/li/a[1]";
	String productRanges1 = ".//*[@id='subdropdown-products']/li[1]/a[1]";
	/*
	By productRanges2 = By.xpath(".//*[@id='subdropdown-products']/li[2]/a[1]");
	By productRanges3 = By.xpath(".//*[@id='subdropdown-products']/li[3]/a[1]");
	By productRanges4 = By.xpath(".//*[@id='subdropdown-products']/li[4]/a[1]");
	By productRanges5 = By.xpath(".//*[@id='subdropdown-products']/li[5]/a[1]");
	By productRanges6 = By.xpath(".//*[@id='subdropdown-products']/li[6]/a[1]");
	By productRanges7 = By.xpath(".//*[@id='subdropdown-products']/li[7]/a[1]");
	By productRanges8 = By.xpath(".//*[@id='subdropdown-products']/li[8]/a[1]");
	By productRanges9 = By.xpath(".//*[@id='subdropdown-products']/li[9]/a[1]");
	By productRanges10 = By.xpath(".//*[@id='subdropdown-products']/li[10]/a[1]");
	By productRanges11 = By.xpath(".//*[@id='subdropdown-products']/li[11]/a[1]");
	By productRanges12 = By.xpath(".//*[@id='subdropdown-products']/li[12]/a[1]");
	By productRanges13 = By.xpath(".//*[@id='subdropdown-products']/li[13]/a[1]");
	By productRanges14 = By.xpath(".//*[@id='subdropdown-products']/li[14]/a[1]");
	By productRanges15 = By.xpath(".//*[@id='subdropdown-products']/li[15]/a[1]");
	By productRanges16 = By.xpath(".//*[@id='subdropdown-products']/li[16]/a[1]");
	By productRanges17 = By.xpath(".//*[@id='subdropdown-products']/li[17]/a[1]");
	By productRanges18 = By.xpath(".//*[@id='subdropdown-products']/li[18]/a[1]");
	By productRanges19 = By.xpath(".//*[@id='subdropdown-products']/li[19]/a[1]");
	By productRanges20 = By.xpath(".//*[@id='subdropdown-products']/li[20]/a[1]");
	By productRanges21 = By.xpath(".//*[@id='subdropdown-products']/li[21]/a[1]");
	By productRanges22 = By.xpath(".//*[@id='subdropdown-products']/li[22]/a[1]");
	By productRanges23 = By.xpath(".//*[@id='subdropdown-products']/li[23]/a[1]");
	By productRanges24 = By.xpath(".//*[@id='subdropdown-products']/li[24]/a[1]");
	*/
	String babySubProduct = "//*[@id='subdropdown-products']/li[1]/div/div[1]";
	String  babySubProductProduct1 = "(//span[@class='white_label'])[position()=1]";
	String babySubProductProduct1Name = "//*[@id='subdropdown-products']/li[1]/div/div[1]/div[1]/a[1]";

	public SingaporePage(WebDriver driver) {
		this.driver = driver;
	}

	/* click on the country */
	public void selectCountry() {
		helper.findElementByLinktext(region).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/* verify the title of page */
	public boolean verifySingaporePageTitle() {

		String expectedpagetitle = "Affordable Furniture and Home Furnishing – IKEA Singapore - IKEA";
		return getPgaeTitle().contains(expectedpagetitle);

	}

	public String getPgaeTitle() {
		String title = driver.getTitle();
		return title;
	}

	/* verify the different type of products available on the page */

	public void verifyNumberOfMenusOnMenuBar() {

		WebElement headerMenu = helper.findElemetByXpath(headermenupath);
		int count = headerMenu.findElements(By.tagName("a")).size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String text = headerMenu.findElements(By.tagName("a")).get(i).getText();
			System.out.println(text);

			if (text.contains("PRODUCTS")) {
				headerMenu.findElements(By.tagName("a")).get(i).click();
				break;

			}
		}

	}
	/* validate the count of sub products under products */

	public void validateProductRangeUnderProducMenuBar() {
		verifyNumberOfMenusOnMenuBar();
		int actualCount = helper.findElemetsByXpath(productRanges).size();
		System.out.println(actualCount);
		int expectedCount = 24;
		Assert.assertEquals(actualCount, expectedCount);

		List<String> all_element_text = new ArrayList<String>();
		for (int i = 0; i < actualCount; i++) {
			
			
			all_element_text.add(helper.findElemetsByXpath(productRanges).get(i).getText());
			/*switch (i) {
			case 0:
				all_element_text.add(driver.findElement(productRanges1).getText());
				break;
			case 1:
				all_element_text.add(driver.findElement(productRanges2).getText());
				break;
			case 2:
				all_element_text.add(driver.findElement(productRanges3).getText());
				break;
			case 3:
				all_element_text.add(driver.findElement(productRanges4).getText());
				break;
			case 4:
				all_element_text.add(driver.findElement(productRanges5).getText());
				break;
			case 5:
				all_element_text.add(driver.findElement(productRanges6).getText());
				break;
			case 6:
				all_element_text.add(driver.findElement(productRanges7).getText());
				break;
			case 7:
				all_element_text.add(driver.findElement(productRanges8).getText());
				break;
			case 8:
				all_element_text.add(driver.findElement(productRanges9).getText());
				break;
			case 9:
				all_element_text.add(driver.findElement(productRanges10).getText());
				break;
			case 10:
				all_element_text.add(driver.findElement(productRanges11).getText());
				break;
			case 11:
				all_element_text.add(driver.findElement(productRanges12).getText());
				break;
			case 12:
				all_element_text.add(driver.findElement(productRanges13).getText());
				break;
			case 13:
				all_element_text.add(driver.findElement(productRanges14).getText());
				break;
			case 14:
				all_element_text.add(driver.findElement(productRanges15).getText());
				break;
			case 15:
				all_element_text.add(driver.findElement(productRanges16).getText());
				break;
			case 16:
				all_element_text.add(driver.findElement(productRanges17).getText());
				break;
			case 17:
				all_element_text.add(driver.findElement(productRanges18).getText());
				break;
			case 18:
				all_element_text.add(driver.findElement(productRanges19).getText());
				break;
			case 19:
				all_element_text.add(driver.findElement(productRanges20).getText());
				break;
			case 20:
				all_element_text.add(driver.findElement(productRanges21).getText());
				break;
			case 21:
				all_element_text.add(driver.findElement(productRanges22).getText());
				break;
			case 22:
				all_element_text.add(driver.findElement(productRanges23).getText());
				break;
			case 23:
				all_element_text.add(driver.findElement(productRanges24).getText());

				break;
			}
			*/

		}
		System.out.println(all_element_text);

	}
	/* find and click on the sub products of the page */

	public void validateSubProductsOfBabyProducts() throws InterruptedException {
		verifyNumberOfMenusOnMenuBar();
		helper.findElemetByXpath(productRanges1).click();
		Thread.sleep(5000);
		WebElement bsp = helper.findElemetByXpath(babySubProduct);
		int actualCount = bsp.findElements(By.tagName("a")).size();
		System.out.println(actualCount);
		String babySubProductName = helper.findElementByClassName(babySubProductProduct1).getText();
		if (babySubProductName.equalsIgnoreCase("Cots")) {
			helper.findElemetByXpath(babySubProductProduct1Name).click();
		}
	}

	@Override
	public void isValid() {
		// TODO Auto-generated method stub
		
	}

}
