package LocationServices.Health;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import BaseTest.BaseTest;

public class HealthReaderTestCases extends BaseTest{
	
	public SoftAssert soft ;

	@Test
	public void ReaderHealthValidation()
	{
		test.log(Status.INFO, "Start checking Readers Health");
		app.click("LocationPlugin_xpath");
		app.click("Health_xpath");
		test.log(Status.INFO, "Checked Readers Health");
	}
}
