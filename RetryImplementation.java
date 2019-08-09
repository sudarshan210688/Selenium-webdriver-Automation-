package RND_AdvanceSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RetryImplementation extends RetryLocateWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions Op=new ChromeOptions();
		Op.addArguments("start-maximized");
		driver =new ChromeDriver(Op);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Edit.html");
		RetryLocateWebElements ch=	new RetryLocateWebElements();
	    //ch.typeWithOutretry("id", "email", "sudarshan@gmail.com");
	    //ch.typeWithretry("id", "email", 3, "sudarshan@gmail.com");
	     ch.typeWithretry("id", "email", 3, "sudarshan@gmail.com");     
	    //ch.typeWithOutretry("id", "emails", "sudarshan@gmail.com");
	    //ch.typeWithretry("xpath", "//input[@id='email']", 3, "sas.com");
	   // ch.typeWithretry("xpath", "//input[@id='emails']", 3, "sas.com");
		
	     
		
	}

}
