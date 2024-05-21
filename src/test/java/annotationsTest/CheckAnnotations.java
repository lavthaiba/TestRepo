package annotationsTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckAnnotations {

	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("I am Before Method");
	}
	
	@Test(priority=30)
	public void test1() {
		
		System.out.println("I am test 1");
	}
	
	@Test(priority=20)
	public void test2() {
		
	 System.out.println("I am test 2");
	}
	
	@Test(priority=1,description="Important test case for validating")
	public void test3() {
		
		System.out.println("I am test 3");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am After Method");
	}
}
