package Generic_Utilities;

import java.util.Date;
import java.util.Random;

import org.apache.commons.compress.harmony.pack200.NewAttribute;

public class Java_Utility {
//1st pull
	/**
	 * 
	 * This method is used to generate unique number , to avoid duplicates
	 * @author Sowmya
	 * @return
	 */
	
	public int getRandomNum()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		return  randomNumber;
	}

	/**
	 * This method is used to get System date and Time
	 * @author Subrahmanya S
	 * @return
	 */
    public String getSystemDateandTime() 
    {
    	
		Date date=new Date();
		String DateAndTime=date.toString();
		return DateAndTime;
				
	}

    /**
     * This method is used to get system date in the formar YYYY-MM-DD
     * @author Subrahmanya S
     * @return
     */
    public String getFormattedSystemDate() 
    {
		Date date=new Date();
		String DateAndTime=date.toString();
		String[] dd = DateAndTime.split(" ");
		String YYYY=dd[5];
		String DD=dd[2];
		int MM=date.getMonth()+1;	
		String FormattedSystemDate=YYYY+"-"+MM+"-"+DD;
		return FormattedSystemDate;
	}

}

