package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private  By courseEnrolList = By.xpath("//div[@class='course-listing-title']");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getAccoutPageTitle() 
	{
		return driver.getTitle();
	}
	
	public int getcourseEnrolListCount() 
	{
		return driver.findElements(courseEnrolList).size();
	}
	
	public List<String> getcourseEnrolList()
	{
		List<String> courseList = new ArrayList<>();
		List<WebElement> courseHeaderList = driver.findElements(courseEnrolList);
		
		for(WebElement e: courseHeaderList)
		{
			String text = e.getText();
			System.out.println(text);
			courseList.add(text);
		}
		
		return courseList;
	}
	
	
}
