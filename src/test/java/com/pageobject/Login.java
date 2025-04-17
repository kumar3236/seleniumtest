package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BaseSuper {
	
	private BaseSuper base;
	private WebDriver driver; 
	private By userName = By.xpath("//input[contains(@class, 'oxd-input') and @name='username']"); 
	private By passWord = By.xpath("//input[contains(@placeholder,'Password')]"); 
	private By loginButton = By.xpath("//button[contains(@type,'submit')]"); 
	
	public Login(WebDriver driver) {
		this.driver= driver; 
		} 
	
	public void enterUserName(String username) throws InterruptedException {
	//	base.waitForElement(driver, userName, 10); 
		Thread.sleep(10000);
		WebElement userNameInput = driver.findElement(userName);
		userNameInput.sendKeys(username); 
		String text=userNameInput.getText();
		System.out.println(text);
		
		
		//base.waitForElement(driver, userName, 10);
		
		//base.action(userNameInput, username);
		} 
	
	public void enterPassword(String password) {
		WebElement userPasswordInput = driver.findElement(passWord); 
		userPasswordInput.sendKeys(password); 
		}
	
	public void clickLoginButton() { 
		WebElement button = driver.findElement(loginButton); 
		button.click();
		
	}

}
