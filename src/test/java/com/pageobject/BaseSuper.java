package com.pageobject;


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
import org.testng.annotations.BeforeMethod;

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
	
	
	
	
	
	
	

}
