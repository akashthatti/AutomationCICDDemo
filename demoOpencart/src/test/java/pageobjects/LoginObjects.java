package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects 
{
	public WebDriver driver;
	
	public LoginObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By MyAccountMenu = By.xpath("//span[text()='My Account']");
	By loginOption = By.xpath("//a[text()='Login']");
	By emailIdField = By.id("input-email");
	By inputPassword = By.id("input-password");
	By forgetPassword = By.xpath("//a[text()='Forgotten Password']");
	By loginBtn = By.xpath("//input[@value='Login']");
	By warningMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	
	public boolean isEmailFieldEmpty()
	{
		String text = driver.findElement(emailIdField).getText();
		return text.isEmpty();
	}
	public WebElement returnPasswordEle()
	{
		return driver.findElement(inputPassword);
	}
	public WebElement returnEmailEle()
	{
		return driver.findElement(emailIdField);
	}
	public void clickOnMyAccount()
	{
		driver.findElement(MyAccountMenu).click();
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginOption).click();
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailIdField).sendKeys(email);
	}
	
	public void enterPssword(String password)
	{
		driver.findElement(inputPassword).sendKeys(password);
	}
	
	public void forgetPssword()
	{
		driver.findElement(forgetPassword).click();
	}
	
	public void loginBtnClick()
	{
		driver.findElement(loginBtn).click();
	}
	
	public String getWarningMessage()
	{
		return driver.findElement(warningMsg).getText();
	}
	
	

}
