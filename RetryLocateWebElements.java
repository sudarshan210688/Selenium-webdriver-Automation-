package RND_AdvanceSelenium;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RetryLocateWebElements {
	
	/*Find Element Implementation */
    /*public WebElement findElement(SearchContext context)  
      {  
    List<WebElement> allElements = findElements(context);
    if (allElements == null || allElements.isEmpty()) {
      throw new NoSuchElementException("Cannot locate an element using " + toString());
    }
    return allElements.get(0); */
	
	
	public static WebDriver driver;
	public List<WebElement> locateWebelementList(String locator, String locatorValue) {
	  List<WebElement> ele = null;

		switch(locator) 
			{
			case("id"):
				ele=driver.findElements(By.id(locatorValue));
			break;
			case("name"):
				ele=driver.findElements(By.name(locatorValue));
			break;
			case("linkText"):
				ele = driver.findElements(By.linkText(locatorValue));
			break;
			case("xpath"):
				ele = driver.findElements(By.xpath(locatorValue));
			break;
			case("partialLinkText"):
				ele =driver.findElements(By.partialLinkText(locatorValue));
			break;
			case("cssSelector"):
				ele = driver.findElements(By.cssSelector(locatorValue));
			break;
			case("tagName"):
				ele = driver.findElements(By.tagName(locatorValue));
			break;
			case("className"):
				ele = driver.findElements(By.className(locatorValue));
			break;
			default:
				System.out.println("The given locator "+locator+" is not correct");
				break;
			
	} 
		
		 return ele;
	}  
	
	
	public   WebElement RetryWebElements(String locator,String locatorValue,int retryValue)
       {
    	   
		List<WebElement> eleList = locateWebelementList(locator, locatorValue);
    	   
	    int retry=1;
		
		for(int i=1;i<=retry;i++)
		{
		if(eleList.size() > 0)
			{
				
				System.out.println("The Web Element is found without any retry and Element value is  "+eleList.get(0));
				
			}
			
		
		else if (eleList.size()==0 && retry<=retryValue)
				{
				  
					try {
						System.out.println("Retrying to Locate Element");
						  eleList.get(0);
						  retry++;
						  
					} catch (Exception e) {
						
						System.out.println("Element not found and retry attempt is " +retry++);
					}
				
			}
				
				else
				{
					
					throw new NoSuchElementException("Invalid  Locator--> "  +locator+ "  with value "+locatorValue);
				}
}
			
		return eleList.get(0);

	    
}
	
	
	
public  void typeWithretry(String locator,String locatorValue,int retryValue,String value) 
	
	{
		
		RetryWebElements(locator, locatorValue, retryValue).sendKeys(value);
	}

	
public WebElement locateWebelementWithoutRetry(String locator, String locatorValue) {
		  List<WebElement> ele = null;

	
				switch(locator) 
					{
					case("id"):
						ele=driver.findElements(By.id(locatorValue));
					
					break;
					case("name"):
						ele=driver.findElements(By.name(locatorValue));
					break;
					case("linkText"):
						ele = driver.findElements(By.linkText(locatorValue));
					break;
					case("xpath"):
						ele = driver.findElements(By.xpath(locatorValue));
					break;
					case("partialLinkText"):
						ele =driver.findElements(By.partialLinkText(locatorValue));
					break;
					case("cssSelector"):
						ele = driver.findElements(By.cssSelector(locatorValue));
					break;
					case("tagName"):
						ele = driver.findElements(By.tagName(locatorValue));
					break;
					case("className"):
						ele = driver.findElements(By.className(locatorValue));
					break;
					default:
						System.out.println("The given locator "+locator+" is not correct");
						break;
					
}
			
				try {
				return ele.get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new NoSuchElementException("Invalid Locator--> "  +locator+ "  with value "+locatorValue);
			}
		}  
		
	
public  void typeWithOutretry(String locator,String locatorValue,String value) 

{
	
	locateWebelementWithoutRetry(locator, locatorValue).sendKeys(value);
}




}



	

	
    
