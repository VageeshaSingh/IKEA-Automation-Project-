package utils;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {
	
	WebDriver driver;
	
public HelperMethods (WebDriver driver){
	this.driver=driver;
}
	
	public WebElement findElemetByXpath(String xpath){
		//waitForElementVisibility(driver.findElement(By.xpath(xpath)),5000);
		return driver.findElement(By.xpath(xpath));
		};
		
		public List<WebElement> findElemetsByXpath(String xpath){
			waitForElementVisibility(driver.findElements(By.xpath(xpath)),5000);
			return driver.findElements(By.xpath(xpath));
			};
	
	
	public WebElement findElementByLinktext(String linktext){
		waitForElementVisibility(driver.findElement(By.linkText(linktext)),5000);
		return driver.findElement(By.linkText(linktext));
	}
	
	public WebElement findElementByClassName(String className){
		waitForElementVisibility(driver.findElement(By.linkText(className)),5000);
		return driver.findElement(By.linkText(className));
	}
	
	public void waitForElementVisibility(List<WebElement> list, long timeOutInSeconds ){
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
		}
	
	public void waitForElementVisibility(WebElement webElement, long timeOutInSeconds ){
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		}
	
		
	}


