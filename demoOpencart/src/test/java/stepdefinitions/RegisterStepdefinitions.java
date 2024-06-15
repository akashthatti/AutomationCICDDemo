package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.RegisterObjects;
import utils.TestContextSetup;


public class RegisterStepdefinitions 
{
	
	
	TestContextSetup testContextSetup;
	public RegisterObjects regObjects;
                 //change
	
	public RegisterStepdefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.regObjects = testContextSetup.pageObjectManager.getRegisterObjects();
	}
	
	
	
	
	@Given("user lands on the website")
	public void user_lands_on_the_website() 
	{
		System.out.println("landed");	
	}
	
	@When("user clicks on the myAccount dropmenu and clicks on register option")
	public void user_clicks_on_the_my_account_dropmenu_and_clicks_on_register_option() 
	{
	    regObjects.clickOnMyAccount();
	    regObjects.clickOnRegBtn();
	}
	
	@And("user enters all mandatory details and click on continue button")
	public void user_enters_all_mandatory_details_and_click_on_continue_button() 
	{
		regObjects.enterFirstName("Test");
		regObjects.enterLastName("Auto");
	    regObjects.enterEmail("testayyyo@gmil.com");
	    regObjects.enterTeleNum("675000");
	    regObjects.enterPass("cfd324ds");
	    regObjects.confirmPass("cfd324ds");
	    regObjects.clickOnPolicyCbox();
	    regObjects.clickOnContinue();
	}
	@Then("Account success message should be displayed")
	public void account_success_message_should_be_displayed() 
	{
		Assert.assertEquals(testContextSetup.driver.findElement(By.tagName("h1")).getText(),"Your Account Has Been Created!");
	}
	
	@And("clicks on continue button without providing mandatory details")
	public void clicks_on_continue_button_without_providing_mandatory_details() 
	{
	   regObjects.clickOnContinue();
	}
	
	@Then("error messages should be displayed for mandatory fields")
	public void error_messages_should_be_displayed_for_mandatory_fields() 
	{
	   List<WebElement> msg = regObjects.getWarningMsg();
	   Assert.assertEquals(msg.get(0).getText(),"First Name must be between 1 and 32 characters!");
	   Assert.assertEquals(msg.get(1).getText(),"Last Name must be between 1 and 32 characters!");
	   Assert.assertEquals(msg.get(2).getText(),"E-Mail Address does not appear to be valid!");
	   Assert.assertEquals(msg.get(3).getText(),"Telephone must be between 3 and 32 characters!");
	   Assert.assertEquals(msg.get(4).getText(),"Password must be between 4 and 20 characters!");
	}
	
	@And("user enters all mandatory details but enters different passwords in password and confirm password fields and click on continue button")
	public void user_enters_all_mandatory_details_but_enters_different_passwords_in_password_and_confirm_password_fields_and_click_on_continue_button() 
	{
		regObjects.enterFirstName("Test");
		regObjects.enterLastName("Autoo");
	    regObjects.enterEmail("testayyo@gmil.com");
	    regObjects.enterTeleNum("675000");
	    regObjects.enterPass("cfd324ds");
	    regObjects.confirmPass("cfd324d");
	    regObjects.clickOnPolicyCbox();
	    regObjects.clickOnContinue();
	}
	
	@Then("Warning message is displayed")
	public void warning_is_displayed() 
	{
		List<WebElement> msg = regObjects.getWarningMsg();
		Assert.assertEquals(msg.get(0).getText(),"Password confirmation does not match password!");
	}
	
	@Then("proper placeholders should be displayed for all mandatory fields")
	public void proper_placeholders_should_be_displayed_for_all_mandatory_fields() 
	{
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),"First Name");
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.name("lastname")).getAttribute("placeholder"),"Last Name");
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.xpath("//input[@type='email']")).getAttribute("placeholder"),"E-Mail");
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),"Telephone");
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.id("input-password")).getAttribute("placeholder"),"Password");
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),"Password Confirm");
	}
	
	
}
