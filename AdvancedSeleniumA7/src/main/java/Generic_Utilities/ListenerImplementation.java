package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.protobuf.ByteString.Output;

public class ListenerImplementation implements ITestListener 

{

	@Override
	public void onTestFailure(ITestResult result) {
		
		Java_Utility utility=new Java_Utility();
		int ranNum=utility.getRandomNum();
	
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./Screenshots/failedss"+ranNum+".png");
		
		try 
		{
			FileUtils.copyFile(src, trg);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
