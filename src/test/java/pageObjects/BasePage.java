package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver)//this is the constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this  );
	}

}
