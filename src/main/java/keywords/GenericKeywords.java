package keywords;

import java.time.Duration;
import java.util.Properties;
/*import org.testng.Assert;
import org.testng.asserts.SoftAssert;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GenericKeywords {
	public WebDriver driver;
	public WebElement element;
	public Properties env;
	public Properties generic;
	public ExtentTest test;
	//public SoftAssert softAssert;
	

	public void openBrowser(String Browser) {

		String bName = generic.getProperty(Browser);
		System.out.println("Opening the browser by property file  : " + bName);
		
		if (bName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Pratyush\\Automation\\SeleniumRestAssured\\JARs\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (bName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Pratyush\\Automation\\SeleniumRestAssured\\JARs\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void click(String locator) {
		System.out.println("locator value is : " + locator);
		log("Element Clicked");
		GetElement(locator).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void navigate(String urlKey) {
		driver.get(env.getProperty(urlKey));
		log("URL Navigated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void EnterDatails(String locator, String Value) {

		GetElement(locator).sendKeys(env.getProperty(Value));
		System.out.println("Value under EnterDatails method");
		log("Entered Details");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public WebElement GetElement(String locator) {
		if (!isElementPresent(locator)) {
			System.out.println("Element not present at : " + locator);
		}
		if (!isElementVisible(locator)) {
			System.out.println("Element not visible at : " + locator);
		}

		element = driver.findElement(By.xpath(generic.getProperty(locator)));
		return element;
	}

	public boolean isElementPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			System.out.println("enter under isElementPresent mtd try block");
			log("Element Present");
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locator)));
		} catch (Exception e) {

			return false;
		}
		// return true , if element is present
		return true;
	}

	public boolean isElementVisible(String locator) {
		// return true , if element is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locator)));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		// return true , if element is present
		return true;
	}

	public By getLocator(String locator) {
		By by = null;

		if (locator.endsWith("_id")) {
			by = By.id(generic.getProperty(locator));
		} else if (locator.endsWith("_xpath")) {
			System.out.println("before Value under get locater method");
			by = By.xpath(generic.getProperty(locator));
			System.out.println("Value under get locater method");
		} else if (locator.endsWith("_css")) {
			by = By.cssSelector(generic.getProperty(locator));
		} else if (locator.endsWith("_name")) {
			by = By.name(generic.getProperty(locator));
		}
		return by;
	}

	public void log(String msg) {
		System.out.println("Log generic mtd");
		test.log(Status.INFO, msg);
	}
	
	public void select(String locator, String data) {

	}

	public void gettext(String locator) {

	}

	public void CloseBrowser() {
		driver.close();
	}
	
	

}
