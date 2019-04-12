package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MTRegisterPage {
	WebDriver driver;
	
	@FindBy(id="email")				WebElement email;
	
	@FindBy(name="password")		WebElement password;

	@FindBy(xpath="//input[@name='confirmPassword']")		WebElement confirmPassword;

	@FindBy(name="register")		WebElement register;

	@FindBy(linkText="SIGN-OFF")	WebElement signOFF;
	
	public MTRegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void sendUserInfo() {
		email.sendKeys("pratikhsa@test.com");
		password.sendKeys("pratiksha");
		confirmPassword.sendKeys("pratiksha");
		register.click();
	}
	
	public void signOFF() {
		signOFF.click();
		
	}
}
