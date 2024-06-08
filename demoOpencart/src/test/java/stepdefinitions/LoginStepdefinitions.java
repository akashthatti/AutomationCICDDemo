package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginObjects;
import utils.TestContextSetup;

public class LoginStepdefinitions 
{
	TestContextSetup testContextSetup;
	public LoginObjects logObj;
	
	public LoginStepdefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.logObj = testContextSetup.pageObjectManager.getLoginpageObjects();
	}
	
	@Given("user is on the landing page")
	public void user_is_on_the_landing_page() 
	{
	    System.out.println("landed");
	}
	
	@When("user click on my account dropmenu and clicks on login option")
	public void user_click_on_my_account_dropmenu_and_clicks_on_login_option() 
	{
	   logObj.clickOnMyAccount();
	   logObj.clickOnLogin();
	}
	
	@And("enters valid username and password and clicks on login")
	public void enters_valid_username_and_password_and_clicks_on_login() 
	{
	    logObj.enterEmail("testayyyo@gmil.com");
	    logObj.enterPssword("cfd324ds");
	    logObj.loginBtnClick();
	}
	
	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() 
	{
	   Assert.assertEquals(testContextSetup.testBase.driver.getTitle(),"My Account");
	}
	
	@And("user enters invalid username and password and clicks on login")
	public void user_enters_invalid_username_and_password_and_clicks_on_login() 
	{
	   logObj.enterEmail("hgc@gmail.com");
	   logObj.enterPssword("9796");
	   logObj.loginBtnClick();
	}
	
	@Then("Warning message should be displayed")
	public void Warning_message_should_be_displayed()
	{
		Assert.assertEquals(logObj.getWarningMessage(),"Warning: No match for E-Mail Address and/or Password.");
	}
	
	@And("forgotten password link should be visible")
	public void forgotten_password_link_should_be_visible()
	{
		Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.xpath("//a[text()='Forgotten Password']")).isDisplayed(),true);
		
	}
	
	@Then("when clicked on forgotten password link forgot your password page should open")
	public void when_clicked_on_forgotten_password_link_forgot_your_password_page_should_open()
	{
		logObj.forgetPssword();
		Assert.assertEquals(testContextSetup.testBase.driver.getTitle(),"Forgot Your Password?");	
	}
	
	@And("enters the password and copies it")
	public void enters_the_password_and_copies_it() 
	{
		
	    testContextSetup.genericUtils.copyTextFromPasswordField(logObj.returnPasswordEle(),logObj.returnEmailEle());
	}
	
	@Then("password should not be copied")
	public void password_should_not_be_copied() 
	{
	   Assert.assertEquals(logObj.isEmailFieldEmpty(), true);
	}
	

}
