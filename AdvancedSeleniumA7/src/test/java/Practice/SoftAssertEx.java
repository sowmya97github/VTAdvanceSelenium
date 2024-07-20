package Practice;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void m1 ()
	{
		
		System.out.println("step 1");
		System.out.println("step 2");
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(false, true);
		System.out.println("step 3");
		assert1.assertAll();
	}
	
	@Test
	public void m2 ()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(true, true);
		System.out.println("step 3");
		assert1.assertAll();
	}
}
