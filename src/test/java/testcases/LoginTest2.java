package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.Custom_dataProvider;
import pages.Cart_page;
import pages.Enroll_Page;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest2 extends BaseClass
{
	
	
	@Test(description ="This test will verify valid login scenario",dataProvider = "login",dataProviderClass = Custom_dataProvider.class)
	public void validLoginTest(String username,String password)
	{
	

		LoginPage login=new LoginPage(driver);
		HomePage home= login.loginToApp(username,password);
		String welcomeMsg=home.getWelcomeMsg();
		Assert.assertTrue(welcomeMsg.contains("Welcome"));
		home.addCourseToCart();
//		String removeFromCartMsg=home.getremoveFromCartMsg();
//		Assert.assertTrue(removeFromCartMsg.contains("Remove from Cart"));
		String cart_count= home.getCartCount();
		int cnt=Integer.parseInt(cart_count);
		Assert.assertTrue(cnt==1);
		
		Cart_page cartPage= home.clickCartButton();
		
		Enroll_Page enrollPage= cartPage.clickEnroll();
		
		enrollPage.enterDetailsfor_enrolling(welcomeMsg, cart_count);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Invalid Scenario
	
//	@Test(description = "This test will verify invalid login scenario",priority = 0)
//	public void invalidLoginTest()
//	{
//		LoginPage login=new LoginPage(driver);
//		HomePage home= login.loginToApp("ad@email.com","admin@123");
//		String errorMessage= login.getErrorMsg();
//		Assert.assertTrue(errorMessage.contains("Email and Password Doesn't match"));
//	}
//	
	

}
