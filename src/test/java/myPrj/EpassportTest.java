package myPrj;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import pagerepo.EpassportNepal;

public class EpassportTest extends BaseClass {

	WebDriverWait waitEpassport;
	WebDriverWait wait;
	WebDriverWait waitDropdown;
	WebDriverWait waitApplyForPassport;
	WebDriverWait waitDropdownAppointment;
	WebDriverWait waitListOfcurrentDates;
	WebDriverWait waitSelectAnHourElement;
	WebDriverWait waitNearestEnrollmentCenterText;
	WebDriverWait waitCaptchaElement;
	JavascriptExecutor appointmentDropdownMaster;
	JavascriptExecutor scroll;
	JavascriptExecutor scrollIssuance;
	JavascriptExecutor countryDropdown;
	JavascriptExecutor selectOther;
	JavascriptExecutor appointmentDropdown;
	JavascriptExecutor optionThreeAppointment;
	JavascriptExecutor selectAnHour;
	JavascriptExecutor clickSecondActiveDate;
	String destination = "./screenshots/3.png";
	int activeDatesClicked = 0;

	@Test
	public void verifyEpassportForm() throws InterruptedException, IOException {

		// System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		EpassportNepal ePassportLink = new EpassportNepal(driver);

		waitEpassport = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			waitEpassport.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Apply for ePassport'])[1]")))
					.click();
		} catch (org.openqa.selenium.TimeoutException e) {
			// TODO Auto-generated catch block

			waitEpassport.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Apply for ePassport'])[1]")))
					.click();
			System.out.println("I have to be executed for Clicking Apply for ePassport!");

			// e.printStackTrace();
		}

		String windowsIds = driver.getWindowHandle();

		for (String windowId : driver.getWindowHandles()) {

			if (!windowId.equals(windowsIds)) {
				driver.switchTo().window(windowId);
			}
		}
		waitApplyForPassport = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			waitApplyForPassport.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Apply for Passport')]")))
					.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			waitApplyForPassport.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Apply for Passport')]")))
					.click();
			System.out.println("I have to be executed for clicking Apply for Passport");
			// e.printStackTrace();
		}
		System.out.println("Text is:" + ePassportLink.applyForPassportElement().getText());
		System.out.println("I am proceeded and clicked");
		Actions actionsPassport = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='First Issuance']")));
		actionsPassport.moveToElement(ePassportLink.firstIssuanceElement()).build().perform();
		try {
			ePassportLink.firstIssuanceElement().click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			actionsPassport.moveToElement(ePassportLink.firstIssuanceElement()).build().perform();
			ePassportLink.firstIssuanceElement().click();
			System.out.println("I have to be executed for Issuance Click retry");

			// e.printStackTrace();
		}
		System.out.println("Issuance Link Clicked!");
		scrollIssuance = (JavascriptExecutor) driver;
		scrollIssuance.executeScript("arguments[0].scrollIntoView();", ePassportLink.ordinaryLinkElement());
		scrollIssuance.executeScript("arguments[0].click();", ePassportLink.ordinaryLinkElement());
		scrollIssuance.executeScript("arguments[0].click();", ePassportLink.proceedElement());
		scrollIssuance.executeScript("arguments[0].click();", ePassportLink.iAgreeElement());
		System.out.println("I agree Clicked!");
		waitDropdown = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDropdown.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]")));
		countryDropdown = (JavascriptExecutor) driver;
		countryDropdown.executeScript("arguments[0].click();", ePassportLink.countryDropdownElement());
		selectOther = (JavascriptExecutor) driver;
		selectOther.executeScript("arguments[0].click();", ePassportLink.otherSelectionElement());

		waitNearestEnrollmentCenterText = new WebDriverWait(driver, Duration.ofSeconds(90));
		waitNearestEnrollmentCenterText.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[contains(.,'Please choose the nearest enrollment center')]")));
		waitDropdownAppointment = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDropdownAppointment.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]")));

		appointmentDropdown = (JavascriptExecutor) driver;
		appointmentDropdown.executeScript("arguments[0].click();", ePassportLink.appointmentLocationElement());

		optionThreeAppointment = (JavascriptExecutor) driver;
		optionThreeAppointment.executeScript("arguments[0].click();", ePassportLink.optionFourElement());

		String optionFourValue = ePassportLink.optionFourElement().getText();
		System.out.println("Option Three value that has been clicked is :" + optionFourValue);
		while (!optionFourValue.equals(" NE, Paris ")) {

			waitDropdownAppointment = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitDropdownAppointment.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]")));
			appointmentDropdown = (JavascriptExecutor) driver;
			appointmentDropdown.executeScript("arguments[0].click();", ePassportLink.appointmentLocationElement());

			optionThreeAppointment = (JavascriptExecutor) driver;
			optionThreeAppointment.executeScript("arguments[0].click();", ePassportLink.optionFourElement());

			System.out.println("The latest one :" + ePassportLink.optionFourElement().getText());
			System.out.println(
					"Conditon needed to check to verify correct selection! and to click retry for option 4 value");
			break;

		}

		waitListOfcurrentDates = new WebDriverWait(driver, Duration.ofSeconds(90));
		waitListOfcurrentDates
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[contains (@class, 'ng-tns')]")));

		/*
		 * for (WebElement listOfCurrDate : ePassportLink.listOfAllCurrentMonthDates())
		 * {
		 * 
		 * System.out.println("List of All dates in an active calendar shown :" +
		 * listOfCurrDate.getText());
		 * 
		 * if (!listOfCurrDate.getAttribute("class").contains("ui-state-disabled")) {
		 * 
		 * activeDatesClicked++; listOfCurrDate.click();
		 * System.out.println("First Visible date is clicked from the active calendar!"
		 * + listOfCurrDate.getText()); break; // If you want to click only the first
		 * active date, you can break here } }
		 */

		/*
		 * for(WebElement listOfDisableDate : ePassportLink.listOfAllDisableDates()) {
		 * System.out.println("List of All disabled dates in an active calendar shown :"
		 * + listOfDisableDate.getText());
		 * 
		 * }
		 */

		/*
		 * for(WebElement listOfActiveDate :
		 * ePassportLink.listOfAllClickableDatesInActiveCalendar()) {
		 * 
		 * System.out.println("List of All Active Dates in an Active Calendar shown : "+
		 * listOfActiveDate.getText()); listOfActiveDate.click(); break; }
		 */

		int clickedDates = 0;
		for (WebElement listOfActiveDate : ePassportLink.listOfAllClickableDatesInActiveCalendar()) {
			if (clickedDates == 0) {
				// Skip the first date
				clickedDates++;
				continue;
			}
			System.out.println("From Second Active Dates in an Active Calendar shown : " + listOfActiveDate.getText());
			try {
				listOfActiveDate.click();
			} catch (org.openqa.selenium.ElementClickInterceptedException e) {

				clickSecondActiveDate = (JavascriptExecutor) driver;
				clickSecondActiveDate.executeScript("arguments[0].click();", listOfActiveDate);

				System.out.println("Retrying and grabbing current active date again");

				// e.printStackTrace();
			}
			break; // Break out of the loop after clicking the second date
		}

		waitSelectAnHourElement = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitSelectAnHourElement
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='mat-chip-list-wrapper']")));

		for (WebElement listOfAvailableTime : ePassportLink.listOfAvailableTime()) {

			System.out.println("List of Available time shown :" + listOfAvailableTime.getText());

			listOfAvailableTime.click();

			System.out.println("Appointment Time is selected");
			break;
		}

		/*
		 * waitCaptchaElement= new WebDriverWait(driver, Duration.ofSeconds(10));
		 * waitCaptchaElement.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//img[@class='captcha-img']"))); // TakesScreenshot File source =
		 * driver.findElement(By.xpath("//img[@class='captcha-img']")).getScreenshotAs(
		 * OutputType.FILE); System.out.println("source location is :"+ source);
		 * 
		 * Files.copy(source,new
		 * File("D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\2.png"));
		 * 
		 * 
		 * ITesseract image = new Tesseract();
		 * 
		 * String forSetPath ="D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\";
		 * image.setDatapath(forSetPath); image.setTessVariable("user_defined_dpi",
		 * "70"); // image.setTessVariable();)
		 * 
		 * waitCaptchaElement= new WebDriverWait(driver, Duration.ofSeconds(10));
		 * waitCaptchaElement.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//img[@class='captcha-img']"))); String imageText = image.doOCR(new
		 * File("D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\2.png"));
		 * System.out.println("image Text is: "+ imageText);
		 */

		// Wait for the captcha image to be visible
		waitCaptchaElement = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitCaptchaElement
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='captcha-img']")));

		// Capture screenshot of the captcha image
		File source = driver.findElement(By.xpath("//img[@class='captcha-img']")).getScreenshotAs(OutputType.FILE);
		// Save the screenshot
		String captchaImagePath = "D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\captcha.png";
		Files.copy(source, new File(captchaImagePath));

		/*
		 * // Load the captcha image using OpenCV Mat captchaImage =
		 * Imgcodecs.imread(captchaImagePath);
		 * 
		 * // Convert the captcha image to grayscale Mat grayImage = new Mat();
		 * Imgproc.cvtColor(captchaImage, grayImage, Imgproc.COLOR_BGR2GRAY);
		 * 
		 * // Apply thresholding to binarize the captcha image Mat binaryImage = new
		 * Mat(); Imgproc.threshold(grayImage, binaryImage, 0, 255,
		 * Imgproc.THRESH_BINARY_INV | Imgproc.THRESH_OTSU);
		 * 
		 * // Save the pre-processed captcha image String preprocessedCaptchaImagePath =
		 * "D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\preprocessed_captcha.png";
		 * Imgcodecs.imwrite(preprocessedCaptchaImagePath, binaryImage);
		 * 
		 * // Perform OCR on the pre-processed captcha image ITesseract image = new
		 * Tesseract(); String datapath =
		 * "D:\\cabtmDashboardAutomation\\testSelenium\\tessdata\\";
		 * image.setDatapath(datapath); image.setTessVariable("user_defined_dpi",
		 * "300"); String captchaText = image.doOCR(new
		 * File(preprocessedCaptchaImagePath)); System.out.println("Captcha Text: " +
		 * captchaText);
		 */

	}

}
