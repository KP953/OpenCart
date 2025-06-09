package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC03_DDT extends BaseClass {
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pswd, String exp)
	{
		
		logger.info("*** Started TC03_DDT***");
		
		try {
		//HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickLogin();
				
		//LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(email);
		loginpage.setPassword(pswd);
		loginpage.clickLogin();
			
				
		//MyAccontPage
				
		MyAccountPage myaccount  = new MyAccountPage(driver);
		boolean targetpage=myaccount.isMyaccountPageExist();
		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true) 
			{
				myaccount.clickLogOut();
				Assert.assertTrue(true);
			
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
		
			if(targetpage==true) 
			{
				myaccount.clickLogOut();
				Assert.assertTrue(false);
			
			}
			
			else
			{
				Assert.assertTrue(true);
				
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		
		logger.info("*** Finished TC03_DDT***");
	}

}
