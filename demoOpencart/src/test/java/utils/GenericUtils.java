package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericUtils 
{
public WebDriver driver;
public String productsLocator = "//div[@class='product-thumb']/div/div/h4";
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void copyTextFromPasswordField(WebElement ele1, WebElement ele2)
	{
		Actions action = new Actions(driver);
		action.moveToElement(ele1).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		action.moveToElement(ele2).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
	}
	
	public String getProduct(String productName)
	{
		List<WebElement> products = driver.findElements(By.xpath(productsLocator));
		String name = null;
		for(int i=0;i<products.size();i++)
		{
			name = products.get(i).getText();
			if(name.equalsIgnoreCase(productName))
			{
				break;
			}
			
		}
		return name;
	}

}
