package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static WebDriver driver;

	public BasePage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public LoginPage navigateTo() {
		driver.get("http://localhost:8083/TestMeApp/");
		assertEquals("Home", driver.getTitle());
		driver.manage().window().maximize(); 
		return new LoginPage(driver); 		
	}
}

