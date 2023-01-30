package org.web.automation.tescases;

	import java.io.File;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import verify.Compare;

	public class TC_002_Locked_Time {
		
		
		@Test
		public void test1() throws InterruptedException, IOException {
			//making an object globally
			File f;
			FileReader fr;
			Properties prop;
			FirefoxDriver driver;
			
			//Relative path of the Chrome driver inside the ProjectFolder
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			
			//Maximize current window
			driver.manage().window().maximize();
			
			//Setting max time to wait to load a page
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			//Setting max time to wait to search an element
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//URL time@ibm
			driver.get("https://time.ibm.com/week");
			
			//User credentials storage
			f = new File("./ConfigFiles/credentials.properties");
			fr = new FileReader(f);
			prop = new Properties();
			prop.load(fr);
			
			//Retrieve data from storage
			String email = prop.getProperty("email");
			String password = prop.getProperty("password");		
			
			//Navigate through Login page
			Thread.sleep(10000);
			driver.findElement(By.id("credsDiv")).click();
			driver.findElement(By.id("user-name-input")).sendKeys(email);
			driver.findElement(By.id("password-input")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(25000);
			
			//Navigating through time@ibm 
			driver.findElementByXPath("//button[contains(text(),'Close')]").click();
		
			driver.findElementByCssSelector(".mat-select-arrow-wrapper").click();
			driver.findElementByCssSelector("#mat-option-52 > .mat-option-text").click();
			Thread.sleep(15000);
			
			String text1 = "Week ending December 24, 2021 is locked in BMS. You may not be able to submit labor!!";
			
			String text2 = driver.findElement(By.xpath("//app-alert-rich-content/span")).getText();
			
			//Test1 - Failed
			if(text1.equals(text2))
			{
				System.out.println("Test 1: Passed");
			}
			else
			{
				System.out.println("Test 1: Failed");
			}
			
			driver.close();
			//assertEquals(text1,text1, "Invalid");
			
			//boolean result = Compare.validateTextPresentOnElement(driver, "xpath", "//app-alert-rich-content/span", "Week ending December 24, 2021 is locked in BMS. You may not be able to submit labor.");
			//Assert.assertEquals(result,"[Error - Text Not Matched]");
		}
		
		@Test
		public void test2() throws InterruptedException, IOException {
			//making an object globally
			File f;
			FileReader fr;
			Properties prop;
			FirefoxDriver driver;
			
			//Relative path of the Chrome driver inside the ProjectFolder
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			//Maximize current window
			driver.manage().window().maximize();
			//Setting max time to wait to load a page
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
			//URL time@ibm
			driver.get("https://time.ibm.com/week");
			
			//User credentials storage
			f = new File("./ConfigFiles/credentials.properties");
			fr = new FileReader(f);
			prop = new Properties();
			prop.load(fr);
			
			//Retrieve data from storage
			String email = prop.getProperty("email");
			String password = prop.getProperty("password");		
			
			//Navigate through Login page
			Thread.sleep(25000);
			driver.findElement(By.id("credsDiv")).click();
			driver.findElement(By.id("user-name-input")).sendKeys(email);
			driver.findElement(By.id("password-input")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(25000);
			
			//Navigating through time@ibm 
			driver.findElementByXPath("//button[contains(text(),'Close')]").click();
		
			driver.findElementByCssSelector(".mat-select-arrow-wrapper").click();
			driver.findElementByCssSelector("#mat-option-52 > .mat-option-text").click();
			Thread.sleep(15000);
			
			String text1 = "Week ending December 24, 2021 is locked in BMS. You may not be able to submit labor.";
			
			String text2 = driver.findElement(By.xpath("//app-alert-rich-content/span")).getText();
			
			//Test2 - Passed
			if(text1.equals(text2))
			{
				System.out.println("Test 2: Passed");
			}
			else
			{
				System.out.println("Test 2: Failed");
			}
			
			driver.close();
			//assertEquals(text1,text1, "Invalid");
			
			//boolean result = Compare.validateTextPresentOnElement(driver, "xpath", "//app-alert-rich-content/span", "Week ending December 24, 2021 is locked in BMS. You may not be able to submit labor.");
			//Assert.assertEquals(result,"[Error - Text Not Matched]");
		}
	}
