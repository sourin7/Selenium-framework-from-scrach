package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class Contactspage extends Testbase{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;

	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	//initializing the page objects:
			public  Contactspage() {
				PageFactory.initElements(driver, this);
			}
			public boolean verifyContactslabel() {
				return contactslabel.isDisplayed();
			}
			public void selectcontacts(String name) {
				driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
						+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
			}
		
			public void createnewcontact(String title, String ftname, String ltname, String comp) {
				Select select=new Select(driver.findElement(By.name("title")));
				select.selectByVisibleText(title);
				firstname.sendKeys(ftname);
				lastname.sendKeys(ltname);
				company.sendKeys(comp);
				savebtn.click();
				
			}

}
