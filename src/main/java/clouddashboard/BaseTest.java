package clouddashboard;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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


public class BaseTest {
	
	static WebDriver driver;
	WebDriverWait wait;
	String chromePath ="./drivers/chromedriver.exe";
	String firefoxPath ="./drivers/geckodriver.exe";
	String edgePath ="./drivers/msedgedriver.exe";
	String driverPath=firefoxPath;
	WebElement email;
	Scanner inputBrowserChoice;
	String baseUrl = "https://cloud-frontend-topaz.vercel.app/login";
	String setEmailAddress;
	String emailAddress ="namanthaiba@gmail.com";
	String password = "Test@123";
	
	@BeforeMethod
	public void setupBrowser() {
		
		Reporter.log("===BROWSER SESSION STARTED===", true);
		inputBrowserChoice = new Scanner(System.in);
		
		System.out.println("Enter number(1 or 2 or 3) to select your browser:\n"+
				"1. Google Chrome\n"+
				"2. Mozilla Firefox\n"+
				"3. Microsoft Edge");
		
		int driverNameNumber = inputBrowserChoice.nextInt();
		switch (driverNameNumber) {
	    case 1:
	        // Uncomment the line below if you are using a custom path for chromedriver
	    	Reporter.log("==RUNNING ON CHROME==", true);
	        System.setProperty("webdriver.chrome.driver", chromePath);
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        break;
	    case 2:
	        // Uncomment the line below if you are using a custom path for geckodriver
	    	Reporter.log("==RUNNING ON FIREFOX==", true);
	        System.setProperty("webdriver.gecko.driver", firefoxPath);
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        break;
	    case 3:
	    	Reporter.log("==RUNNING ON EDGE==", true);
	    	System.setProperty("webdriver.edge.driver", edgePath);
	        driver = new EdgeDriver();
	        BaseTest.driver.manage().window().maximize();
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
	
	
	//implicit wait By locator
	
	public WebElement waitUntilVisible(By locator) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try
		{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Element not visible "+locator);
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		Reporter.log("==BROWSER SESSION END==",true);
		driver.close();
	}
	

}
