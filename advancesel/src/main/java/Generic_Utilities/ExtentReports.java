//package Generic_Utilities;
//
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReports implements ITestListener {
//
//	ExtentReports report;
//	ExtentTest  test;
//
//	public void onTestStart(ITestResult result) {
//		test =report.createTest(result.getMethod().getMethodName());
//	}
//
//	
//	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, result.getMethod().getMethodName());
//		test.log(Status.PASS, result.getThrowable());
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, result.getMethod().getMethodName());
//		test.log(Status.FAIL, result.getThrowable());
//		String screenshot=null;
//		
//		try {
//			screenShot=WebDriver_Utility.takeSCreenShotEx(BaseClass.sdriver, result.getMethod().getMethodName());
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//			test.addScreenCaptureFromPath(screenShot);
//		}
//		
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		test.log(Status.SKIP, result.getMethod().getMethodName());
//		test.log(Status.SKIP, result.getThrowable());
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//String dateAndTime = new Date().toString().replace(" ", "_").replace(":", "_");
//		
//		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html"+dateAndTime);
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("VtigerReport");
//		spark.config().setReportName("Shobha");
//		
////		//system configure
////		report=new ExtentReports();
////		report.attachReporter(spark);
////		report.setSystemInfo("platform", "windows");
////		report.setSystemInfo("executedBy", "Glad");
////		report.setSystemInfo("reviwedBy", "Gladish");
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		report.flush();
//	}
//
//}
