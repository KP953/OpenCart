package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class TC02_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verifyLoginTest()
	{
		
		logger.info("**** Starting TC02_LoginTest *****");
		
		try {
		//HomePage
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickLogin();
		
		//LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(p.getProperty("email"));
		loginpage.setPassword(p.getProperty("password"));
		loginpage.clickLogin();
	
		
		//MyAccontPage
		
		 MyAccountPage myaccount  = new MyAccountPage(driver);
		 boolean targetpage=myaccount.isMyaccountPageExist();
		 Assert.assertTrue(targetpage);
				
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		 
		 logger.info("**** Finished TC02_LoginTest *****");		 
		
		
		
		
		
		
		
		
	}
	
	

}
