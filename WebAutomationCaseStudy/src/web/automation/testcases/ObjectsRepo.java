package web.automation.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectsRepo extends TestBase{
	@FindBy(id = "user-name-input")
	WebElement email;

	@FindBy(id = "password-input")
	WebElement password;

	@FindBy(id = "credsDiv")
	WebElement credsDiv;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	@FindBy(id = "mat-dialog-0")
	WebElement dialogBox;

	@FindBy(xpath = "//mat-dialog-actions/button")
	WebElement closeBtn;

	@FindBy(id = "mat-select-value-1")
	WebElement dropDown;

	@FindBy(css = "#mat-option-58 svg")
	WebElement imgStatus;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> weekSelect;

	@FindBy(css = "#btn-copy-prev-week")
	WebElement copyFromPreviousWeekBtn;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okBtn;

	@FindBy(css = ".ng-tns-c92-10 > span")
	WebElement errorMessage;

	@FindBy(css = ".ag-cell-edit-input")
	WebElement inputHours;

	@FindBy(id = "profile")
	WebElement profileMenu;

	@FindBy(css = "#btn-logout > span")
	WebElement logoutBtn;

	@FindBy(css = "#btn-toolbar-grid-switch .ds-pad-l-0_5")
	WebElement compactBtn;

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

	@FindBy(id = "btn-toolbar-undo")
	WebElement undoBtn;

	@FindBy(css = ".mat-dialog-actions > .ds-button")
	WebElement undoOkBtn;

	@FindBy(xpath = "//body[1]/app-root[1]")
	WebElement rootScreen;

	public ObjectsRepo() {
		PageFactory.initElements(driver, this);
	}
}

