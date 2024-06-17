/*
 * package mainRun;
 * 
 * import static org.testng.Assert.assertEquals;
 * 
 * import org.testng.Reporter;
 * 
 * import com.aventstack.extentreports.Status;
 * 
 * public class MainRun extends BaseMain{
 * 
 * public static void main(String[] args) {
 * 
 * BaseMain mainObject = new BaseMain(); mainObject.setUp(); LoginMain login =
 * new LoginMain(driver); login.inputEmail().sendKeys(login.email());
 * login.inputPassword().sendKeys(login.password()); login.loginBtn().click();
 * System.out.println("Logged in successfully\n"+
 * "Now verifying Login by validating Dashboard text.."); DashboardMain
 * dashboardText = new DashboardMain(driver); String actualDashboardText =
 * dashboardText.dashboardLinkText().getText().trim();
 * //System.out.println(actualDashboardText); String expectedDashboardText =
 * "Dashboard"; assertEquals(actualDashboardText, expectedDashboardText); test=
 * extent.createTest("Valid Login Case"); test.log(Status.PASS,
 * "Test Passed with successful Login");
 * Reporter.log("==Login Test case Verified==", true); mainObject.tearDown(); }
 * 
 * }
 * 
 */