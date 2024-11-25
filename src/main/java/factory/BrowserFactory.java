package factory;

import java.time.Duration;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.NewClassRefForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import dataProvider.ConfigReader;

public class BrowserFactory 
{
	 static WebDriver driver;
	 
	public static WebDriver getInstance()
	{
		return driver;
	}

	public static WebDriver getDriver(String browser,String appUrl)
	{
		
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			if(ConfigReader.getValue("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("headless=new");
			}
			driver=new ChromeDriver(opt);
		}
		else if (browser.equalsIgnoreCase("Edge")) 
		{
			EdgeOptions opt=new EdgeOptions();
			if(ConfigReader.getValue("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("headless=new");
			}
		  driver=new EdgeDriver(opt);	
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions opt=new FirefoxOptions();
			if(ConfigReader.getValue("headless").equalsIgnoreCase("true"))
			{
				opt.addArguments("headless=new");
			}
			driver=new FirefoxDriver(opt);
		}
		else 
		{
			System.out.println("LOG:INFO-Sorry currently we dont support "+browser);
		}
				
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("pageLoad"))));
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("implicitwait"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("scriptTimeout"))));
		
		
		return driver;
	}
}
