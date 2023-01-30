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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HandlerClass extends ObjectsRepo {

	String[] ScreenshotNames = new String[100];
	int array_increment = 0;

	public void enterEmail() throws Exception {
		email.sendKeys(PropertiesOperations.getPropertyValueByKey("email"));
	}

	public void enterPass() throws Exception {
		password.sendKeys(PropertiesOperations.getPropertyValueByKey("password"));
	}

	public void clickOnCredsDiv() {
		explicitWait("credsDiv");
		credsDiv.click();
	}

	public void explicitWait(String loc) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
	}

	public void clickOnSubmitBtn() {
		loginBtn.click();
	}

	public void checkDialogBox() {
		explicitWait("mat-dialog-0");

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
		weekSelect.get(62).click();

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

	public void selectLockedWeek() {
		weekSelect.get(57).click();
	}

	public void verifyErrorMessage() {
		String actualMessage = errorMessage.getText();
		String expectedMessage = "Week ending January 28, 2022 is locked in BMS. You may not be able to submit labor.";
		Assert.assertEquals(actualMessage, expectedMessage, "Error Message does not match");
	}

	public void selectWeekSaved() {
		weekSelect.get(60).click();
	}

	public static void capture(WebElement driver, String name) throws IOException {

		Date currentdate = new Date();
		System.out.println("the date is" + currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + "-" + name + ".png"));

	}

	public void takeScreenShot() throws IOException {

		compactBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Sw to Compact View");
		standardBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Sw to Standard View");
		showWeekBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Show Weekend");
		hideWeekBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Hide Weekend");
		expandBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Expand All");
		collapseBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Collapse All");
		undoBtn.click();
		undoOkBtn.click();
		HandlerClass.capture(rootScreen, ScreenshotNames[array_increment++] = "Undo");

	}

}
