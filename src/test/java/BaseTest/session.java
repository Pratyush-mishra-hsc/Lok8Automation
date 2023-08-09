package BaseTest;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import BaseTest.BaseTest;
import keywords.ApplicationKeywords;

public class session extends BaseTest{
	
	@Test
	public void doLogin(ITestContext context) 
	{	
		System.out.println("---------Login Done---------");
		test.log(Status.INFO, "Donig login on machine");
		
		ApplicationKeywords app = (ApplicationKeywords)context.getAttribute("app");
		app.openBrowser("Browser");
		test.log(Status.INFO, "Browser opened");
		
		app.navigate("URL");
		app.EnterDatails("username_xpath", "username");
		app.EnterDatails("password_xpath", "password");
		app.click("SubmitButton_xpath");
		
		test.log(Status.INFO, "loggedIn on machine");
	}
	
	@Test
	public void doLogout() 
	{
		test.log(Status.INFO, "---------Logged Done---------");		
	}
}