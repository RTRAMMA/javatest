package org.web.automation.tescases;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Time_ibm_web extends BaseClass {

	@Parameters("browser")
	@Test()
	public static void LoginTest() {

		// Navigate through Login page
		driver.findElement(By.id("credsDiv")).click();

	}
}
