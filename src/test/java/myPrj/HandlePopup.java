/*
 * package myPrj;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.Alert; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.logging.LogEntries; import
 * org.openqa.selenium.logging.LogEntry; import
 * org.openqa.selenium.logging.LogType; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * org.testng.annotations.Test; import org.testng.annotations.AfterMethod;
 * import org.openqa.selenium.Keys;
 * 
 * 
 * public class HandlePopup extends BaseClass {
 * 
 * private static final int MAX_RETRIES = 3;
 * 
 * 
 * @Test public void testPopUp() { int retries = 0; boolean success = false;
 * 
 * while (retries < MAX_RETRIES && !success) { try { By clickForAlert =
 * By.xpath("(//button[contains(text(),'click the button')])[1]"); WebDriverWait
 * waitForAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
 * 
 * // Wait until the button is clickable
 * waitForAlert.until(ExpectedConditions.elementToBeClickable(clickForAlert));
 * 
 * // Find the button and click it WebElement clickForAlertOrg =
 * driver.findElement(clickForAlert); clickForAlertOrg.click();
 * 
 * // Wait for the alert to be present and print its text
 * waitForAlert.until(ExpectedConditions.alertIsPresent()); String alertText =
 * driver.switchTo().alert().getText(); System.out.println("Alert text: " +
 * alertText);
 * 
 * // Accept the alert driver.switchTo().alert().accept();
 * 
 * // Print the title of the page String pageTitle = driver.getTitle();
 * System.out.println("Page title after accepting alert: " + pageTitle);
 * 
 * success = true; // Test completed successfully
 * 
 * } catch (Exception e) { retries++; System.out.println("Exception occurred: "
 * + e.getMessage()); e.printStackTrace(); if (retries >= MAX_RETRIES) { throw
 * new RuntimeException("Test failed after " + MAX_RETRIES + " retries"); }
 * System.out.println("Retrying... (" + retries + ")"); } } }
 * 
 * 
 * 
 * @Test public void testPopUpWithOK() throws InterruptedException {
 * 
 * By clickForAlertOk = By.xpath("(//a[contains(text(),'Alert with')])[2]");
 * 
 * 
 * // Find the button and click it WebElement clickForAlertOkOrg =
 * driver.findElement(clickForAlertOk); Thread.sleep(3000);
 * 
 * clickForAlertOkOrg.click(); By waitForAlertOkbtn =
 * By.xpath("(//button[contains(text(),'click the button to display')])[2]");
 * WebDriverWait waitForAlertOk = new WebDriverWait(driver,
 * Duration.ofSeconds(10)); // Wait until the button is clickable
 * waitForAlertOk.until(ExpectedConditions.elementToBeClickable(
 * waitForAlertOkbtn));
 * 
 * WebElement clickBtnToDisplay = driver.findElement(By.
 * xpath("(//button[contains(text(),'click the button to display')])[2]"));
 * clickBtnToDisplay.click(); Thread.sleep(3000);
 * 
 * 
 * 
 * // Wait until the button is clickable //
 * waitForAlertOk.until(ExpectedConditions.elementToBeClickable(
 * waitForAlertOkbtn));
 * waitForAlertOk.until(ExpectedConditions.alertIsPresent()); String alertText =
 * driver.switchTo().alert().getText(); System.out.println("Alert text: " +
 * alertText);
 * 
 * // Accept the alert driver.switchTo().alert().accept(); //
 * driver.switchTo().alert().dismiss(); // Print the title of the page String
 * okPress = driver.findElement(By.xpath("//p[@id='demo']")).getText();
 * System.out.println("Page title after accepting alert: " + okPress);
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * @Test public void testPopUpWithText() { try { // Navigate to the page
 * containing the prompt alert By clickAlertWithText =
 * By.xpath("//a[contains(.,'Alert with Textbox')]"); WebDriverWait wait = new
 * WebDriverWait(driver, Duration.ofSeconds(10));
 * 
 * // Find and click the link to open the alert prompt example
 * wait.until(ExpectedConditions.elementToBeClickable(clickAlertWithText));
 * WebElement alertWithTextLink = driver.findElement(clickAlertWithText);
 * alertWithTextLink.click();
 * 
 * // Wait for the button to display and click it By promptButtonLocator = By.
 * xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"
 * ); wait.until(ExpectedConditions.elementToBeClickable(promptButtonLocator));
 * WebElement promptButton = driver.findElement(promptButtonLocator);
 * promptButton.click();
 * 
 * // Wait for the alert to be present
 * wait.until(ExpectedConditions.alertIsPresent());
 * 
 * // Switch to the alert Alert alert = driver.switchTo().alert();
 * 
 * // Get the text from the alert and print it String alertText =
 * alert.getText(); System.out.println("Alert text: " + alertText);
 * 
 * // Send new text to the prompt String textToSend = "QA Testing";
 * alert.sendKeys(textToSend); System.out.println("Text sent to prompt: " +
 * textToSend);
 * 
 * // Accept the alert alert.accept();
 * 
 * // Wait for the response text to be present By responseTextLocator =
 * By.xpath("//p[@id='demo1']");
 * wait.until(ExpectedConditions.visibilityOfElementLocated(responseTextLocator)
 * );
 * 
 * // Print the response text after accepting the alert String responseText =
 * driver.findElement(responseTextLocator).getText();
 * System.out.println("Response text after accepting alert: " + responseText);
 * 
 * } catch (Exception e) { System.out.println("Exception occurred: " +
 * e.getMessage()); e.printStackTrace(); } }
 * 
 * 
 * 
 * 
 * }
 */