package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import dataProvider.ConfigReader;
import factory.BrowserFactory;
import freemarker.core.ReturnInstruction.Return;
import helper.Utility;

public class Report_Listener implements ITestListener
{
	ExtentReports extentReports=ExtentManager.getInstance();
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
	    test=extentReports.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result)
	{
		if(ConfigReader.getValue("screenshotOnSuccess").equalsIgnoreCase("true"))
		{
		  String screenshot=Utility.getScreenshotAsBase64(BrowserFactory.getInstance());
          test.pass("Test Passed successfully",MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		}
		else
		{
			test.pass("Test Passed successfully");
		}
	}
	public void onTestFailure(ITestResult result) 
	{
		if(ConfigReader.getValue("screenshotOnFailure").equalsIgnoreCase("true"))
		{
		  String screenshot=Utility.getScreenshotAsBase64(BrowserFactory.getInstance());
          test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		}
		else
		{
			 test.fail("Test Failed "+result.getThrowable().getMessage());
		}
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		if(ConfigReader.getValue("screenshotOnSkip").equalsIgnoreCase("true"))
		{
		  String screenshot=Utility.getScreenshotAsBase64(BrowserFactory.getInstance());
          test.skip("Test Skipped "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		}
		else
		{
         test.skip(result.getThrowable().getMessage());
		}
	}

	public void onFinish(ITestContext context)
	{
 	      extentReports.flush();
	}

}
