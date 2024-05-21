package formexercise;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class CreateForm {  
	
	
	
	
	
	@Test(priority=10)
	public void checkRegisterAndLoginFlow() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get("file:///D:/cabtmDashboardAutomation/testSelenium/MyLoginPage/FormExercise.html");
		
		// Enter valid registration details
		WebElement nameInput = chrome.findElement(By.id("name"));
		nameInput.sendKeys("QA Instructor");
		
		WebElement emailInput = chrome.findElement(By.id("email"));
		emailInput.sendKeys("info@vrittechnologies.com");
		
		WebElement passwordInput = chrome.findElement(By.id("password"));
		passwordInput.sendKeys("password123");
		
		WebElement confirmPasswordInput = chrome.findElement(By.id("confirm-password"));
		confirmPasswordInput.sendKeys("password123");
		
		// Click on the Register button
		WebElement registerButton = chrome.findElement(By.id("register-btn"));
		registerButton.click();
		Thread.sleep(5000);
		
		/*
		 * WebElement actualElement = chrome.findElement(By.id("success-message"));
		 * String actualMessage = actualElement.getText();
		 */
		/*
		 * if(actualMessage.equals("Registration successfulll")) {
		 * System.out.println("Registration successful validated !"); }else {
		 * System.out.println("Typo issue!"); }
		 */
		 
		
		  // Validate success message Thread.sleep(2000); // Wait for success message to appear 
		  WebElement actualElement = chrome.findElement(By.id("success-message")); 
		  String actualMessage = actualElement.getText(); 
		  String expectedMessage = "Registration successful";
		  Thread.sleep(2000);
		  System.out.println("Actual Success Message For Registration :"+actualMessage+"\n"+
		  "Expected Success Message For Registration :"+expectedMessage);
		  
		 // assertTrue(actualElement.isDisplayed());
		  
		 // assertTrue(true, expectedMessage);
		 
		 // assertEquals(actualMessage, expectedMessage);
		
		assertEquals(actualMessage, expectedMessage);
		
		Thread.sleep(5000);
		emailInput.sendKeys("info@vrittechnologies.com");
		registerButton.click();
		Thread.sleep(5000);
		if(chrome.findElement(By.id("email-error")).isDisplayed()){
			
			WebElement loginLinkElement = chrome.findElement(By.id("login-link"));
			loginLinkElement.click();
			Thread.sleep(2000);
			WebElement loginEmailElement = chrome.findElement(By.id("login-email"));
			loginEmailElement.sendKeys("info@vrittechnologies.com");
			WebElement loginPwdElement = chrome.findElement(By.id("login-password"));		
			loginPwdElement.sendKeys("password123");
			WebElement loginBtnElement = chrome.findElement(By.id("login-btn"));
			loginBtnElement.click();
			Thread.sleep(5000);
			WebElement actualLoginSuccessElement = chrome.findElement(By.id("login-success-message"));
			
			String actualLoginMessage = actualLoginSuccessElement.getText();
			String expectedSuccessMessage = "Login successful";
			
			System.out.println("Actual Success Message For Login: "+ actualLoginMessage + "\n"+
								"Expected Success Message For Login: "+ expectedSuccessMessage);
			
			assertEquals(actualLoginMessage, expectedSuccessMessage);
			
			/*
			 * TakesScreenshot ts = (TakesScreenshot)chrome; File source =
			 * ts.getScreenshotAs(OutputType.FILE); String destinationPath =
			 * "./screenshots/"; String
			 * destinationFileName="loginFormSuccessScreenshot.png";
			 * 
			 * Files.copy(source,new File(destinationPath+destinationFileName));
			 * System.out.println("Full location is : "+destinationPath+destinationFileName)
			 * ; System.out.println("Screenshot taken with named : "+destinationFileName);
			 */
			 
		}
		
		chrome.close();
	}
	
	/*
	 * @Test public void invalidRegisterInvalidEmail() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 * WebDriver chrome = new ChromeDriver(); chrome.manage().window().maximize();
	 * chrome.get(
	 * "file:///D:/cabtmDashboardAutomation/testSelenium/MyLoginPage/FormExercise.html"
	 * );
	 * 
	 * // Enter invalid email address WebElement emailInput =
	 * chrome.findElement(By.id("email")); emailInput.sendKeys("invalid_email");
	 * 
	 * // Click on the Register button WebElement registerButton =
	 * chrome.findElement(By.id("register-btn")); registerButton.click();
	 * 
	 * // Validate error message WebElement emailError =
	 * chrome.findElement(By.id("email-error")); assert
	 * emailError.getText().equals("Please enter a valid email address");
	 * 
	 * chrome.close(); }
	 * 
	 * @Test public void invalidRegisterShortPassword() throws InterruptedException
	 * { System.setProperty("webdriver.chrome.driver",
	 * "./drivers/chromedriver.exe"); WebDriver chrome = new ChromeDriver();
	 * chrome.manage().window().maximize(); chrome.get(
	 * "file:///D:/cabtmDashboardAutomation/testSelenium/MyLoginPage/FormExercise.html"
	 * );
	 * 
	 * // Enter valid email address WebElement emailInput =
	 * chrome.findElement(By.id("email"));
	 * emailInput.sendKeys("valid_email@example.com");
	 * 
	 * // Enter short password WebElement passwordInput =
	 * chrome.findElement(By.id("password")); passwordInput.sendKeys("123");
	 * 
	 * // Enter confirm password WebElement confirmPasswordInput =
	 * chrome.findElement(By.id("confirm-password"));
	 * confirmPasswordInput.sendKeys("123");
	 * 
	 * // Click on the Register button WebElement registerButton =
	 * chrome.findElement(By.id("register-btn")); registerButton.click();
	 * 
	 * // Validate error message WebElement passwordError =
	 * chrome.findElement(By.id("password-error")); assert
	 * passwordError.getText().equals("Password must be at least 8 characters long"
	 * );
	 * 
	 * chrome.close(); }
	 */
}
