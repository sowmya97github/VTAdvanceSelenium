package TestNG;
//http:import static org.testng.Assert.expectThrows;

import java.util.Random;

import org.openqa.selenium.By;

//localhost:8888/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 
{
@Test(dataProvider ="getReadData")
	public void createOrganization(String orgNAme,String phnNum,String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgNAme);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);
		driver.quit();
	}

@DataProvider
public Object[][] getReadData()
{
	Object[][] objArr = new Object[3][3];
	Random ran = new Random();
	int ranNum = ran.nextInt(100);
	
	objArr[0][0]="AAA"+ranNum;
	objArr[0][1]="8692626525";
	objArr[0][2]="mailto:abc@gmail.com";
	
	objArr[1][0]="BBB"+ranNum;
	objArr[1][1]="8692626525";
	objArr[1][2]="mailto:psq@gmail.com";
	
	objArr[2][0]="CCC"+ranNum;
	objArr[2][1]="8692626525";
	objArr[2][2]="mailto:xyz@gmail.com";
	
	return objArr;
	
}
	
	
}