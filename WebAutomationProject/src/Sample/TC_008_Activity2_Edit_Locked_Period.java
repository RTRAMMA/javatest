package Sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TC_008_Activity2_Edit_Locked_Period {
	// making an object globally
	FirefoxDriver driver;
	Map<String, Object> vars;
	JavascriptExecutor js;
	File f;
	FileReader fr;
	Properties prop;
	
	@BeforeMethod
	public void startBrowser() throws FileNotFoundException {
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://time.ibm.com/week");
	}
	@AfterMethod
	public void closeBrowser() {
		// driver.close();
	}
	@Test
	public void tc001() throws InterruptedException, IOException {
		// User credentials storage
		f = new File("./ConfigFiles/credentials.properties");
		fr = new FileReader(f);
		prop = new Properties();
		prop.load(fr);
		// Retrieve data from storage
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		Thread.sleep(9000);
		driver.findElement(By.id("credsDiv")).click();
		driver.findElement(By.id("user-name-input")).sendKeys(email);
		driver.findElement(By.id("password-input")).sendKeys(password);
		driver.findElement(By.name("checkbox1_lbl")).click();
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//button[contains(text(),'Close')]").click();
		
		driver.findElement(By.id("mat-select-value-1")).click();
		js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.cssSelector("#mat-option-52 app-locked-status svg")).click();
		
		   
		    driver.findElement(By.cssSelector(".ag-row:nth-child(2) .ag-group-contracted > .ag-icon")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[3]/div[2]/div/span/app-hour-renderer/span")).click();
		    driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		    driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//div[3]/div[3]/div/span/app-hour-renderer/span")).click();
		    driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
		    driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
		    driver.findElement(By.id("btn-timesheet-save")).click();
		    {
		      WebElement element = driver.findElement(By.id("btn-timesheet-submit"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    driver.findElement(By.id("btn-timesheet-submit")).click();
	}
}