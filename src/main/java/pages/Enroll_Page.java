package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class Enroll_Page
{
	WebDriver driver;
	public Enroll_Page(WebDriver driver)
	{
		this.driver=driver;
	}

	private By address=By.id("address");
	private By phone=By.id("phone");
	
	public void enterDetailsfor_enrolling(String place,String phnum) {
		Utility.findElement(driver, address).sendKeys(place);
		Utility.findElement(driver,phone).sendKeys(phnum);
	}
	
}
