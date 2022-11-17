package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	 
	public  HomePage(WebDriver driver)
	{
		super (driver);
	}
	
	//Elements
	
	@FindBy(xpath="//span[normalize-space()='My Account']")//"//span[text()='my Account']")
	WebElement linkMyAccount;	
	
	@FindBy(xpath="//a[normalize-space()='Register']")//(linkText="Register")
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")//login link added  step6
	WebElement linkLogin;
	
	//Action Methods
	
	public void ClickMyAccount()
	{
		linkMyAccount.click();
	}
	
	
	public void ClickRegister()
	{
		linkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	

}
