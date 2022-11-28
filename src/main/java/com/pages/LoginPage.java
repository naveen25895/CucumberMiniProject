package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1.By Locators: Object Repository
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By signInButtom = By.xpath("//input[@name='commit']");	
	private By forgotPwdLink = By.partialLinkText("Forgot Password111");
	
	//2.constructor of the page class:
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3.Page actions: features(behavior) of the page the form of methods:
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(signInButtom).click();
	}
	
	public AccountsPage dologin(String un, String psw)
	{
		System.out.println("login with: "+ un + " and " + psw);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(signInButtom).click();
		return new AccountsPage(driver);
	}
	
}


