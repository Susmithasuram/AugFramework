package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class HomePage 
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By welcomeMsg= By.xpath("//h4[@class='welcomeMessage']");
	private By courseName=By.xpath("//h2[text()='Selenium']");
	private By addToCart_btn=By.xpath("//h2[text()='Selenium']//following::button[text()='Add to Cart'][1]");
	private By removeFromCart_btn=By.xpath("//h2[text()='Selenium']//following::button[text()='Add to Cart'][1]");

	private By cartCount=By.xpath("//span[@class='count']");
	private By cartBtn=By.xpath("//button[text()='Cart']");
	
	
	public String getWelcomeMsg()
	{
		return driver.findElement(welcomeMsg).getText();
	}
	
	
	  public  Cart_page addCourseToCart() 
	  {
		  Utility.clickElement(driver,addToCart_btn);
		  return new Cart_page(driver);
	  }
	  
	  public String getremoveFromCartMsg()
	  {
		 return Utility.findElement(driver, removeFromCart_btn).getText();
	  }
	  
	  public String getCartCount() 
	  {
		 return  Utility.findElement(driver, cartCount).getText();
	  }
	  
	  public Cart_page clickCartButton()
	  {
		  
		  Utility.findElement(driver,cartBtn).click();
		  return new Cart_page(driver);
	  }
}
