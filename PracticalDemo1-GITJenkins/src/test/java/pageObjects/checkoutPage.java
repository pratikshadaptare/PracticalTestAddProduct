package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class checkoutPage extends BasePage {
	@FindBy(how = How.XPATH, xpath = "//input[@value='Proceed to Pay']")
	private WebElement proceedBTN;
	@FindBy(how = How.XPATH, xpath = "//label[contains(text(),'Andhra Bank')]")
	private WebElement bank;
	@FindBy(how = How.XPATH, xpath = "//input[@value='LOGIN']")
	private WebElement loginBTN;
	@FindBy(how = How.XPATH, xpath = "//input[@value='PayNow']")
	private WebElement payNowBTN;
	@FindBy(how = How.ID, id = "btn")
	private WebElement continueBTN;
	@FindBy(how = How.NAME, name = "username")
	private WebElement username;
	@FindBy(how = How.NAME, name = "password")
	private WebElement password;
	@FindBy(how = How.NAME, name = "transpwd")
	private WebElement transpwd;
	@FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Checkout")
	private WebElement checkoutBTN;

	public checkoutPage(WebDriver driver) {
		super(driver);
	}

	public checkoutPage proceedTocheckout() throws InterruptedException {	
		checkoutBTN.click();
		Thread.sleep(2000);
		proceedBTN.click();
		Thread.sleep(2000);
		return new checkoutPage(driver);
	}
	public checkoutPage enterBankDetails() throws InterruptedException {	
		Thread.sleep(2000);
		bank.click();
		Thread.sleep(2000);
		continueBTN.click();
		username.sendKeys("123456");
		password.sendKeys("Pass@456");
		loginBTN.click();
		transpwd.sendKeys("Trans@456");
		Thread.sleep(2000);
		payNowBTN.click();
		Thread.sleep(2000);
		return new checkoutPage(driver);
	}
	
	public checkoutPage verifyOrder() {	
		Assert.assertEquals("Order Details", driver.getTitle());
		return new checkoutPage(driver);
	}
}
