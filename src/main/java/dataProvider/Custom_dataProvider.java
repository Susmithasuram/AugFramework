package dataProvider;

import org.testng.annotations.DataProvider;

public class Custom_dataProvider 
{
	@DataProvider(name="login")
	public Object[][] getUserDetails()
	{
		return  ExcelReader.getDataFromExcel("login_details");
	}

}
