package verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {
	
	public static boolean validateTextPresentOnElement(WebDriver driver, String locType, String locValue, String expText) {
		
		boolean result = false;
		String actValue="";
		
		try 
		{
			if(locType.equalsIgnoreCase("xpath"))
			{
				actValue = driver.findElement(By.xpath(locValue)).getText();
				
			}
			else if (locType.equalsIgnoreCase("id"))
			{
				actValue = driver.findElement(By.id(locValue)).getText();
			}
			else if (locType.equalsIgnoreCase("class"))
			{
				actValue = driver.findElement(By.className(locValue)).getText();
			}
			if(actValue.equals(expText))
			{
				result = true;
			}
		}
		catch(Exception e) {}
		return result;
	}
}