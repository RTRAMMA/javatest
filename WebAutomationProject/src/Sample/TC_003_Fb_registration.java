package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import verify.Compare;

public class TC_003_Fb_registration {

	WebDriver driver;
	
	
	@BeforeMethod
	public void createDriver()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void testcase1() {
		driver.findElement(By.id("email")).sendKeys("Hello");
		boolean result = Compare.validateTextPresentOnElement(driver, "class", "_8esh", "Create a Page");
		Assert.assertTrue(result, "[Error - Element not found]");
		
	}
	
}
