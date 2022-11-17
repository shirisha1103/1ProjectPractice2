package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC_003_LoginDDT extends BaseClass {

	//@Test(dataProvider="LoginData")//if we have data provider in same class use this method 
	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)//if the data provider is in other class use this method
	public void test_loginDDT(String email,String password,String exp) 
	{
		
		logger.info("Staring TC_003_LoginDDT");
		try
		{
		
		HomePage hp=new HomePage(driver);	
		hp.ClickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);  //taking data email from dataproviders
		lp.setPassword(password);//taking  password from dataproviders
		lp.ClickLogin();
		 
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage= macc.isMyAccountPageExists();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout(); // to take another data from dataprovider we should logout
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		if (exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
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
		logger.info("finished the TC_003_LoginDDT");
		
	}
}
