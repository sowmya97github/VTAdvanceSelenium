package Generic_Utilities;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mysql.jdbc.Driver;

import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {
	
	public File_Utility flib = new File_Utility();	
	public Java_Utility jlib = new  Java_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public  WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"sanityTest","smokeTest"})
	public void BS() throws SQLException
	{
        Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		System.out.println("DataBase connection opened");
	}

	@BeforeTest(groups = {"sanityTest","smokeTest"})
	public void BT()
	{
		System.out.println("parallel execution start");
	}
	
	//@Parameters ({"BROWSER"})
	@BeforeClass(groups = {"sanityTest","smokeTest"})
	public void BC() throws IOException
	{
		
		File_Utility flib=new File_Utility();
		       
        String BROWSER = flib.getKeyAndValuePair("browser");
          if(BROWSER.equalsIgnoreCase("chrome"))
          {
         	 driver=new ChromeDriver();
          }
          else
          {
          if(BROWSER.equalsIgnoreCase("edge"))
         	 {
         		 driver=new EdgeDriver();
         	 }
        	 else
         	 {
         if(BROWSER.equalsIgnoreCase("firefox"))
         		{
         			driver=new FirefoxDriver();
         		}
         else
         		{
         			driver=new ChromeDriver();
         		}
         	 }
          }

           sDriver=driver;
	}
	
	//@Parameters ({"USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"sanityTest","smokeTest"})
	public void BM() throws IOException
	{
		wlib.maximizingWindow(driver);
		wlib.implicity_Wait(driver);
		
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME =flib.getKeyAndValuePair("username");
    	String PASSWORD = flib.getKeyAndValuePair("password");
    	driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		System.out.println("Login to the application succesfull");
	}
	
	@AfterMethod(groups = {"sanityTest","smokeTest"})
	public void AM()
	{
	
		VtigerHomePage home=new VtigerHomePage(driver);
		home.logOut(driver);
		System.out.println("Logout to the application succesfull");
	}
	
	@AfterClass(groups = {"sanityTest","smokeTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterTest(groups = {"sanityTest","smokeTest"})
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	
	
	@AfterSuite(groups = {"sanityTest","smokeTest"})
	public void AS() throws SQLException
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "sowmya");
		conn.close();
		System.out.println("Database connection closed");
	}
}
