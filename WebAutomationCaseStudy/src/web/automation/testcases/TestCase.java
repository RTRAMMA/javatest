package web.automation.testcases;

import org.testng.annotations.Test;

public class TestCase extends HandlerClass {

	@Test(priority =1, description="Copy from Previous Week and input hours ")
	public void TC_001() throws Exception {
		LaunchBrowserAndNavigate("chromeBrowser");
		homepage = new HandlerClass();
		homepage.clickOnCredsDiv();
		homepage.enterEmail();
		homepage.enterPass();
		homepage.clickOnSubmitBtn();
		homepage.checkDialogBox();
		homepage.clickOnCloseBtn();
		homepage.clickOnSelectBtn();
		homepage.selectWeek();
		homepage.clickOnCopyFromPreviousWeek();
		homepage.inputHours();
		homepage.logout();

	}

	@Test(priority = 2, description="Verify the Error Message")
	public void TC_002() throws Exception {
		LaunchBrowserAndNavigate("firefoxBrowser");
		homepage = new HandlerClass();
		homepage.clickOnCredsDiv();
		homepage.enterEmail();
		homepage.enterPass();
		homepage.clickOnSubmitBtn();
		homepage.checkDialogBox();
		homepage.clickOnCloseBtn();
		homepage.clickOnSelectBtn();
		homepage.selectLockedWeek();
		homepage.verifyErrorMessage();
		homepage.logout();
	}

	@Test(priority = 3, description = "Take Screenshot view buttons")
	public void TC_003() throws Exception {
		LaunchBrowserAndNavigate("chromeBrowser");
		homepage = new HandlerClass();
		homepage.clickOnCredsDiv();
		homepage.enterEmail();
		homepage.enterPass();
		homepage.clickOnSubmitBtn();
		homepage.checkDialogBox();
		homepage.clickOnCloseBtn();
		homepage.clickOnSelectBtn();
		homepage.selectWeekSaved();
		homepage.takeScreenShot();
		homepage.logout();
	}
}
