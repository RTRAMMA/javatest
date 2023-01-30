package web.automation.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObjects extends TestBase {

	@FindBy(id = "user-name-input")
	WebElement email;

	@FindBy(id = "password-input")
	WebElement password;

	@FindBy(id = "credsDiv")
	WebElement credsDiv;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	@FindBy(css = "#mat-dialog-0")
	WebElement dialogBox;

	@FindBy(xpath = "//mat-dialog-actions/button")
	WebElement closeBtn;

	@FindBy(id = "mat-select-value-1")
	WebElement dropDown;

	@FindBy(css = "#mat-option-58 svg")
	WebElement imgStatus;

	// @FindBy(xpath = "//div[@class='statuses']")
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> weekSelect;

	// WebElement weekSelect;

	@FindBy(css = "#btn-copy-prev-week")
	WebElement copyFromPreviousWeekBtn;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okBtn;

	// @FindBy(css=".ag-cell-focus > .ag-cell-wrapper")
	// WebElement groupSpan;

	@FindBy(xpath = "//body[1]/app-root[1]/app-week-view-container[1]/app-unread-alerts[1]/div[1]/div[1]/app-alert[1]/div[1]/div[1]/div[3]/app-alert-rich-content[1]/span[1]")
	WebElement errorMessage;

	@FindBy(css = ".ag-cell-edit-input")
	WebElement inputHours;

	@FindBy(id = "profile")
	WebElement profileMenu;

	@FindBy(css = "#btn-logout > span")
	WebElement logoutBtn;

	//@FindBy(css = "#btn-toolbar-grid-switch .ds-pad-l-0_5")
	//WebElement compactBtn = driver.findElement(By.cssSelector("#btn-toolbar-grid-switch .ds-pad-l-0_5"));

	@FindBy(css = "#btn-toolbar-grid-switch .ds-pad-l-0_5")
	WebElement standardBtn;

	@FindBy(css = "#btn-toolbar-weekend > .mat-button-wrapper")
	WebElement showWeekBtn;

	@FindBy(css = "#btn-toolbar-weekend > .mat-button-wrapper")
	WebElement hideWeekBtn;

	@FindBy(css = "#btn-toolbar-expand svg")
	WebElement expandBtn;

	@FindBy(css = "#btn-toolbar-collapse svg")
	WebElement collapseBtn;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

}
