package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SearchObjects;
import utils.TestContextSetup;

public class SearchStepdefinitions 
{
	TestContextSetup testContextSetup;
	public SearchObjects searchObj;
	
	public SearchStepdefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.searchObj = testContextSetup.pageObjectManager.getSearchPageObjects();
	}
	
	@Given("users is on the landing page")
	public void users_is_on_the_landing_page() throws InterruptedException 
	{
		Thread.sleep(3000);
	    Assert.assertEquals(testContextSetup.testBase.driver.getTitle(),"Your Store");
	}
	
	@When("user enters the existing product name and clicks on search")
	public void user_enters_the_existing_product_name_and_clicks_on_search() 
	{
	    searchObj.searchProductGlobal("imac");
	    searchObj.clickOnSearchGbl();
	}
	
	@Then("product should be displayed")
	public void product_should_be_displayed() throws InterruptedException 
	{
		Thread.sleep(2000);
	   String product= testContextSetup.genericUtils.getProduct("imac");
	   Assert.assertEquals(product,"iMac");
	}
	
	@When("user enters the non existing product name and clicks on search")
	public void user_enters_the_non_existing_product_name_and_clicks_on_search() throws InterruptedException 
	{
	   searchObj.searchProductGlobal("fitBit");
	   Thread.sleep(2000);
	   searchObj.clickOnSearchGbl();
	}
	
	@Then("There is no product that matches the search criteria. message should be displayed")
	public void there_is_no_product_that_matches_the_search_criteria_message_should_be_displayed() 
	{
	   Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.xpath("(//p)[3]")).getText(),"There is no product that matches the search criteria.");
	}
	
	@When("user doesnt enter anything on search field and click on search button")
	public void user_doesnt_enter_anything_on_search_field_and_click_on_search_button() 
	{
	   searchObj.clickOnSearchGbl();
	}
	
	@And("searches using search criteria search box and selects correct option in cateogory dropdown")
	public void searches_using_search_criteria_search_box_and_selects_correct_option_in_cateogory_dropdown() throws InterruptedException 
	{
	    searchObj.searchProdSecondary("imac");
	    Thread.sleep(2000);
	    searchObj.selectProductCategory("27");
	    searchObj.clickOnSearchSec();
	    Thread.sleep(2000);
	}
	
	@Then("product should be successfully displayed")
	public void product_should_be_successfully_displayed() 
	{
		String product= testContextSetup.genericUtils.getProduct("iMac");
		if(product.equalsIgnoreCase("iMac"))
		{
			Assert.assertTrue(true);
		}
	}
	
	@Then("clicks on compare product option and user should be navigated to product compare page")
	public void clicks_on_compare_product_option_and_user_should_be_navigated_to_product_compare_page() throws InterruptedException 
	{
	    searchObj.clickOnProductCompareBtn();
	    Assert.assertEquals(testContextSetup.testBase.driver.findElement(By.xpath("//button[@data-original-title='Compare this Product']")).getText(),"Compare this Prdouct");    
	    searchObj.clickOnProdComparelink();
	    Thread.sleep(3000);
	    Assert.assertEquals(testContextSetup.testBase.driver.getTitle(),"Product Comparison");
	}

}
