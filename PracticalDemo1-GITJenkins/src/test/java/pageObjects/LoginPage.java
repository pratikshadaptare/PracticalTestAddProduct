package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObjects.HomePage;

public class LoginPage extends BasePage {

	@FindBy(how = How.NAME, name = "userName")
	private WebElement usernameInputElement;
	@FindBy(how = How.NAME, name = "password")
	private WebElement passwordElement;
	@FindBy(how = How.NAME, name = "Login")
	private WebElement login;
	
	public LoginPage(WebDriver driver) {
	   super(driver);
	}
	 
	public HomePage login(String username, String password) {		
	  usernameInputElement.sendKeys(username);
	  passwordElement.sendKeys(password);
	  login.click();
	  return new HomePage(driver);
	}
	
}


