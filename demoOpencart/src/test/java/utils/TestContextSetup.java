package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import pageobjects.PageObjectManager;


public class TestContextSetup
{
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public String productsLocator = "//div[@class='product-thumb']/div/div/h4";
	

	
	public TestContextSetup() throws IOException, InterruptedException
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebdriverManager());
		genericUtils = new GenericUtils(testBase.WebdriverManager());
	}
}
