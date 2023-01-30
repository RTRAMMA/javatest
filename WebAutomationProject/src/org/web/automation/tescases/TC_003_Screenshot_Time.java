package org.web.automation.tescases;

	import java.io.File;
	import java.awt.image.BufferedImage;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
	import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import verify.Compare;

	public class TC_003_Screenshot_Time {
		File f;
		FileReader fr;
		Properties prop;
		FirefoxDriver driver;
		String[] ScreenshotNames = new String[100];
		int array_increment = 0;
	
		@BeforeMethod
		public void startBrowser() throws IOException, InterruptedException {
			
			//Relative path of the Chrome driver inside the ProjectFolder
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			//Maximize current window
			driver.manage().window().maximize();
			//Setting max time to wait to load a page
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			//Setting max time to wait to search an element
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			//URL time@ibm
			driver.get("https://time.ibm.com/week");

		
		}	
		 public static void capture(WebDriver driver, String name) throws IOException
		{
		
			Date currentdate = new Date();
			System.out.println("the date is"+currentdate);
			String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
			System.out.println(screenshotfilename);
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+ name +"-"+screenshotfilename+".png") );
		
		}	
		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}
		
		@Test
		public void tc001() throws InterruptedException, IOException, XmlException {
		
			//User credentials storage
			f = new File("./ConfigFiles/credentials.properties");
			fr = new FileReader(f);
			prop = new Properties();
			prop.load(fr);
			
			//Retrieve data from storage
			String email = prop.getProperty("email");
			String password = prop.getProperty("password");		
			Thread.sleep(15000);
			//Navigate through Login page
			driver.findElement(By.id("credsDiv")).click();
			driver.findElement(By.id("user-name-input")).sendKeys(email);
			driver.findElement(By.id("password-input")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			
			//Navigate - close button
			driver.findElementByXPath("//button[contains(text(),'Close')]").click();
			
			//Selection button
			driver.findElementByXPath("//mat-select[@id='mat-select-week-ending-dropdown']/div/div[2]").click();
			driver.findElementByCssSelector("#mat-option-58 > .mat-option-text").click();
			
			//Clicking Copy from Previous Week
			driver.findElementByXPath("//body/app-root[1]/app-week-view-container[1]/div[3]/div[1]/app-modern-grid-container[1]/div[1]/app-empty-grid-empty[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]").click();
			driver.findElementByXPath("//button[contains(text(),'Ok')]").click();
			
			//Input data
			driver.findElement(By.xpath("//div[3]/div[2]/div/span/app-hour-renderer/span")).click();
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[3]/div[3]/div/span/app-hour-renderer/span")).click();
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[3]/div[4]/div/span/app-hour-renderer/span")).click();
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[3]/div[5]/div/span/app-hour-renderer/span")).click();
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[3]/div[6]/div/span/app-hour-renderer/span")).click();
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys("8");
			driver.findElement(By.cssSelector(".ag-cell-edit-input")).sendKeys(Keys.ENTER);

			Thread.sleep(5000);
			//Switch to Compact view
			driver.findElement(By.cssSelector("#btn-toolbar-grid-switch .ds-pad-l-0_5")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Sw to Compact View");
			
			//Switch to Standard View
			driver.findElement(By.cssSelector("#btn-toolbar-grid-switch .ds-pad-l-0_5")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Sw to Standard View");
			
			//Show Weekends
			driver.findElement(By.cssSelector("#btn-toolbar-weekend > .mat-button-wrapper")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Show Weekend");
			
			//Hide Weekends
			driver.findElement(By.cssSelector("#btn-toolbar-weekend > .mat-button-wrapper")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Hide Weekend");
			
			//Expand All
			driver.findElement(By.cssSelector("#btn-toolbar-expand svg")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Expand All");
			
			//Collapse All
			driver.findElement(By.cssSelector("#btn-toolbar-collapse svg")).click();
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Collapse All");
			
			
			//Undo - back to homepage
			driver.findElement(By.id("btn-toolbar-undo")).click();
			driver.findElement(By.cssSelector(".mat-dialog-actions > .ds-button")).click();
			Thread.sleep(10000);
			TC_003_Screenshot_Time.capture(driver,ScreenshotNames[array_increment++]="Undo");
			
			//TC_003_Screenshot_Time.saveScreenshotsToWordDocument("Regression_Results",ScreenshotNames);
		}
		/*
		public static void saveScreenshotsToWordDocument(String documentName, String[] screenshotNames) throws IOException, XmlException {
			// TODO Auto-generated method stub
			System.out.println("Document Name is :" +documentName);
			System.out.println("Image file is :" +screenshotNames[0]);
			System.out.println("Image file is :" +screenshotNames[1]);
			System.out.println("Image file is :" +screenshotNames[2]);
			System.out.println("Image file is :" +screenshotNames[3]);
			System.out.println("Image file is :" +screenshotNames[4]);
			System.out.println("Image file is :" +screenshotNames[5]);
			System.out.println("Image file is :" +screenshotNames[6]);
			
			//Create Instances for document, paragraphs, styles..
			XWPFDocument doc = new XWPFDocument(); //document object
			XWPFParagraph p = doc.createParagraph(); //paragraph alignments, borders and all
			XWPFRun r = p.createRun();//Set font styles, colors, next line..
			
			//Header and Footer objects
			CTSectPr secPr = doc.getDocument().getBody().addNewSectPr();
			XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc,secPr);
			
			//Create Headers
			CTP ctpHeader = CTP.Factory.newInstance();
			CTR ctrHeader = ctpHeader.addNewR();
			CTText ctHeader = ctrHeader.addNewT();
			
			//Alignments and color, styles of header in the word doc. -- Header
			XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, doc);
			XWPFRun headerRun = headerParagraph.createRun();
			
			//Setting Header
			headerParagraph.setAlignment(ParagraphAlignment.LEFT);
			headerRun.setFontSize(10);
			headerRun.setColor("808000");
			headerRun.setText("Time@ibm Test Results");
			headerRun.addBreak();
			String curr_date = getCurrentDate("yyyy-MM-dd-hh:mm:ss");
			headerRun.setText(curr_date);
			
			//Parse
			XWPFParagraph[] parsHeader = new XWPFParagraph[1];
			parsHeader[0] = headerParagraph;
			policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT,parsHeader);
			
			//Create Footer Objects
			CTP ctpFooter = CTP.Factory.newInstance();
			CTR ctrFooter = ctpFooter.addNewR();
			CTText ctFooter = ctrFooter.addNewT();
			
			//Setting Footer
			String footerText = "2022. Confidential - Do not share this documents";
			ctFooter.setStringValue(footerText);
			
			//Alignments and color, styles of header in the word doc. -- Footer
			XWPFParagraph footerparagraph = new XWPFParagraph(ctpFooter, doc);
			footerparagraph.setAlignment(ParagraphAlignment.LEFT);
			
			//Parse
			XWPFParagraph[] parsFooter = new XWPFParagraph[1];
			parsFooter[0] = footerparagraph;
			policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT,parsFooter);
			
			//Title in the center (Test Scenario Name)
			p.setAlignment(ParagraphAlignment.CENTER);
			r.setBold(true);
			r.setFontFamily("Verdana");
			r.setText(documentName);
			r.addBreak();
			
			BufferedImage bimg;
			
			for(String file : screenshotNames)
			{
				try 
				{
					System.out.println("test documents");
					File dest = new File(System.getProperty("user.dir")+ " .//Test Documents//" + file + ".jpg");
					bimg = ImageIO.read(dest);
					
					int width = 500;
					int height = 280;
					
					String imgFile = dest.getName();
					int imgFormat = getImageFormat(imgFile);
				
					r.addBreak();
					r.addBreak();
					r.addBreak();
					r.addBreak();
					r.addBreak();
					r.addBreak();
					r.addBreak();
					
					r.setText(file);
					r.addPicture(new FileInputStream(dest), imgFormat, imgFile, width, height);
				}
				catch(Exception e)
				{
					continue;
				}
				
				FileOutputStream out = new FileOutputStream(System.getProperty("user.dir" + ".//screenshot//" +".docx"));
				doc.write(out);
				out.close();
				
			}
		}
		private static int getImageFormat(String imgFileName) {
			// TODO Auto-generated method stub
			int format;
			if(imgFileName.endsWith(".emf"))
				format = XWPFDocument.PICTURE_TYPE_EMF;
			else if (imgFileName.endsWith(".wmf"))
				format = XWPFDocument.PICTURE_TYPE_WMF;
			else if (imgFileName.endsWith(".pict"))
				format = XWPFDocument.PICTURE_TYPE_PICT;
			else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
				format = XWPFDocument.PICTURE_TYPE_JPEG;
			else if (imgFileName.endsWith(".png"))
				format = XWPFDocument.PICTURE_TYPE_PNG;
			else if (imgFileName.endsWith(".dib"))
				format = XWPFDocument.PICTURE_TYPE_DIB;
			else if (imgFileName.endsWith(".gif"))
				format = XWPFDocument.PICTURE_TYPE_GIF;
			else if (imgFileName.endsWith(".tiff"))
				format = XWPFDocument.PICTURE_TYPE_TIFF;
			else if (imgFileName.endsWith(".eps"))
				format = XWPFDocument.PICTURE_TYPE_EPS;
			else if (imgFileName.endsWith(".bmp"))
				format = XWPFDocument.PICTURE_TYPE_BMP;
			else if (imgFileName.endsWith(".wpg"))
				format = XWPFDocument.PICTURE_TYPE_WPG;
			else {
				return 0;
			}
			return format;
		}
		private static String getCurrentDate(String format) {
			// TODO Auto-generated method stub
			
			DateFormat dateformat = new SimpleDateFormat(format);
			Date date = new Date();
			return dateformat.format(date);
		}*/
	}
