package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CotsPage {
	
	private static WebDriver driver;
	
	By buyablonlinebutton = By.id("buyableOnline");
	By colorRadioButton = By.xpath(".//*[@id='productsFilterOptions']/div[1]/div[2]/div");
	By greenColourRadioButton = By.xpath(".//*[@id='filterImageTooltip']/div[4]/a");
	By cotsImageLink = By.xpath(".//*[@id='item_S79230116_1']/div[1]/a");
	
	public CotsPage(WebDriver driver){
		this.driver=driver;
	}

	public boolean getPageTitle(){
		String actualTitle = driver.getTitle();
		String expectedTitle = "Cots - IKEA";
		return actualTitle.contains(expectedTitle);
		
	}
	public void verifyBuyableOnlineRadioButtonIsCheckedOnClick(){
		int countBeforeClick = verifyCountOfColourRadioButtonsWhenBuyableOnlinebuttonIsNotChecked();
		driver.findElement(buyablonlinebutton).click();
		int countAfterClick = verifyCountOfColourRadioButtonsWhenBuyableOnlinebuttonIsNotChecked();
		Assert.assertNotEquals(countBeforeClick, countAfterClick);
		System.out.println("Buyable Online radio button is validated");
		
		
		}
	public int verifyCountOfColourRadioButtonsWhenBuyableOnlinebuttonIsNotChecked(){
		
		WebElement colorRadioButtonElement = driver.findElement(colorRadioButton);
		int count = colorRadioButtonElement.findElements(By.tagName("a")).size();
		System.out.println(count);
		return count;
		
	}
	
	public void clickOnColourRadioButton() throws InterruptedException{
		driver.findElement(greenColourRadioButton).click();
		Thread.sleep(5000);
		
	}
	
	public void getProductCots() throws InterruptedException{
		clickOnColourRadioButton();
		/*WebElement element = driver.findElement(cotsImageLink);
		Actions action = new Actions (driver);
		action.moveToElement(element).click().build().perform();*/
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		//jse.executeScript("scroll(250, 0)"); // if the element is on top.

		jse.executeScript("scroll(0, 250)");
		Thread.sleep(3000);
		driver.findElement(cotsImageLink).click();
		
		Thread.sleep(5000);
		
	}
}
