package DataDrivenTesting2;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJsonFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Jsonfile.json");
		
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode data = objectMapper.readTree(fis);
		
		String url = data.get("url").asText();
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);

	}

}
