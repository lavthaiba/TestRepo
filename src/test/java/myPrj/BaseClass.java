/**
 * @author Lav Thaiba
 */

package myPrj;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	static WebDriver driver;
	static Properties prop;
	static ExtentReports extent;
	static ExtentTest test;
	static String browserChoice;
	static String baseUrl;
	static String demoTestUrl;
	
	
	static {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportFilePath());
        extent.attachReporter(spark);
    }
 
	
	@BeforeMethod
	public void setUp() {
		
		Reporter.log("====BROWSER SESSION STARTED====", true);
		
		prop = new Properties();
        InputStream inputStream;
        inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        
        try {
        	if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("config.properties file not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        browserChoice = prop.getProperty("browser");
        baseUrl = prop.getProperty("baseUrl");
      //  demoTestUrl = prop.getProperty("demoTestUrl");
        
		/*
		 * while (browserChoice == null) {
		 * 
		 * browserChoice = browserChoice; }
		 */
	switch(browserChoice) {
	
	case "chrome": 
			Reporter.log("===STARTING WITH CHROME BROWSER===", true);
			WebDriverManager.chromedriver().setup();		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			// Set logging preferences
			/*
			 * LoggingPreferences logPrefs = new LoggingPreferences();
			 * logPrefs.enable(LogType.BROWSER, Level.ALL);
			 * options.setCapability("goog:loggingPrefs", logPrefs);
			 */
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get(baseUrl);
			
			//driver.get(demoTestUrl);
			/*
			 * if (demoTestUrl != null && !demoTestUrl.isEmpty()) { driver.get(demoTestUrl);
			 * } else { System.out.println("Demo Test URL is not set!"); }
			 */
			break;
			
	case "firefox": 
			Reporter.log("===STARTING WITH FIREFOX BROWSER===", true);
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(baseUrl);
			break;
	
	
	case "edge": 
			Reporter.log("===STARTING WITH EDGE BROWSER===", true);
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		
		if (driver != null) {
	
			Reporter.log("==BROWSER SESSION END==", true);
        	LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logs) {
                System.out.println(entry.getLevel() + " " + entry.getMessage());
            }
            
    		driver.quit();
    		extent.flush();
        }
		
	}

}
