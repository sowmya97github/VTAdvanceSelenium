package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener
{
ExtentReports report;
ExtentTest test;


@Override
public void onTestStart(ITestResult result) 
{
	test=report.createTest(result.getMethod().getMethodName());
}


@Override
public void onTestSuccess(ITestResult result) 
{
	test.log(Status.PASS, result.getMethod().getMethodName());
	test.log(Status.PASS, result.getThrowable());
}


@Override
public void onTestFailure(ITestResult result) {
	
	test.log(Status.FAIL, result.getMethod().getMethodName());
	test.log(Status.FAIL, result.getThrowable());
	System.out.println("i am taking screenshot");
	String screenShot= null;
	
	try 
	{
		screenShot=WebDriver_Utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(screenShot);
}


@Override
public void onTestSkipped(ITestResult result) 
{
	test.log(Status.SKIP, result.getMethod().getMethodName());
	test.log(Status.SKIP, result.getThrowable());
}


@Override
public void onStart(ITestContext context) {
	
	Java_Utility utility=new Java_Utility();
	int ranNum=utility.getRandomNum();
	ExtentSparkReporter spark= new ExtentSparkReporter("ExtentsReportFile/Report"+ranNum+".html");
	spark.config().setTheme(Theme.STANDARD);
	spark.config().setDocumentTitle("Automationtesting");
	spark.config().setReportName("Sowmya");
	
	report=new ExtentReports();
	
	report.attachReporter(spark);
	report.setSystemInfo("platform", "windows");
	report.setSystemInfo("executed by", "Sowmya");
	report.setSystemInfo("reviewed by", "Ram");
	
	
	
}


@Override
public void onFinish(ITestContext context) {
	report.flush();
}






}
