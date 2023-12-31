package BaseTest;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest {
	
	public ApplicationKeywords app;
	public ExtentReports rep;
	public ExtentTest test;
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) throws IOException {
		System.out.println("-----------Before Test--------------");
		System.out.println("beforeTest() executed successfully");
		
		app = new ApplicationKeywords(); // 1 app keyword object for entire test - All @test
		context.setAttribute("app", app);
		
		rep = ExtentManager.getReports();
		test = rep.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Test "+context.getCurrentXmlTest().getName());
		app.setReport(test);
		context.setAttribute("report", rep);
		context.setAttribute("test", test);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		
		System.out.println("-----------Before Method--------------");
		app = (ApplicationKeywords)context.getAttribute("app");
		rep = (ExtentReports) context.getAttribute("report");
		test = (ExtentTest) context.getAttribute("test");		
	}
	
	@AfterTest
	public void quit() {
		if (rep !=null) {
			rep.flush();			
		}
	}
}