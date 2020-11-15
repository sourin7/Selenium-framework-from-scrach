package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public Testbase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\souri\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		    prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\souri\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\souri\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver");
			driver=new FirefoxDriver();
	}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver; 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

}
}
