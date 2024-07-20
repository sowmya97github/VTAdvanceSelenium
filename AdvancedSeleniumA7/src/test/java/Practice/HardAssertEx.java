package Practice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	@Test
	public void m1 ()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(false, true);
		System.out.println("step 3");
	}
	
	@Test
	public void m2 ()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(true, true);
		System.out.println("step 3");
	}
}
