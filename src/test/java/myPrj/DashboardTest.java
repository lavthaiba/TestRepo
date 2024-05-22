/*
 * package myPrj;
 * 
 * import static org.testng.Assert.assertEquals;
 * 
 * import java.util.List;
 * 
 * import org.openqa.selenium.WebElement; import org.testng.Reporter; import
 * org.testng.annotations.Test; import pagerepo.DashboardPage; import
 * pagerepo.LoginPage;
 * 
 * public class DashboardTest extends BaseClass{
 * 
 * 
 * 
 * 
 * @Test(priority=20)
 * 
 * public void verifyLoginStatusText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * loginStatusText =dashboardItem.loginInStatusText().getText();
 * if(dashboardItem.loginInStatusText().isDisplayed()) {
 * System.out.println("Login Status text is : "+loginStatusText);
 * Reporter.log("==Login Status Text shown and is Verified!", true); } }
 * 
 * 
 * @Test(priority=30)
 * 
 * public void verifyGreetingText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String greetingText
 * = dashboardItem.greetingText().getText();
 * if(dashboardItem.greetingText().isDisplayed()) {
 * System.out.println("Greeting text is : "+ greetingText);
 * Reporter.log("==Greeting Text is verified!==", true); } }
 * 
 * 
 * @Test(priority=40) public void verifyTotalApplicants() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalApplicantsActualText = dashboardItem.totalApplicants().getText(); String
 * totalApplicantsExpectedText = "TOTAL APPLICANTS";
 * assertEquals(totalApplicantsActualText, totalApplicantsExpectedText);
 * Reporter.log("==Total Applicants text verified!==", true); }
 * 
 * 
 * 
 * @Test(priority=50) public void verifyTotalApplicantsNumber() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalApplicantsNumberTxt = dashboardItem.totalApplicantsNumber().getText();
 * if(dashboardItem.totalApplicantsNumber().isDisplayed()) { System.out.
 * println("Total Applicants Number displayed with the total Applicants Number of : "
 * + totalApplicantsNumberTxt);
 * Reporter.log("==Total Applicants Number Verified!==", true); } }
 * 
 * 
 * @Test(priority=60) public void verifyTotalApplications() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalApplicationsActualText = dashboardItem.totalApplications().getText();
 * String totalApplicationsExpectedText = "TOTAL APPLICATIONS";
 * assertEquals(totalApplicationsActualText, totalApplicationsExpectedText);
 * Reporter.log("==Total Applications Text has been Verified!==", true);
 * 
 * }
 * 
 * 
 * 
 * @Test(priority=70) public void verifyTotalApplicationsNumber() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalApplicationsNumberTxt =
 * dashboardItem.totalApplicationsNumber().getText();
 * if(dashboardItem.totalApplicationsNumber().isDisplayed()) { System.out.
 * println("Total Applications Number is verified with the number of : "
 * +totalApplicationsNumberTxt);
 * Reporter.log("==Total Applications Number has been Verified!==", true); } }
 * 
 * 
 * @Test(priority=80) public void verifyGrantedStudent() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * grantedStudentActualText = dashboardItem.grantedStudent().getText(); String
 * grantedStudentExpectedText = "GRANTED STUDENTS";
 * assertEquals(grantedStudentActualText, grantedStudentExpectedText);
 * Reporter.log("==Granted Student Text has been Verified!==", true); }
 * 
 * @Test(priority=90) public void verifyGrantedStudentNumber() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * grantedStudentNumberTxt = dashboardItem.grantedStudentNumber().getText();
 * if(dashboardItem.grantedStudentNumber().isDisplayed()) {
 * System.out.println("Granted Student Number is Verified with the number of :"
 * +grantedStudentNumberTxt);
 * Reporter.log("==Granted Student Number has been Verfied!==", true); }
 * 
 * }
 * 
 * 
 * @Test(priority=100) public void verifyTotalUniversities() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalUniversitiesActualText = dashboardItem.totalUniversties().getText();
 * String totalUniversitiesExpectedText = "TOTAL UNIVERSITIES";
 * assertEquals(totalUniversitiesActualText, totalUniversitiesExpectedText);
 * Reporter.log("==Total Universities Text has been Verified!", true); }
 * 
 * @Test(priority=110) public void verifyTotalUniversitiesNumber() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalUniversitiesTxt = dashboardItem.totalUniversitiesNumber().getText();
 * if(dashboardItem.totalUniversitiesNumber().isDisplayed()) { System.out.
 * println("Total Universities Number is verified with the number of :"+
 * totalUniversitiesTxt);
 * Reporter.log("==Total Universities Number has been Verified!==", true); } }
 * 
 * 
 * @Test(priority=120) public void verifyVisaOverview() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin(); DashboardPage
 * dashboardItem = new DashboardPage(driver); String visaOverViewActualText =
 * dashboardItem.visaOverview().getText(); String visaOverviewExpectedText =
 * "Visa Overview"; assertEquals(visaOverViewActualText,
 * visaOverviewExpectedText);
 * Reporter.log("Visa Overview Text has been verified!==", true); }
 * 
 * 
 * @Test(priority=130) public void verifyInvoiceStatus() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin(); DashboardPage
 * dashboardItem = new DashboardPage(driver); String invoiceStatusActualTxt =
 * dashboardItem.invoiceStatus().getText(); String invoiceStatusExpectedTxt =
 * "Invoice Status"; assertEquals(invoiceStatusActualTxt,
 * invoiceStatusExpectedTxt);
 * Reporter.log("==Invoice Status Text has been verified==", true); }
 * 
 * 
 * 
 * 
 * @Test(priority = 140)
 * 
 * public void verifyCharts() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver);
 * if(dashboardItem.charts().isDisplayed()) {
 * 
 * System.out.println("Charts shown!");
 * Reporter.log("== Charts shown are verified ==", true); } }
 * 
 * 
 * 
 * @Test(priority = 150) public void verifyDegreeStructureText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * degreeStructureActualTxt = dashboardItem.degreeStructureText().getText();
 * String degreeStructureExpectedTxt = "Degree Structure";
 * assertEquals(degreeStructureActualTxt, degreeStructureExpectedTxt);
 * Reporter.log("==Degree Structure Text has been Verified!==", true); }
 * 
 * 
 * 
 * @Test(priority=160) public void verifyInsuranceOverviewText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * insuranceOverviewActualTxt = dashboardItem.insuranceOverviewText().getText();
 * String insuranceOverviewExpectedTxt = "Insurance Overview";
 * assertEquals(insuranceOverviewActualTxt, insuranceOverviewExpectedTxt);
 * Reporter.log("==Insurance Overview Text has been Verified!==", true); }
 * 
 * 
 * 
 * @Test(priority=170) public void verifyTotalSales() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalSalesActualText = dashboardItem.totalSalesText().getText(); String
 * totalSalesExpectedText = "TOTAL SALES"; assertEquals(totalSalesActualText,
 * totalSalesExpectedText);
 * Reporter.log("==Total Sales text has been verified!==", true); }
 * 
 * 
 * @Test(priority = 180)
 * 
 * public void verifyTotalRefundedText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalRefundedActualTxt = dashboardItem.totalRefundedTxt().getText(); String
 * totalRefundedExpectedTxt = "TOTAL REFUNDED";
 * assertEquals(totalRefundedActualTxt, totalRefundedExpectedTxt);
 * Reporter.log("==Total Refunded text has been verified!==", true); }
 * 
 * 
 * @Test(priority = 190) public void verifyTotalRefundRejectedText() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver); String
 * totalRefundRejectedActualTxt =
 * dashboardItem.totalRefundRejectedTxt().getText(); String
 * totalRefundRejectedExpectedTxt = "TOTAL REFUND REJECTED";
 * assertEquals(totalRefundRejectedActualTxt, totalRefundRejectedExpectedTxt);
 * Reporter.log("==Total Refund Rejected Text shown and verified!==", true); }
 * 
 * 
 * @Test(priority=200) public void verifyInsuranceOverviewGroupOfNpr() {
 * 
 * LoginPage login = new LoginPage(driver); login.callLogin();
 * 
 * DashboardPage dashboardItem = new DashboardPage(driver);
 * 
 * for (WebElement groupNpr : dashboardItem.insuranceOverviewNprGroup()) {
 * 
 * System.out.println("check texts as:"+groupNpr.getText());
 * 
 * } }
 * 
 * }
 */