package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchObjects 
{
    public WebDriver driver;
    
    public SearchObjects(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    By globalSearch = By.xpath("//div[@class='col-sm-5']/div/input");
    By clickGlobalSearchBtn = By.xpath("//div[@class='col-sm-5']/div/span/button");
    By seconarySearch = By.xpath("//div[@class='col-sm-4']/input");
    By clickOnSecondarySearchBtn = By.xpath("//input[@id='button-search']");
    By selectCategoryDropdown = By.cssSelector("select[name='category_id']");
    By sortByDropdown = By.cssSelector("select[id='input-sort']");
    By productCompareBtn = By.cssSelector("button:nth-child(3)");
    By productCompareHyperlink = By.cssSelector("a[href*='route=product/compare']:nth-child(1)");
    By addToCartBtn = By.cssSelector("div p  a[href*='route=checkout/cart']:nth-child(1)");
    
    public void clickOnAddToCartBtn()
    {
    	driver.findElement(addToCartBtn).click();
    }
    
    public void clickOnProdComparelink()
    {
    	driver.findElement(productCompareHyperlink).click();
    }
    
    
    public void clickOnProductCompareBtn()
    {
    	driver.findElement(productCompareBtn).click();
    }
    
    public void searchProductGlobal(String name)
    {
    	driver.findElement(globalSearch).sendKeys(name);
    }
    
    public void clickOnSearchGbl()
    {
    	driver.findElement(clickGlobalSearchBtn).click();
    }
    
    public void searchProdSecondary(String name)
    {
    	driver.findElement(seconarySearch).sendKeys(name);
    }
    
    public void clickOnSearchSec()
    {
    	driver.findElement(clickOnSecondarySearchBtn).click();
    }
    
    public void selectProductCategory(String value)
    {
    	Select s = new Select(driver.findElement(selectCategoryDropdown));
    	s.selectByValue(value);
    }
    
}
