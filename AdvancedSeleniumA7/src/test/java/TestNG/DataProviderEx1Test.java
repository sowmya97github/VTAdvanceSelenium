package TestNG;

import java.awt.print.Book;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1Test {
	
	@Test(dataProvider = "getData")
	public void bookTicketsTest(String src, String dest,int numOfpeople)
	{
	//	System.out.println("Book ticketsBook from " +src+" to "+dest+" for " +numOfpeople+" people");
		System.out.println("Book ticketsBook from " +src);

	}


@DataProvider
public Object[][] getData()
{
	
	Object arrr[][]=new Object[3][3];
	
	arrr[0][0]="Banglore";
	arrr[0][1]="Goa";
	arrr[0][2]="2";
	
	arrr[1][0]="Banglore";
	arrr[1][1]="Goa";
	arrr[1][2]="2";
	
	
	arrr[2][0]="Banglore";
	arrr[2][1]="Goa";
	arrr[2][2]="2";
	
	return arrr;
	
	/*int count=0;
	for(int i=0;i<arrr.length-1;i++)
	{
		for(int j=0;j<arrr.length-1;j++)
		{
			arrr[i][j]= count;
			count++;
		}
	}*/
	
}

}