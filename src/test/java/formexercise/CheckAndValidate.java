package formexercise;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

public class CheckAndValidate {
	


	WebDriver chrome;
	String email;
	String password;
	WebElement emailInput;
	WebElement passwordInput;
	WebElement nameInput;
	WebElement confirmPasswordInput;
	WebElement registerButton;
	WebElement actualElement;
	WebElement emailErr;
	String actualMessage;
	String expectedEmail;
	
	
	
	public CheckAndValidate() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		chrome =new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get("file:///D:/cabtmDashboardAutomation/testSelenium/MyLoginPage/FormExercise.html");
	}
	
	@Test
	public void checkForRegAndLogin() throws InterruptedException, IOException {
		/*
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * chrome = new ChromeDriver(); chrome.manage().window().maximize(); chrome.get(
		 * "file:///D:/cabtmDashboardAutomation/testSelenium/MyLoginPage/FormExercise.html"
		 * );
		 */
		
		
	// Enter valid registration details
	nameInput = chrome.findElement(By.id("name"));
	nameInput.sendKeys("QA Instructor");
	waitTwoSeconds();
	
	
	email = "info@vrittechnologies.com";
	password = "Password@1234";
	
	emailInput = chrome.findElement(By.id("email"));
	emailInput.sendKeys(email);
	waitTwoSeconds();
	
	passwordInput = chrome.findElement(By.id("password"));
	passwordInput.sendKeys(password);
	waitTwoSeconds();
	
	confirmPasswordInput = chrome.findElement(By.id("confirm-password"));
	confirmPasswordInput.sendKeys(password);
	waitTwoSeconds();
	
	
	// Click on the Register button
	registerButton = chrome.findElement(By.id("register-btn"));
	registerButton.click();
	waitTwoSeconds();
	
	
	
	  actualElement = chrome.findElement(By.id("success-message")); 
	  String actualMessage = actualElement.getText(); 
	  String expectedMessage = "Registration successful";
	  waitTwoSeconds();
	  System.out.println("Actual Success Message For Registration :"+actualMessage+"\n"+
	  "Expected Success Message For Registration :"+expectedMessage);
	  
	  WebElement emailValidate = chrome.findElement(By.id("email"));
	  emailValidate.sendKeys(email);
	  waitTwoSeconds();
	  registerButton.click();
	  waitTwoSeconds();
	  
	  emailErr = chrome.findElement(By.id("email-error"));
	  String actualEmail = emailErr.getText();
	  expectedEmail = "Email already registered";
	  
	  assertEquals(actualEmail, expectedEmail);
	  
	  WebElement loginLinkElement = chrome.findElement(By.id("login-link"));
	  loginLinkElement.click();
	  waitTwoSeconds();
	  
	  WebElement emailLogin = chrome.findElement(By.id("login-email"));
	  emailLogin.sendKeys(email);
	  waitTwoSeconds();
	  
	  WebElement loginPwd = chrome.findElement(By.id("login-password"));
	  loginPwd.sendKeys(password);
	  waitTwoSeconds();
	  
	  WebElement loginBtnElement = chrome.findElement(By.id("login-btn"));
	  loginBtnElement.click();
	  waitTwoSeconds();
	  
	  WebElement loginSuccessMsgElement = chrome.findElement(By.id("login-success-message"));
	  String actualLoginSuccessMsg = loginSuccessMsgElement.getText();
	  String expectedLoginSuccessMsg = "Login successful";
	  
	  System.out.println("LoggedIn success Text :"+ actualLoginSuccessMsg);
	  assertEquals(actualLoginSuccessMsg, expectedLoginSuccessMsg);
	  
		/*
		 * TakesScreenshot ts = (TakesScreenshot)chrome; File source =
		 * ts.getScreenshotAs(OutputType.FILE); String destination =
		 * "./screenShots/screenshot1.png"; Files.copy(source, new File(destination));
		 * 
		 * waitTwoSeconds();
		 */
	  
	  
	  TakesScreenshot bjec = (TakesScreenshot)chrome;
	  File source1 = bjec.getScreenshotAs(OutputType.FILE);
	  String destination1 = "./screenShots/1.png";
	  Files.copy(source1,new File(destination1));
	  waitTwoSeconds();
	  
	  
	}
	
	
	public void waitTwoSeconds() throws InterruptedException {
		
		Thread.sleep(2000);
		
	}
}
