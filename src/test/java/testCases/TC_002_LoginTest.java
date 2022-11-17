package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test (groups={"Sanity","Master"})
	public void test_login()
	{
		try
		{
			logger.info("****Starting TC_002_LoginTest***");
	HomePage hp=new HomePage(driver);	
	hp.ClickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(rb.getString("email"));  //taking valid email from config.properties
	lp.setPassword(rb.getString("password"));//valid  password from config.properties
	lp.ClickLogin();
	 
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetpage= macc.isMyAccountPageExists();
	Assert.assertEquals(targetpage, true);
	//Assert.assertEquals(targetpage, true,"Invalid data");//if it is provided in valid data  the login is failed
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	logger.info("Finished TC_002_LoginTest");
	}
}
        