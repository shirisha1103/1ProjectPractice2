package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regresssion", "Master" })
	public void test_account_Registration() {
		logger.info("starting TC_001_AccountRegistationTest");
		try {
			HomePage hp = new HomePage(driver);// here driver is coming from BaseClass
			hp.ClickMyAccount();
			logger.info("clicked on MyAccount link");
			hp.ClickRegister();
			logger.info("clicked on registered link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("providing customer data");
			regpage.setFirstName("abc");

			// regpage.setFirstName(randomString().toUpperCase());//this will generate
			// random name and convert to uppercase

			regpage.setLastName("xyz");

			regpage.setEmail("abcxyz@gmail.com");

			regpage.setEmail(randomAlphaNumeric() + "@gmail.com");// randomly generated the mail

			regpage.setpassword("test@123");

			regpage.setPolicy();

			regpage.clickContinue();
			logger.info("clicked on continue button");

			String confmsg = regpage.getConfirmationMsg();
			logger.info("validating expected msg");
			Assert.assertEquals(confmsg, "your Account has been created");// Actual validation

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("finished the registration");
	}
}
