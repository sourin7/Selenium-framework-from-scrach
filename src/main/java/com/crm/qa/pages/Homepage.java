package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Homepage extends Testbase{
	@FindBy(xpath="//td[contains(text(),'User: Demo Us')]")
	WebElement usernamelabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	//initializing the page objects:
		public Homepage() {
			PageFactory.initElements(driver, this);
		}
		public String verifyhomepagetitle() {
			return driver.getTitle();
		}
		public boolean verifyusername() {
			return usernamelabel.isDisplayed();
		}
		public Contactspage clickoncontactslink() {
			contactslink.click();
			return new Contactspage();
		}
		public Dealspage clickondealslink() {
			dealslink.click();
			return new Dealspage();
		}
		public Taskpage clickontaskslink() {
			taskslink.click();
			return new Taskpage();
		}
		public void clickonnewcontactlink() {
			Actions action=new Actions(driver);
			action.moveToElement(contactslink).build().perform();
			newcontactlink.click();
		}
		

}
