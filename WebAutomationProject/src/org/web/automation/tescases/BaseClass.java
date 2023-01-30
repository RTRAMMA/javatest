package org.web.automation.tescases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	static String email = prop.getProperty("email");
	static String password = prop.getProperty("password");
	
	public void setUp(String browser) throws IOException {
		
		//Instantiate the driver, initially it's null
		if(driver == null) {
			FileReader fr = new FileReader("C:\\Users\\P1027VPH1\\eclipse-workspace\\WebAutomationProject\\ConfigFiles\\config.properties");
			prop.load(fr);
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
	}
	
	public void tearDown() {

		driver.close();
		System.out.println("Logging out");
	}
}
