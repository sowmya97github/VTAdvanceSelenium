package DataDrivenTesting2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;


public class InsertDataUsingDBTest extends BaseClass {

	@Test
	public  void InsertDataUsingDBTest() throws Throwable {

Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "sowmya");
		
	Statement state = conn.createStatement();

	String query = "insert into STUDENTS(ID,FIRST_NAME,LAST_NAME,ADDRESS)values(5,'Ram','sam','Goa')";
	
	 int result = state.executeUpdate(query);
	
	 if(result==1)
	 {
		 System.out.println("Data is updated");
	 }
	 else
	 {
		 System.out.println("Data not updated");
	 }
	
//	conn.close();
	
}

}

