package DataDrivenTesting2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataToPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/propertyfile.properties");
		Properties properties=new Properties();
		properties.load(fis);
		
		properties.setProperty("url", "https://www.saucedemo.com/v1/");
		properties.setProperty("username", "standard_user");
		properties.setProperty("password", "secret_sauce");
		
		FileOutputStream  fos=new FileOutputStream("./src/test/resources/propertyfile.properties"); 
		properties.store(fos, "Commondata");

	}

}
