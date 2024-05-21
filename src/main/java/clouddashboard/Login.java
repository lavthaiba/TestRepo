package clouddashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends BaseTest{

	@Test(description="TEST FOR VALID LOGIN")
	
	public void loginValid() {
		
		WebElement emailElement = driver.findElement(By.cssSelector("input[name='emailOrPhone']"));
		emailElement.sendKeys(emailAddress);
		
		WebElement passwordElement = driver.findElement(By.cssSelector("input[name='password']"));
		passwordElement.sendKeys(password);
		
		WebElement loginBtnElement = driver.findElement(By.cssSelector("button[type='submit']"));
		loginBtnElement.click();
		
		
	}
}
