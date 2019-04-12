package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MTHomePage {
	WebDriver driver;
	
	@FindBy(name="userName") 	WebElement username;
	
	@FindBy(name="password")  	WebElement password;
	
	@FindBy(name="login")		WebElement login;
	
	@FindBy(linkText="REGISTER")	WebElement registerlink;
	
	@FindBy(linkText="Home")		WebElement homelink;
	
	
	public MTHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void login() {
		username.sendKeys("mercury");
		password.sendKeys("mercury");
		login.click();		
	}
	
	public void clickRegister() {
		registerlink.click();
	}
	
	public void clickHome() {
		homelink.click();
	}
}
