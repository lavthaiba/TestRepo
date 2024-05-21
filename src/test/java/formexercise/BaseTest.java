package formexercise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.TestNGException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;



public class BaseTest {
	
	WebDriver driver;
	WebDriverWait wait;
	String chromePath ="./drivers/chromedriver.exe";
	String firefoxPath ="./drivers/geckodriver.exe";
	String edgePath ="./drivers/msedgedriver.exe";
	String driverPath=firefoxPath;
	WebElement email;
	Scanner inputBrowserChoice;
	String baseUrl = "https://courses.ultimateqa.com";
	
	
	@BeforeMethod
	public void setUp() {
		
		inputBrowserChoice = new Scanner(System.in);
		
		System.out.println("Enter number(1 or 2 or 3) to select your browser:\n"+
				"1. Google Chrome\n"+
				"2. Mozilla Firefox\n"+
				"3. Microsoft Edge");
		
		int driverNameNumber = inputBrowserChoice.nextInt();
		switch (driverNameNumber) {
	    case 1:
	        // Uncomment the line below if you are using a custom path for chromedriver
	        System.setProperty("webdriver.chrome.driver", chromePath);
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        break;
	    case 2:
	        // Uncomment the line below if you are using a custom path for geckodriver
	        System.setProperty("webdriver.gecko.driver", firefoxPath);
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        break;
	    case 3:
	    	System.setProperty("webdriver.edge.driver", edgePath);
	        driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        break;
	    default:
	       // throw new IllegalArgumentException("Invalid browser choice: " + driverNameNumber);
	    	System.out.println("Invalid browser selection choice. You entered "+ driverNameNumber+" number choice.");
	    	try {
	    		System.out.println("Please Try Again!\n"+
	    							"Plesae enter browser choice number (1 or 2 or 3): ");
	    		BaseTest driver = new BaseTest();
	    			
	    	}catch(TestNGException e) {
	    		
	    		System.out.println("Your exception message is here: "+e.getMessage());
	    	}
		}
	
			driver.get(baseUrl);
	}
	
	/*
	 * public void waitTwoSeconds() throws InterruptedException {
	 * Thread.sleep(2000); }
	 */
	
	
	//implicit wait 
	
	public WebElement waitUntilVisible(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Element not visible "+locator);
		}
	}
	
	public void takeScreenshot() throws IOException {
		

		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  String destination = "./ss/1.png";
		  Files.copy(source,new File(destination));
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		Reporter.log("====BROWSER SESSION END====", true);
		driver.close();
	}
	

}
