package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelReader
{

	static XSSFWorkbook wb;
	
	@Test
	public static Object[][] getDataFromExcel(String sheetName)
	{
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx"));
			wb=new XSSFWorkbook(fis);
		} 
		
		catch (FileNotFoundException e)
		{
			System.out.println("File not found " +e.getMessage());
		}
		catch (IOException e) 
		{
		
			System.out.println("Not able to read the file " +e.getMessage());
		}
		
		int rows=  wb.getSheet(sheetName).getPhysicalNumberOfRows();
		int coloumns=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		Object[][] arr=new Object[rows-1][coloumns];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<coloumns;j++)
			{
				String value= getData(sheetName,i, j);
				arr[i-1][j]=value;
			}
		}
		
		return arr;
		
	}
	
	@Test
	public static String getData(String sheetName,int rownum,int colnum)
	{
		
		String value="";
		CellType type= wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getCellType();
		if(type==CellType.STRING)
		{
			value=wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getStringCellValue();
		}
		else if (type==CellType.NUMERIC)
		{
			Double d= wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
		    value=String.valueOf(d);
		}
		else if(type==CellType.BOOLEAN) 
		{
			Boolean b=wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getBooleanCellValue();
			value=String.valueOf(b);
		}
		else if(type==CellType.BLANK) 
		{
			value="";
		}
		return value;
	}
	
	
}
