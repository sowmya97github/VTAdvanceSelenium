package Campaigns;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import Object_Repository.CreateCampaignPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

@Listeners(Generic_Utilities.ListenerImplementation.class)
public class MultipleTestCases extends BaseClass {

	//@Test(groups = "smokeTest")
	public  void CreateCampaignsTest() throws Throwable {
        
             
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
		
		int ranNum = jlib.getRandomNum();
		
        String campData = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	     campPage.enterCampaignName(campData);
	     Assert.fail();
	     campPage.clickOnSaveButton();
	


	}



	
	@Test(groups = "smokeTest")
	public  void CreateCamTest() throws Throwable {
        
             
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
        Assert.fail();
		
		int ranNum = jlib.getRandomNum();
		
        String campData = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	     campPage.enterCampaignName(campData);
	     campPage.clickOnSaveButton();
	
	     String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		    System.out.println(actData);
		    Thread.sleep(2000);
	       Assert.assertEquals(actData, campData);

	       
	       //----------Soft Assert-------------
	       
		    //SoftAssert assert1=new SoftAssert();
		   // assert1.assertEquals("omg", actData, "dingdong bell");
		    //assert1.assertAll();

	}
}
