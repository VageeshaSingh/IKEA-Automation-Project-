package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CotWithDrawersPage {
	
	private static WebDriver driver;
	
	By txtTestBox = By.id("popupAddToCartS79230116");
	String bgc = "background-color";
	By quantInputBox = By.id("quantity");
	By buyableOnlineButton = By.xpath(".//*[@id='jsButton_buyOnline_lnk']");
	By cartWindow = By.xpath(".//*[@id='slPopup']/div[3]/div/div/div");
	By addProdLink = By.xpath(".//*[@id='formShoppingListPopup']/div[1]/a");
	By itemCount = By.xpath(".//*[@id='beginCheckoutTop']/div/div/strong");
	By storeDisplayWindow = By.xpath(".//*[@id='stocksearchContainer']/div[1]/button/span/span[2]");
	By storeList = By.xpath(".//*[@id='selectionDropDownList']/li[3]/span");
	By storeListTest = By.xpath(".//*[@id='checkProductText']/div[1]/span[2]/a");
	By cartIcon = By.xpath(".//*[@id='cart-icon']");
	
	public  CotWithDrawersPage(WebDriver driver){
		this.driver  =driver;
	}
	
	public String getTitleOfPage(){
		return driver.getTitle();
	}
	public void validateBackgroundColourOfBuyOnlineTextdBoxBeforeMouseHower(){
		WebElement txtTest = driver.findElement(txtTestBox);
		String colourBeforeMouseHower = txtTest.getCssValue(bgc);
		System.out.println(colourBeforeMouseHower);
		
	}
	public void enterQuantityInInputBox(){
		driver.findElement(quantInputBox).clear();
		driver.findElement(quantInputBox).sendKeys("3");
	}
	public void clickOnBuyOnlineLink() throws InterruptedException{
		driver.findElement(buyableOnlineButton).click();
		Thread.sleep(3000);
	}
	public void validateProductAddedInShppingCart() throws InterruptedException{
		clickOnBuyOnlineLink();
		/*Set <String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);*/
		WebElement cart = driver.findElement(cartWindow);
		cart.findElement(addProdLink).click();
		String countOfItemsInCart = navigateToShoppingCartWindow();
		System.out.println(countOfItemsInCart);
		driver.navigate().back();
		Thread.sleep(5000);
		
		
		
	}
	public String navigateToShoppingCartWindow(){
		String countOfItemsInCart = driver.findElement(itemCount).getText();
		return countOfItemsInCart;
	}
public void validateProductAvailabilityInStore() throws InterruptedException{
	
	Thread.sleep(5000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)");
	 driver.findElement(storeDisplayWindow).click();
	 WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(storeList));
	driver.findElement(storeList).click();
	Thread.sleep(4000);
	System.out.println(driver.findElement(storeListTest).getText());
	
	
}
public void clickOnCartIcon(){
	driver.findElement(cartIcon).click();
	

}
}
