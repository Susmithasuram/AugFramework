package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;
import net.bytebuddy.asm.Advice.This;

public class ExtentManager 
{

	static ExtentReports report;
	public static ExtentReports getInstance()
	{
		if (report==null)
		{
			report=createInstance();
			return report;
		}
		else {
			return report;
		}
	}
	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/Automation_report"+Utility.getCurrentDateTime()+".html");
		sparkReporter.config().setDocumentTitle("Sprint 1 report");
		sparkReporter.config().setReportName("Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
	    ExtentReports extent =new ExtentReports();
	    extent.attachReporter(sparkReporter);
		
					
		return extent;
	}
}
