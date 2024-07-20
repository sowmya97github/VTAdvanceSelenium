package Practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathrevision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=pone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		driver.manage().window().maximize();
		 List<WebElement> PhnName = driver.findElements(By.xpath("//DIV[@CLASS='KzDlHZ']"));
		 List<WebElement> Price = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		 
		 for(int i=0;i<PhnName.size();i++)
		 {
			
			 
			 System.out.println(  PhnName.get(i).getText()+ " " +Price.get(i).getText()  );
		 }

	}

}
