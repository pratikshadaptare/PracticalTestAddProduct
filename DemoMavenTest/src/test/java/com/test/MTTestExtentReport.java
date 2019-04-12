package com.test;

import org.testng.annotations.Test;

import com.Listener.MyListener;
import com.pages.MTHomePage;
import com.pages.MTRegisterPage;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MTTestExtentReport extends MyListener {
	WebDriver driver;
	MTHomePage mhp;
	MTRegisterPage mrp;
		
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");		
		
		mhp = PageFactory.initElements(driver, MTHomePage.class);
		mrp = PageFactory.initElements(driver, MTRegisterPage.class);
	}
	
	@Test
	public void testMT() {
		
		mhp.clickRegister();	
		mrp.sendUserInfo();		
		mrp.signOFF();	
		mhp.clickHome();	
		mhp.login();
		test.log(LogStatus.INFO, "the test tours is passed");
	//	Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours: ");
	}

	@AfterTest
	public void afterTest() {
		mhp = null;
		mrp = null;
		driver.close();
	}
}
