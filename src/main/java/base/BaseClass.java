package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.util.concurrent.ClosingFuture.ClosingCallable;

import dataProvider.ConfigReader;
import factory.BrowserFactory;

public class BaseClass
{
	public WebDriver driver;
	@BeforeClass
	public void setUpBrowser()
	{
		System.out.println("LOG:INFO-Setting  up browser");
		
		driver=BrowserFactory.getDriver(ConfigReader.getValue("browser"),ConfigReader.getValue("qaenv"));
		
		System.out.println("LOG:INFO-Application is up and running");
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO-Closing the browser");
		driver.quit();
		System.out.println("LOG:INFO-Browser and application is closed");
	}

}
