package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
	
	private static WebDriver driver;
	
	By checkoutButton = By.xpath(".//*[@id='jsButton_beginCheckOut_01']/div[2]/input");
	
	
	public ShoppingCartPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String validateTitleOfPage(){
		return driver.getTitle();
	}
	
	public void clickOnCheckoutButton(){
		driver.findElement(checkoutButton).click();
	}

}
