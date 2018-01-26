package baseFiles;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvoke {
	
	public  static WebDriver driver;
	public Properties prop;
	
	/* Browser Invokation */
	
	public WebDriver initializeDriver() throws IOException{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\EclipiseMaven\\IkeaMavenProject\\E2EAutomation\\resources\\data.properties");
		
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:/software/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:/software/geckodriver.exe" );
			driver=new FirefoxDriver();
			
		}else if (browsername.equals("IE")){
			System.out.println("IE browser exe not available");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}

}
