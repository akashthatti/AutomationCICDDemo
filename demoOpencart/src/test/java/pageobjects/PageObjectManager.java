package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager 
{
	public WebDriver driver;
	public RegisterObjects reg;
	public LoginObjects logObjects;
	public SearchObjects searchObjects;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public RegisterObjects getRegisterObjects()
	{
		reg = new RegisterObjects(driver);
		return reg;
	}
	
	public LoginObjects getLoginpageObjects()
	{
		logObjects = new LoginObjects(driver);
		return logObjects;
	}
	
	public SearchObjects getSearchPageObjects()
	{
		searchObjects = new SearchObjects(driver);
		return searchObjects;
	}

}
