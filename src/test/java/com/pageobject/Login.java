package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BaseSuper {
	
	private BaseSuper base;
	private WebDriver driver; 
	private By userName = By.xpath("//div[@class='oxd-form-row']/div/div/following-sibling::div/child::input[contains(@name,'username')]"); 
	private By passWord = By.xpath("//input[contains(@placeholder,'Password')]"); 
	private By loginButton = By.xpath("//button[contains(@type,'submit')]"); 
	private By dashboard= By.xpath("//span/h6[contains(.,'Dashboard')]");
	public Login(WebDriver driver) {
		this.driver= driver; 
		} 
	
	public void enterUserName(String username) throws InterruptedException {
	//	base.waitForElement(driver, userName, 10); 
		Thread.sleep(2000);
		WebElement userNameInput = driver.findElement(userName);
		userNameInput.sendKeys(username); 
		
		} 
	
	public void enterPassword(String password) {
		WebElement userPasswordInput = driver.findElement(passWord); 
		userPasswordInput.sendKeys(password); 
		}
	
	public String clickLoginButton() throws InterruptedException { 
		WebElement button = driver.findElement(loginButton); 
		button.click();
        Thread.sleep(2000);
		WebElement dash= driver.findElement(dashboard);
		String expectedtext=dash.getText();
		System.out.println(expectedtext);
		return expectedtext;
		
		
	}

}
