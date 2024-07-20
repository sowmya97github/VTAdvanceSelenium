package DataDrivenTesting2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;

public class FetchDataFromDataBaseTest extends BaseClass {

	@Test
	public  void FetchDataFromDataBaseTest() throws Throwable {
		
		//Step1:- Register/ load the mysql database
		//Driver driverRef = new Driver();
		//DriverManager.registerDriver(driverRef);
		
		//step2:-get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root" ,"sowmya");

		//step3:- create Sql statement
		Statement state = conn.createStatement();
		String query = "select * from students";
		
		//step4:- execute statement/query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//step5:- close the connection.
		//conn.close();
		}
	}
