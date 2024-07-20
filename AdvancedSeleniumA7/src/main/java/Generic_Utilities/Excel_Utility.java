package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream("C:\\\\\\\\Users\\\\\\\\Subrahmanya S\\\\\\\\Documents\\\\\\\\Booklet1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		
		DataFormatter data=new DataFormatter();
		
		 Cell cell=workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		 String excelData =data.formatCellValue(cell);
		 return excelData;
		
	}
	
	public Object[][] readSataFromExcelusingDataProvider(String sheetName) throws EncryptedDocumentException, IOException 
	{
		Object[][] objArr = new Object[3][3];
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		
		FileInputStream fis= new FileInputStream("C:\\\\\\\\Users\\\\\\\\Subrahmanya S\\\\\\\\Documents\\\\\\\\Booklet1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		
		int lastrow=workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		
		DataFormatter data=new DataFormatter();
		
		
		for(int i=0;i<lastrow;i++)
		{
			int lastcell=workbook.getSheet(sheetName).getRow(i).getPhysicalNumberOfCells();
			for(int j=0;j<lastcell;j++)
			{
				
				DataFormatter dataFormatter=new DataFormatter();
			    Cell cell=workbook.getSheet("Organization").getRow(i).getCell(j);
			    String excelData =data.formatCellValue(cell);
				objArr[i][j]=excelData;
				
			}
		}
		 
		 return objArr;
		
	}
}