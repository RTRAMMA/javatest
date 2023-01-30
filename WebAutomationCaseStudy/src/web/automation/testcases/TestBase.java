package web.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	public static HandlerClass homepage;
	public static WebDriver driver = null;

	public void LaunchBrowserAndNavigate(String browserName) throws Exception {
		// read property file and get browser url
		String browser = PropertiesOperations.getPropertyValueByKey(browserName);
		String url = PropertiesOperations.getPropertyValueByKey("testurl");

		// you will input the browser you want to automate
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@BeforeMethod
	public void setupMethod() throws Exception {
		homepage = new HandlerClass();
	}

	@AfterMethod
	public void cleanUp() {
		//driver.quit();
	}
}
