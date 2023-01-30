package Sample;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import web.automation.testcases.HandlerClass;

public class ErrorTests_motorcycle extends HandlerClass {
	
	@Test
	public void TC00_1() throws Exception {
		LaunchBrowserAndNavigate("chromeBrowser");
		homepage = new HandlerClass();
		
		homepage.clickOnCredsDiv();
		homepage.enterEmail();
		homepage.enterPass();
		homepage.clickOnSubmitBtn();
		homepage.checkDialogBox();
		//Task1- Alert Box Should be in conditional Statement
		homepage.clickOnCloseBtn();
		homepage.clickOnSelectBtn();
		//Task2- Use of Select 
		//Put in Array, (check if the svg is available, if yes=next[currentIndex->nextIndex], else Click)
		homepage.selectWeek();
		
		homepage.clickOnCopyFromPreviousWeek();
		homepage.inputHours();
		
		homepage.logout();
		
	}
}
