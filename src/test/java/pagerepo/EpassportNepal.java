package pagerepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpassportNepal {
	
	WebDriver driver;
	
	By passportElement = By.xpath("//h4[text()='Apply for Passport']");
	By ePassportElement = By.xpath("(//a[text()='Apply for ePassport'])[1]");
	By applyForPassportElement = By.xpath("//a[contains(text(),'Apply for Passport')]");
	By firstIssuanceElement = By.xpath("//h3[text()='First Issuance']");
	By ordinaryLinkElement = By.xpath("//label[text()='Ordinary 34 pages']");
	By proceedElement = By.xpath("//a[text()='Proceed']");
	By iAgreeElement = By.xpath("//a[contains(text(),'I agree स्वीकृत छ')]");
	By countryDropdownElement = By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]");
	By otherSelectionElement = By.xpath("//span[text()=' Other ']");
	By appointmentLocationElement = By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]");
	By optionFourElement = By.xpath("(//span[@class='mat-option-text'])[4]");
	By listOfAllCurrentMonthDates = By.xpath("//tbody[contains (@class, 'ng-tns')]");
	By listOfAllDisableDates = By.xpath("//*[contains (@class, 'ui-state-disabled')]");
	By listOfAllClickableDatesInActiveCalendar = By.xpath("//a[contains(@class,'ui-state-default')]");
	By listOfAvailableTime = By.cssSelector("div[class*='mat-chip-list-wrapper']");
	By nearestEnrollmentCenterText = By.xpath("//h3[contains(.,'Please choose the nearest enrollment center')]");
	
	public EpassportNepal(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement ePassportElement() {
		
		return driver.findElement(ePassportElement);
	}
	
	public WebElement applyForPassportElement() {
		
		return driver.findElement(applyForPassportElement);
	}
	
	public WebElement firstIssuanceElement() {
		
		return driver.findElement(firstIssuanceElement);
	}
	
	public WebElement ordinaryLinkElement() {
		
		return driver.findElement(ordinaryLinkElement);
	}
	
	public WebElement proceedElement() {
		
		return driver.findElement(proceedElement);
	}
	
	public WebElement iAgreeElement() {
		
		return driver.findElement(iAgreeElement);
	}
	
	public WebElement passportElement() {
		
		return driver.findElement(passportElement);
	}
	
	public WebElement countryDropdownElement() {
		
		return driver.findElement(countryDropdownElement);
	}
	
	public WebElement otherSelectionElement() {
		
		return driver.findElement(otherSelectionElement);
	}
	
	public WebElement appointmentLocationElement() {
		
		return driver.findElement(appointmentLocationElement);
	}
	
	public WebElement optionFourElement() {
		
		return driver.findElement(optionFourElement);
	}
	
	public List<WebElement> listOfAllCurrentMonthDates(){
		
		return driver.findElements(listOfAllCurrentMonthDates);
	}
	
	public List<WebElement> listOfAllDisableDates(){
		
		return driver.findElements(listOfAllDisableDates);
	}
	
	public List<WebElement> listOfAllClickableDatesInActiveCalendar(){
		
		return driver.findElements(listOfAllClickableDatesInActiveCalendar);
	}
	
	public List<WebElement> listOfAvailableTime(){
		
	    List<WebElement> elements = driver.findElements(listOfAvailableTime);
		return elements;
	}
	
	public WebElement nearestEnrollmentCenterText(){
		
		return driver.findElement(nearestEnrollmentCenterText);
	}

}
