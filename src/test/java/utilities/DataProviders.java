package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
				
	@DataProvider(name="logindata")
	
	public String [][] getData() throws IOException
	{
		String path = ".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility utility = new ExcelUtility(path);
		
		int totalrows=utility.getRowCount("Sheet1");
		int totalcol=utility.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcol];
		
		for(int i =1 ;i<=totalrows;i++)
		{
			for(int j=0;j<totalcol;j++)
			{
				logindata[i-1][j]=utility.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}
	
	

}
