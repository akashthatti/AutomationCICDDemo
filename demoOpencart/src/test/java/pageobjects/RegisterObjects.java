package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterObjects 
{
	public WebDriver driver;
	
	public RegisterObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By warningMessages = By.cssSelector("div.text-danger"); 
	By myAccountBtn = By.xpath("//span[text()='My Account']");
    By registerBtn = By.xpath("//a[text()='Register']");
	By firstName = By.id("input-firstname");
	By lastName = By.name("lastname");
	By emailId = By.xpath("//input[@type='email']");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPass = By.id("input-confirm");
    By policyCbox = By.xpath("//input[@type='checkbox']");
    By continueBtn = By.xpath("//input[@value='Continue']");
   
   
   public void clickOnMyAccount()
   {
	   driver.findElement(myAccountBtn).click();
   }
   
   public void clickOnRegBtn()
   {
	   driver.findElement(registerBtn).click();
   }
   
   public void enterFirstName(String fname)
   {
	   driver.findElement(firstName).sendKeys(fname);
   }
   
  
   
   public void enterLastName(String lname)
   {
	   driver.findElement(lastName).sendKeys(lname);
   }
   
   
   
   public void enterEmail(String mail)
   {
	   driver.findElement(emailId).sendKeys(mail);
	   
   }
   
   public void enterTeleNum(String tnum)
   {
	   driver.findElement(telephone).sendKeys(tnum);
   }
   
   public void enterPass(String pass)
   {
	   driver.findElement(password).sendKeys(pass);
   }
   
   public void confirmPass(String cpass)
   {
	   driver.findElement(confirmPass).sendKeys(cpass);
   }
   
   public void clickOnPolicyCbox()
   {
	   driver.findElement(policyCbox).click();
   }
   
   public void clickOnContinue()
   {
	   driver.findElement(continueBtn).click();
   }
   
   public List<WebElement> getWarningMsg()
   {
	   return driver.findElements(warningMessages);
   }
   

}
