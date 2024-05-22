/**
 * @author Lav Thaiba
 */

package myPrj;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	static WebDriver driver;
	Properties prop;
	static ExtentReports extent;
	ExtentTest test;
	
	static {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportFilePath());
        extent.attachReporter(spark);
    }
 
	
	@BeforeMethod
	public void setUp() {
		
		Reporter.log("====BROWSER SESSION STARTED====", true);
		
		prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        
        try {
        	if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("config.properties file not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String browserChoice = prop.getProperty("browser");
        String baseUrl = prop.getProperty("baseUrl");
        String otherUrl = prop.getProperty("otherUrl");	
				
        while (browserChoice == null) {
        	
        	browserChoice = browserChoice;
        }
        
	switch(browserChoice) {
	
	case "chrome": 
			Reporter.log("===STARTING WITH CHROME BROWSER===", true);
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
			break;
			
	case "firefox": 
			Reporter.log("===STARTING WITH FIREFOX BROWSER===", true);
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
			break;
	
	
	case "edge": 
			Reporter.log("===STARTING WITH EDGE BROWSER===", true);
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
			break;
			
	default: 
		
			System.out.println("Your Browser choice has invalid selection!");		
		}
	
	}
	
	

	  private static String getExtentReportFilePath() {
	        String reportFileName = "ExtentReport.html";
	        return new File("test-output", reportFileName).getAbsolutePath();
	    }
	  
		/*
		 * protected void logTestStep(Status status, String message) { test.log(status,
		 * message); }
		 */
	
	@AfterMethod
	public void tearDown() {
		
		Reporter.log("==BROWSER SESSION END==", true);
		driver.close();
		extent.flush();
		
	}

}
