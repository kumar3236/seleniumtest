package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobject.BaseSuper;
import com.pageobject.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseSuper {
	
	private WebDriver driver; 
	private Login loginPage; 
	 private BaseSuper base;
	@BeforeMethod 
	public void setUp() {
		
		
		 WebDriverManager.chromedriver().browserVersion("135.0.7049.42").setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
		 loginPage = new Login(driver);
		} 
	  @Test 
	  public void testLogin() throws InterruptedException {
		  
		// Test case for logging in 
		  loginPage.enterUserName("Admin");
		  loginPage.enterPassword("admin123"); 
		  loginPage.clickLoginButton(); 
		  // Add assertions as needed to verify successful login (e.g., checking page title) 
		  } 
	   @AfterClass 
	   public void tearDown() {
		
		   
	  // Quit the WebDriver after test execution 
	   if (driver != null) { 
	   driver.quit(); 
	  
	}

	   }
   }
