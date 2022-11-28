package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {

	private WebDriver driver;

	private By bgstatusdone = By.xpath("//label[@for='done']");
	private By bgstatuspending = By.xpath("//label[@for='pending']");
	private By firstname = By.xpath("//input[@id='fname']");
	private By lastname = By.xpath("//input[@id='lname']");
	private By email = By.id("email");
	private By address = By.xpath("//textarea[@id='message']");
	private By phonenumber = By.id("telephoneno");
	private By sendButton = By.xpath("//input[@type='submit']");
	private By successMsg = By.xpath("//b[contains(text(),'Please Note Down Your CustomerID')]");

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAddCustomerPageTitle() {
		return driver.getTitle();
	}
	
	public void fillAddCustomerForm(String bgstatus, String fsnm, String lsnm, String mail, String adrs, String phno) {
		if(bgstatus.equals("done")) 
		{
			driver.findElement(bgstatusdone).click();
		}
		else if(bgstatus.equals("pending"))
		{
			driver.findElement(bgstatuspending).click();
		}
		driver.findElement(firstname).sendKeys(fsnm);
		driver.findElement(lastname).sendKeys(lsnm);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(address).sendKeys(adrs);
		driver.findElement(phonenumber).sendKeys(phno);
	}

	public void clickSend() {
		driver.findElement(sendButton).click();
	}
	
	public String getSuccessMessg() {
		return driver.findElement(successMsg).getText();
	}
}
