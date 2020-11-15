package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class Homepagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;
	Testutil testutil;
	Contactspage contactspage;

	public Homepagetest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutil=new Testutil();
		contactspage=new Contactspage();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test(priority=1)
	public void verifyhomepagetitletest() {
		String homepagetitle=homepage.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","home page title not matched");
	}
	@Test(priority=2)
	public void verifyusernametest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifyusername());
	}
	@Test(priority=3)
	public void verifycontactlisttest() {
		testutil.switchtoframe();
		contactspage=homepage.clickoncontactslink();
	}
}