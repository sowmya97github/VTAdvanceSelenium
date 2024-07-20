package TestNG;

import org.testng.annotations.Test;

public class TestNGEx1Test {
	
	@Test(invocationCount = 2)
	public void createContactTest() {
		System.out.println("Contact created");
	}

	@Test(dependsOnMethods = "createContactTest", enabled = false)
	public void modifyContactTest() {
		System.out.println("modify created");
	}


	@Test(dependsOnMethods = "createContactTest")
	public void deleteContactTest() {
		System.out.println("delete created");
	}


}
