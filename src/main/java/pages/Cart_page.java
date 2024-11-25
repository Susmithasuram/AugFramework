package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import helper.Utility;

public class Cart_page
{

	WebDriver driver;
	
	public Cart_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By enroll_btn=By.xpath("//button[text()='Enroll Now']");
	
	public Enroll_Page clickEnroll() {
		Utility.findElement(driver, enroll_btn);
		return new Enroll_Page(driver);
	}
}
