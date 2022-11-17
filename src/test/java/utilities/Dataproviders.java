package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	//Data provider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\logindata.xlsx";//taking xl file from testData and store in two dimentional array
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];//created two dimentional array 
		
		for(int i=1;i<=totalrows;i++) //read the data from the excel and store in the two dimentional array
		{
			for (int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);//row=0,col=1
				
			}
		}
			return logindata;//returning two dimentional array
			
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
