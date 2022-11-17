 package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
   
	public static WebDriver driver;
	public Logger logger;
	
	public ResourceBundle rb;//create variable rb to get the info from config.properties//step4
	
	@BeforeClass(groups={"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) 
	 {
		rb=ResourceBundle.getBundle("config");//load config.properties file//step4
		
		logger =LogManager.getLogger(this.getClass());//to get the current class name for logging
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});//enable chrome is being controlled by automated test softwaare
		
		 //WebDriverManager.chromedriver().setup();//from the latest version of selenium we dont required  webDriver manager
		if (br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			//driver=new FirefoxDriver();
		}
		
		driver=new ChromeDriver();
		 //driver=new ChromeDriver(options)//if we use options then we should mention options here
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://demo.opencart.com/");
		
		driver.get(rb.getString("appURL"));//get the URL from config.properties//step4
		
		 driver.manage().window().maximize();
	 }
	@AfterClass(groups={"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.close();
	}
	
	 //these are not testng methods these are purely java methods we can call these methods from any where
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	public String randomAlphaNumeric()
	{
		//method1
		//String generatedString3=RandomStringUtils.randomAlphanumeric(10);
		//return(generatedString3);
		
		//method 2
		String str=RandomStringUtils.randomAlphabetic(5);
		
		String num=RandomStringUtils.randomNumeric(10);
		return(str+num);
	}
	
	public String captureScreen(String tname) throws IOException  {
		
	
	String timeStamp=new SimpleDateFormat("yymmddhhmmss").format(new Date());
	 
	TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
	
	File source=takeScreenShot.getScreenshotAs(OutputType.FILE);
	
	String destination=System.getProperty("user.dir") + "\\screenshots\\" + tname +" _" + timeStamp +".png";	
			try
			{
		FileUtils.copyFile(source, new File(destination));
	}
			catch(Exception e)
			{
				e.getMessage();			
			}
	
	return destination;
}
	
}
