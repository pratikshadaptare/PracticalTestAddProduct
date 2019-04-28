package pageObjects;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	@FindBy(how = How.LINK_TEXT, linkText = "SignIn")
	private WebElement signin;
	
	@FindBy(how = How.LINK_TEXT, linkText = "SignOut")
	private WebElement signout;

	@FindBy(how = How.LINK_TEXT, linkText = "SignUp")
	private WebElement signup;
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	public HomePage clickSignIn() {
		signin.click();
		return new HomePage(driver); 
	}
	
	public HomePage verifyLogin(String loginName) {
		WebDriverWait wait = new WebDriverWait(driver, 30); // check home page
		wait.until(ExpectedConditions.visibilityOf(signout));
		assertEquals("Home", driver.getTitle());
		return new HomePage(driver); 
	}
}

