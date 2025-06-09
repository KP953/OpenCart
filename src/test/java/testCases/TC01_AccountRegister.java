package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testbase.BaseClass;


public class TC01_AccountRegister extends BaseClass {
	

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("**** Starting TC01_AccountRegister  ******");
		
		try{
		HomePage homepage= new HomePage(driver);	
		homepage.clickMyAccount();
		
		logger.info("Click on MyAccount link");
		
		homepage.clickRgister();
		
		logger.info("Click on Register link");
		
		AccountRegister accreg = new AccountRegister(driver);
		
		logger.info("Providing Customer Details");
		
		accreg.setFirstName(randomString().toUpperCase());
		accreg.setLastName(randomString().toUpperCase());
		accreg.setGmail(randomString()+"@gmail.com");
		accreg.setTelephone(randomNumeric());
		
		String PassWord=alphaNumeric();	
		accreg.setPassword(PassWord);
		accreg.setConfirmpassword(PassWord);
		accreg.setcheckPolicy();
		accreg.clkcontinue();
		
		
		
		logger.info("Validating expected message");
		String cnfmsg=accreg.getConfirmationMessage();
		
		if(cnfmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Faild");
			logger.debug("Debug Logs");
			
			Assert.assertTrue(false);
			
		}
		
		//Assert.assertEquals(cnfmsg, "Your Account Has Been Created!!!");	
		
		}
		catch(Exception e)
		{
		
			Assert.fail();
		}
		
		logger.info("**** Finished TC01_AccountRegister  ******");	
		
	}
	

	
	

}
