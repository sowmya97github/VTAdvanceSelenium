package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi.sha256WithSM2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleValuestoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream  fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		 org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet2");
		 
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<links.size();i++)
		{
		sheet.createRow(i).createCell(0).setCellValue(links.get(i).getAttribute("href"));
				
	    }

		FileOutputStream fos=new  FileOutputStream("./src/test/resources/Book1.xlsx");
		wb.write(fos);
	
		
		
	}
}
