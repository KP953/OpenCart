package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static  WebDriver driver;
	
	public Logger logger;
	
	public Properties p;
	
	@BeforeClass(groups= {"Sanity", "Regression" ,"Master"})
	@Parameters({"os","browser"})
	public void setup(String os , String br) throws IOException 
	{
		
		//Loading config.properties file
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("exicution_env").equalsIgnoreCase("remote"))	
		{
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			//os
			
			if(os.equalsIgnoreCase("windows"))
			{
				Capabilities.setPlatform(Platform.WIN10);
				
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				Capabilities.setPlatform(Platform.MAC);
				
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
				
			switch(br.toLowerCase())
			{
			case "chrome" : Capabilities.setBrowserName("chrome");
			break;
			
			case "edge" : Capabilities.setBrowserName("MicrosoftEdge");
			break;
			
			default : System.out.println("No matching browser...");
			return;
						
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444"),Capabilities);
			
			
		}
		
		if(p.getProperty("exicution_env").equalsIgnoreCase("local"))	
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); 
			break;
			
			case "edge" : driver=new EdgeDriver(); 
			break;
			
//			case "firefox" : driver=new FirefoxDriver(); 
//			break;
			
			default : System.out.println("Invalid browser name...");
			return;
			
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appurl1")); // Reading URL From the Properties file.
		driver.manage().window().maximize();	
	}
	
	@AfterClass(groups= {"Sanity", "Regression" ,"Master"})
	public void tierdown()
	{
		
		driver.quit();
		
	}
	
	public String randomString()
	{
		 String randomalphate=RandomStringUtils.randomAlphabetic(5);
		 return randomalphate;
	}
	
	public String randomNumeric()
	{
		String randomnumric =RandomStringUtils.randomNumeric(10);
		return randomnumric;
	}
	
	public String alphaNumeric()
	{
		String randomalphate=RandomStringUtils.randomAlphabetic(3);
		String randomnumric =RandomStringUtils.randomNumeric(3);
		return (randomalphate+"@"+randomnumric);
	
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
