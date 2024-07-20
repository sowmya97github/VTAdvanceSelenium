package DataDrivenTesting2;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		DataFormatter data=new DataFormatter();	
		System.out.println(sheet.getLastRowNum());
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
		Cell cell = sheet.getRow(i).getCell(0);
		
		System.out.println(data.formatCellValue(cell));
		}
		
		
	}

}
