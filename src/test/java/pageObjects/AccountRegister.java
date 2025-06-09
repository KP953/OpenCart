package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegister extends BasePage{
	
	
	public AccountRegister(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtgmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement 	txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtconfpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")	
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setGmail(String gmail)
	{
		txtgmail.sendKeys(gmail);
		
	}
	
	public void setTelephone(String telephone)
	{
		txttelephone.sendKeys(telephone);
		
	}
	
	public void setPassword(String pasword)
	{
		txtpassword.sendKeys(pasword);
		
	}
	public void setConfirmpassword(String pasword)
	{
		txtconfpassword.sendKeys(pasword);
	}
	
	public void setcheckPolicy()
	{
		chkpolicy.click();
	}
	
	public void clkcontinue()
	
	{
		btncontinue.click();
	}
	
	public String getConfirmationMessage()
	{
		try {
			return (msgconfirmation.getText());
		}
		
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
		
	
	
		
}
