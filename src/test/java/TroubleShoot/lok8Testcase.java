package TroubleShoot;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

public class lok8Testcase {

	public WebDriver driver;
	public WebElement element;

	@Test
	public void Login() throws IOException {

		ApplicationKeywords App = new ApplicationKeywords();

		App.openBrowser("Browser");

		App.navigate("URL");

		App.EnterDatails("username_xpath", "username");

		App.EnterDatails("password_xpath", "password");

		App.click("SubmitButton_xpath");

		App.click("LocationPlugin_xpath");

		App.click("Health_xpath");

		App.CloseBrowser();

	}
}