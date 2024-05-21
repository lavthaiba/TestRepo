package formexercise;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ValidationInForms extends BaseTest {
	

	
	  @Test(priority=4)
	  public void checkInvalidEmail() throws InterruptedException, IOException {
	  
			/*
			 * emailInput = driver.findElement(By.id("email")); emailInput.sendKeys(email);
			 * waitTwoSeconds(); registerButton = driver.findElement(By.id("register-btn"));
			 * registerButton.click(); waitTwoSeconds();
			 */
	  
			/*
			 * JavascriptExecutor scroll = (JavascriptExecutor)driver;
			 * scroll.executeScript("window.scrollBy(0,250)", "");
			 */
		 
		  
		  JavascriptExecutor je = (JavascriptExecutor)driver;
		  je.executeScript("window.scrollBy(0,1000)", "");
		  
			/*
			 * List<WebElement> mulipleLinkElements =
			 * driver.findElements(By.cssSelector(".card__badge--free"));
			 * 
			 * String getLinkText = mulipleLinkElements.get(1).getText(); WebElement
			 * FirstFreeLinkBtn = mulipleLinkElements.get(1);
			 */
	  
		 
		  List<WebElement> manyLinksElement = driver.findElements(By.cssSelector(".card__badge--free"));
		  
				  String firstLinkToBeClicked = manyLinksElement.get(0).getText();
				  System.out.println("First link is: "+firstLinkToBeClicked);
				  WebElement firstFreeLink = manyLinksElement.get(0); 
				  
				 if(firstFreeLink.isDisplayed())
					 firstFreeLink.click();
				 
				
				 takeScreenshot();
				 driver.navigate().back();  
				// Thread.sleep(5000);
					/*
					 * WebDriverWait wait = new WebDriverWait(driver,10);
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
					 * ".card__badge--free")));
					 */
				 
				 List<WebElement>manyLinksElement1 = driver.findElements(By.cssSelector(".card__badge--free"));
				 
				JavascriptExecutor je1 = (JavascriptExecutor)driver;
				je1.executeScript("window.scrollBy(0,1000)", "");
				 Thread.sleep(2000);
				 WebElement secondFreeLink = manyLinksElement1.get(2);

			//	 wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(secondFreeLink)));
				 
				 
				 if(secondFreeLink.isDisplayed())
					 secondFreeLink.click();
				 Thread.sleep(2000);
				 System.out.println("Second link has been clicked, second link name also matches First link name which is :"+secondFreeLink.getText());
	  
	//  FirstFreeLinkBtn.click();
	//  System.out.println("First clickable text shown is: "+getLinkText);
	  
	  }
	 


}
