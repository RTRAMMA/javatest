package web.automation.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.web.automation.tescases.TC_003_Screenshot_Time;

public class HandlerClass extends HomePageObjects {
	String[] ScreenshotNames = new String[100];
	int array_increment = 0;

	public void enterEmail() throws Exception {
		email.sendKeys(PropertiesOperations.getPropertyValueByKey("email"));
	}

	public void enterPass() throws Exception {
		password.sendKeys(PropertiesOperations.getPropertyValueByKey("password"));
	}

	public void clickOnCredsDiv() {
		credsDiv.click();
	}

	public void clickOnSubmitBtn() {
		loginBtn.click();
	}

	public void checkDialogBox() {
		if (dialogBox.isDisplayed()) {
			System.out.println("Dialog box is Displayed");
		} else {
			System.out.println("Dialog box is not displayed");
		}
	}

	public void clickOnCloseBtn() {
		closeBtn.click();
	}

	public void clickOnSelectBtn() {
		dropDown.click();
	}

	public void selectWeek() {
		//weekSelect.get(59).click();
		weekSelect.get(58).click();
	}

	public void clickOnCopyFromPreviousWeek() {
		copyFromPreviousWeekBtn.click();
		okBtn.click();
	}

	public void inputHours() {

		for (int i = 2; i < 7; i++) {
			driver.findElement(By.xpath("//div[3]/div[" + i + "]/div/span/app-hour-renderer/span")).click();
			inputHours.sendKeys("8");
			inputHours.sendKeys(Keys.ENTER);
		}

	}

	public void logout() {
		profileMenu.click();
		logoutBtn.click();
	}

	public void clickOnLockedWeek() {
		weekSelect.get(57).click();
	}

	public void verifyErrorMessage() {
		String actualMessage = errorMessage.getText();
		String expectedMessage = "Week ending January 28, 2022 is locked in BMS. You may not be able to submit labor.";

		Assert.assertEquals(actualMessage, expectedMessage, "Error Message does not match");
	}

	public static void capture(WebDriver compactBtn, String name) throws IOException {

		Date currentdate = new Date();
		System.out.println("the date is" + currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		File screenshotFile = ((TakesScreenshot) compactBtn).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//ScreenshotFile//" + name + "-" + screenshotfilename + ".png"));		
		
	

	}

	public void takeScreenShot() throws IOException {
		//compactBtn.click();
		
		driver.findElement(By.cssSelector("#btn-toolbar-grid-switch .ds-pad-l-0_5")).click();
		HandlerClass.capture(driver,ScreenshotNames[array_increment++]="Sw to Compact View");
		//HandlerClass.capture(compactBtn, ScreenshotNames[array_increment++] = "Sw to Compact View");
	}

}
