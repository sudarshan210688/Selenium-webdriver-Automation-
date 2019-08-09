package RND_AdvanceSelenium;



import java.util.logging.Level;

import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PageLoadTime {
	
	
	@Test
	public void LoadTime()
	{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("start-maximized");
		op.addArguments("--blink-settings=imagesEnabled=false");
	    ChromeDriver driver =new ChromeDriver(op);
	    StopWatch loadTime = new StopWatch();
		loadTime.start();
		driver.get("https://www.amazon.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("Amazon.com"));
		loadTime.stop();
		long time = loadTime.getTime();
		long timeInseconds=time/1000;
		System.err.println("Time taken to Load Web Page for the First time " +timeInseconds);
	
		
		
	}

}
//op.addArguments("--blink-settings=imagesEnabled=false");
//op.setPageLoadStrategy(PageLoadStrategy.NONE);
//op.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//Network Conditions--chrome 
//Performance Monitor
