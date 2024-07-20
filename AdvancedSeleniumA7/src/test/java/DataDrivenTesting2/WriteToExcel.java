package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis= new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		wb.getSheet("Sheet1").createRow(0).createCell(0).setCellValue("Subrahmanya");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Book1.xlsx");
		
		wb.write(fos);
		
		

	}

}
