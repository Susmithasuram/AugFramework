package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.Custom_dataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass
{
	//baseclass->browserfactory->configreader->dataprovider->excelreader->dataprovider->test->pages->utilities->pages->tests->baseclass
	
	
	@Test(description ="This test will verify valid login scenario",dataProvider = "login",dataProviderClass = Custom_dataProvider.class)
	public void validLoginTest(String username,String password)
	{
	

		LoginPage login=new LoginPage(driver);
		HomePage home= login.loginToApp(username,password);
		String welcomeMsg=home.getWelcomeMsg();
		Assert.assertTrue(welcomeMsg.contains("Welcome"));
		
		
	}
	
	

}
