package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;

public class TestBase 
{
public WebDriver driver;


public WebDriver WebdriverManager() throws IOException, InterruptedException
{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(new File("C:\\Users\\admin\\eclipse-workspace\\demoOpencart\\src\\test\\resources\\globall.properties"));
	prop.load(fis);
	String url = prop.getProperty("url");
	String browser_name = prop.getProperty("browser");
	String browser_maven = System.getProperty("browser");
	
	String browser = browser_maven!=null?browser_maven:browser_name;
	if(driver==null)
	{
		if(browser.equalsIgnoreCase("chrome"))
	    {
	String key = "webdriver.chrome.driver";
	String value = "E:\\Desktop backup\\New folder\\chromedriver_win32 (5)\\chromedriver.exe";
	System.setProperty(key, value);
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(10000);	    }
	}
	return driver;
}
	
}
