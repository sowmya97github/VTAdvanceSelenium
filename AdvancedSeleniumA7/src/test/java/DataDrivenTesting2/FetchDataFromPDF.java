package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;

public class FetchDataFromPDF {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis= new FileInputStream("src/test/resources/SOWMYA_CM_Resume (1).pdf"); 

	PDDocument doc=	PDDocument.load(fis);
	
	int pages = doc.getNumberOfPages();
	System.out.println(pages);//reads number of pages 
	
	PDFTextStripper pdfdata=new PDFTextStripper();
	System.out.println(pdfdata.getText(doc));//prints all data from pdf
	
	//--------------------------------------------------------------------------------
	
	pdfdata.setStartPage(1);
	System.out.println(pdfdata.getText(doc));//reads from page 1
	
	//--------------------------------------------------------------------------------
	
	pdfdata.setStartPage(1);
	pdfdata.setEndPage(2);
	System.out.println(pdfdata.getText(doc));//reads from page 1 to 2
	
	
	
	}

}
