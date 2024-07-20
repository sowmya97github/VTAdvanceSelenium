package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDatafromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties");
		Properties properties=new Properties();
		
		properties.load(fis);
		
		
		properties.getProperty("username");
		properties.getProperty("Password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(properties.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(properties.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		
		

	}

}
