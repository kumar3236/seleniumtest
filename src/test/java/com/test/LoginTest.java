package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobject.BaseSuper;
import com.pageobject.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseSuper {
	
	private WebDriver driver; 
	private Login loginPage; 
	

	@BeforeMethod 
	public void setUp() {
		
		//browserVersion("138.0.7151.120")
		 WebDriverManager.chromedriver().setup();
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
		     String dashboardText=loginPage.clickLoginButton(); 
		     String expectedTitle = "Dashboard";
		  
		    Assert.assertEquals(dashboardText, expectedTitle, "Login pass: Title match");
		  // Add assertions as needed to verify successful login (e.g., checking page title) 
		  } 
	   

	  @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	  
   }
