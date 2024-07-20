package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class File_Utility {
	
	public String getKeyAndValuePair(String key) throws IOException
	{
	FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
	Properties pro = new Properties();
	
	pro.load(fis);
	
	String value= pro.getProperty(key);
	return value;
	
	}
	

}
