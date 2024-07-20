package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	
	/**
	 * This method is used to maximize the screen
	 * @author Subrahmanya S
	 * @param driver
	 */
	public void maximizingWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

	
	/**
	 * This method is used to wait untill al the Webelements in the page is loaded
	 * @author Subrahmanya S
	 * @param driver
	 */
   public void implicity_Wait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
   
   /**
    * This method is used to switch the windows
    * @author Subrahmanya S
    * @param driver
    * @param expectedTitle
    */
 
   public void windowHandling(WebDriver driver, String expectedTitle ) {
		
	  Set<String> sessionids = driver.getWindowHandles();
		
	  Iterator<String> it = sessionids.iterator();
	  
	  while (it.hasNext()) 
	  {
		String sessinId =  it.next();
		driver.switchTo().window(sessinId);
		String currentTitle=driver.getTitle();
		if(currentTitle.contains(expectedTitle))
		{
		break;
		}

	}
		
	}
   
   /**
    * This method is used to switchto the aler and select ok
    * @author Subrahmanya S
    * @param driver
    */
   public void alertAccept(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   
   public void moveToElement(WebDriver driver,WebElement target)
   {
	   Actions actions=new Actions(driver);
	   actions.moveToElement(target).perform();
	   
   }
   
   public static String  takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException
   {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./Screenshots/"+ScreenShotName+".png");
	FileUtils.copyFile(src, trg);
	return trg.getAbsolutePath();
	
}
}
