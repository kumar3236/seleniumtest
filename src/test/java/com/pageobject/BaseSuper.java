package com.pageobject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSuper {

	static WebDriver driver = null; 
	public static WebDriver getDriver(String browserType) { 
		 //driver = null; 
		if (browserType.equalsIgnoreCase("chrome")) { 
			
			WebDriverManager.chromedriver().setup(); 
			
			driver = new ChromeDriver(); 
			
		} 
		
		else if (browserType.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
			
		} 
		
		else { throw new IllegalArgumentException("Unsupported browser: " + browserType); 
		
		} 
		
		driver.manage().window().maximize(); driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		return driver;
		
	} 
	
	public static void navigateTo(String name) {
		driver.navigate().to(name);

	}
	
	 public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	 public static void capturePageDetails(WebDriver driver, String screenshotFilePath) {
	        try {
	            // Print the page source to the console
	            System.out.println(driver.getPageSource());

	            // Take a screenshot and save it to the specified path
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshot, new File(screenshotFilePath));

	            System.out.println("Screenshot saved at: " + screenshotFilePath);
	        } catch (IOException e) {
	            System.err.println("Failed to capture page details: " + e.getMessage());
	        }
	    }
	 
//	public static void Sleep(int value) throws Throwable {
//		Thread.sleep(value);
//
//	}
//
//	public static void implicitlyWait(int value) {
//		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
//
//	}
//
//	public static void sendKey(WebElement element, String value) {
//		element.sendKeys(value);
//	}
//
//	public static void click(WebElement element) {
//		element.click();
//	}
//
//	public static void selection(WebElement element, String values) {
//		Select day = new Select(element);
//		day.selectByVisibleText(values);
//
//	}
//
//	public static void alert(String alerttype) {
//		Alert alert = driver.switchTo().alert();
//		if (alerttype.equalsIgnoreCase("accept")) {
//			alert.accept();
//
//		} else if (alerttype.equalsIgnoreCase("dismiss")) {
//			alert.dismiss();
//		} else if (alerttype.equalsIgnoreCase("getText")) {
//			String text = alert.getText();
//			System.out.println(text);
//		}
//	}
//
//	public static void dropDown(WebElement element, String type, String value) {
//		Select Se = new Select(element);
//		if (type.equalsIgnoreCase("values")) {
//			Se.selectByValue(value);
//
//		} else if (type.equalsIgnoreCase("text")) {
//			Se.selectByVisibleText(value);
//
//		} else if (type.equalsIgnoreCase("index")) {
//			int parseInt = Integer.parseInt(value);
//			Se.selectByIndex(parseInt);
//
//		}
//
//	}
//
	public static void action(WebElement element, String type) {
		Actions A= new Actions(driver);
				
		if (type.equalsIgnoreCase("move")) {
			A.moveToElement(element).build().perform();
		} else if (type.equalsIgnoreCase("click")) {
			A.click().build().perform();

		} else if (type.equalsIgnoreCase("DoubbleClick")) {
			A.doubleClick().build().perform();

		}

	}

}
