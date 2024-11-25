package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	WebDriver driver=null;
	

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username= By.xpath("//input[@placeholder='Enter Email']");
	By password= By.xpath("//input[@placeholder='Enter Password']");
	By signInBtn=By.xpath("//button[text()='Sign in']");
	
	By errorMsg=By.xpath("//h2[@class='errorMessage']");
	
	public HomePage loginToApp(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signInBtn).click();
		return new HomePage(driver);
	}
	
	public String getErrorMsg()
	{
		String value=driver.findElement(errorMsg).getText();
		return value;
	}
	
	

}
