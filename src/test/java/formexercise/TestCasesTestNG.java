package formexercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCasesTestNG {

	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before method executed!");
	}
	
	@Test
	public void sayHello() {
		
		System.out.println("Hello");
	}
	
	@Test
	public void sayGoodBye() {
		
		System.out.println("Good Bye");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method executed!");
	}
}

class TestCasesTestNG1 {
	
	@BeforeMethod
	public void beforeMethod1() {
		
		System.out.println("Before method executed!-1");
	}
	
	@Test(priority=1)
	public void sayHello1() {
		
		System.out.println("Hello-1");
	}
	
	@Test
	public void sayGoodBye1() {
		
		System.out.println("Good Bye-1");
	}
	
	@AfterMethod
	public void afterMethod1() {
		System.out.println("After method executed!-1");
	}
	
}
class TestCasesTestNG2 {
		
		@BeforeMethod
		public void beforeMethod2() {
			
			System.out.println("Before method executed!-2");
		}
		
		@Test
		public void sayHello2() {
			
			System.out.println("Hello-2");
		}
		
		@Test
		public void sayGoodBye1() {
			
			System.out.println("Good Bye-2");
		}
		
		@AfterMethod
		public void afterMethod1() {
			System.out.println("After method executed!-2");
		}
}
