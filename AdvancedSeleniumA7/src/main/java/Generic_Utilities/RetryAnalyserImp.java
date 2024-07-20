package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		
		int count=0;
		int retryLimit=3;
		
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
	
	
}
