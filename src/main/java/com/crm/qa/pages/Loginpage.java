package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Loginpage extends Testbase{
	//Page factory-OR
	@FindBy(name="username")
	WebElement username; 
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo; 
	//initializing the page objects:
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	//actions:
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	public boolean validatecrmlogo() {
		return crmlogo.isDisplayed();
	}
	public Homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new Homepage();
	}

}
