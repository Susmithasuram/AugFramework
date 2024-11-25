package helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Utility
{
	public static void waitusingThread(int seconds)
	{
		try
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) 
		{
			
		}
	}
	
	public static String getCurrentDateTime()
	{
		Date currentDate=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String newDate= format.format(currentDate);
		return newDate;
	}
	public static String getScreenshotAsBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String screenshot= ts.getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
	
	public static WebElement findElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
	    return element;
	}
	
	public static WebElement findElement(WebDriver driver,By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
	    WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
	    return element;
	}
	
	public static void clickElement(WebDriver driver,By locator)
	{
		WebElement element= findElement(driver, locator);
		try
		{
		   element.click();
		}
		catch (Exception e) 
		{
			System.out.println("LOG-INFO: Normal click failed-- trying with actions class ");
			
			Actions act=new Actions(driver);
			try 
			{
				act.moveToElement(element).click();	
			} catch (Exception e2)
			{
				System.out.println("LOG-INFO-Actions class click failed --trying js Executor click");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
			
			
		}
	}
	
	public static void clickElement(WebDriver driver,By locator,int time)
	{
		WebElement element= findElement(driver, locator,60);
		try
		{
		   element.click();
		}
		catch (Exception e) 
		{
			System.out.println("LOG-INFO: Normal click failed-- trying with actions class ");
			
			Actions act=new Actions(driver);
			try 
			{
				act.moveToElement(element).click();	
			} catch (Exception e2)
			{
				System.out.println("LOG-INFO-Actions class click failed --trying js Executor click");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
			
			
		}
	}
	
}
