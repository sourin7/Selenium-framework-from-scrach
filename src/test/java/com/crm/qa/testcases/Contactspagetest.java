package com.crm.qa.testcases;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class Contactspagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;
	Testutil testutil;
	Contactspage contactspage;
	String sheetName="contacts";
	public Contactspagetest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutil=new Testutil();
		contactspage=new Contactspage();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactspage=homepage.clickoncontactslink();

}
	@AfterMethod
	public void teardown() {
		driver.quit();

}
	@Test(priority=1)
	public void verifycontactspagelabeltest() {
		Assert.assertTrue(contactspage.verifyContactslabel(),"contacts label is missing");
	}
	@Test(priority=2)
	public void selectsinglecontactstest() {
		contactspage.selectcontacts("a b");
	}
	@Test(priority=3)
	public void selectmultiplecontactstest() {
		contactspage.selectcontacts("a b");
		contactspage.selectcontacts("aa bb");
	}
	@DataProvider
	public Object[][] getcrmtestdata() {
		Object data[][]=Testutil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=4, dataProvider = "getcrmtestdata")
	public void validatecreatenewcontact(String title, String firstname, String lastname, String company) {
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		homepage.clickonnewcontactlink();
		contactspage.createnewcontact(title, firstname, lastname, company);
		
	}
}
