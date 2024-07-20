package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.VtigerHomePage;

public class CreateProductTest extends BaseClass {

	@Test(groups = {"sanityTest","smokeTest"})
	public  void CreateProductTest() throws Throwable {
	

				
		driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
        
        int ranNum = jlib.getRandomNum();
       String prdData = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		
        driver.findElement(By.name("productname")).sendKeys(prdData);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
				
	}

}
