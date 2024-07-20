package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class InsertTiExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Sheet1");

LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();

map.put("10", "Sowmya");
map.put("20", "Subrahmanya");
map.put("30", "Uma");
map.put("40", "Rama");

int rownum=0;
for ( Map.Entry<String,String> m: map.entrySet()) 
{
	
		Row row=sheet.createRow(rownum++);
		row.createCell(0).setCellValue((String)m.getKey());
		row.createCell(1).setCellValue((String)m.getValue());
			
	
}

///OR
for (String s: map.keySet())
{
	System.out.println(map.get(s));
	
}

FileOutputStream fos= new FileOutputStream("./src/test/resources/Book1.xlsx");
wb.write(fos);
wb.close();

	}

}
