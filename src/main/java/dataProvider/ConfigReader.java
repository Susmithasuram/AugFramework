package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{

	public static String getValue(String key)
	{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configuration/config.properties")));
		} catch (FileNotFoundException e)
		{
			System.err.println("File not found "+e.getMessage());
		} catch (IOException e) 
		{
             System.out.println("Could not load the file ");
		}
		String value= prop.getProperty(key);
		return value;
	}
}
