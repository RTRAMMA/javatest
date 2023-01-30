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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class TC_001_Registration_Functionality {
    
	//making an object globally
	File f;
	FileReader fr;
	Properties prop;
	ChromeDriver driver;
	
	//for ngModel
	NgWebDriver ngDriver;
	
	@BeforeMethod
	public void startBrowser() throws FileNotFoundException {
		
		//Relative path of the Chrome driver inside the ProjectFolder
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		//Maximize current window
		driver.manage().window().maximize();
		//Setting max time to wait to load a page
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		//Setting max time to wait to search an element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//URL time@ibm
		driver.get("https://time.ibm.com/week");
		
	}	
	@AfterMethod
	public void closeBrowser() {
		
	//	driver.close();
	}
	@Test
	public void tc001() throws InterruptedException, IOException {
		
		//User credentials storage
		f = new File("./ConfigFiles/credentials.properties");
		fr = new FileReader(f);
		prop = new Properties();
		prop.load(fr);
		
		//Retrieve data from storage
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");		
		
		//Navigate through Login page
		driver.findElement(By.id("credsDiv")).click();
		driver.findElement(By.id("user-name-input")).sendKeys(email);
		driver.findElement(By.id("password-input")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		//Navigate - close button
		driver.findElementByXPath("//button[contains(text(),'Close')]").click();
		
		//Selection button
		driver.findElementByXPath("//mat-select[@id='mat-select-week-ending-dropdown']/div/div[2]").click();
		driver.findElementByCssSelector("#mat-option-58 > .mat-option-text").click();
		
		//Clicking Copy from Previous Week
		driver.findElementByXPath("//body/app-root[1]/app-week-view-container[1]/div[3]/div[1]/app-modern-grid-container[1]/div[1]/app-empty-grid-empty[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]").click();
		driver.findElementByXPath("//button[contains(text(),'Ok')]").click();
		
		//Input data
		driver.findElement(By.xpath("//div[3]/div[2]/div/span/app-hour-renderer/span")).click();
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[3]/div[3]/div/span/app-hour-renderer/span")).click();
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[3]/div[4]/div/span/app-hour-renderer/span")).click();
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[3]/div[5]/div/span/app-hour-renderer/span")).click();
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[3]/div[6]/div/span/app-hour-renderer/span")).click();
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);	
	}
}
