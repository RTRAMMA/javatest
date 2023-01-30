package web.automation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase extends ObjectsRepo {

	public static WebDriver driver = null;

	public void LaunchBrowserAndNavigate(String browserName) throws Exception {
		// read property file and get browser url
		String browser = PropertiesOperations.getPropertyValueByKey(browserName);
		String url = PropertiesOperations.getPropertyValueByKey("testurl");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
