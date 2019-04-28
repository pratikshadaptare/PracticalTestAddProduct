package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductList extends BasePage{
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'All Categories')]")
	private WebElement allCategories;
	@FindBy(how = How.XPATH, xpath = ".//*[@id='menu3']/li[2]/ul/li[1]/a/span")
	////span[contains(text(),'Electronics')]
	private WebElement electronics;
	@FindBy(how = How.XPATH, xpath = ".//*[@id='submenuul11290']/li[1]/a/span")
	////span[contains(text(),'Head Phone')]
	private WebElement headPhone;
	//@FindBy(how = How.LINK_TEXT, linkText = "Add to cart")
	@FindBy(how = How.XPATH, xpath = "html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")
	private WebElement addtocart;
	@FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Cart")
	private WebElement cart;

	public ProductList(WebDriver driver) {
		super(driver);
	}

	public ProductList NavigateToProduct() throws InterruptedException {	
		Thread.sleep(3000);
		allCategories.click();
		Thread.sleep(3000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(electronics).click().build().perform();
		//act1.moveToElement(electronics).click();
		Thread.sleep(3000);
		act1.moveToElement(headPhone).click().build().perform();
		//act1.moveToElement(headPhone).click();
		return new ProductList(driver);
	}

	public ProductList AddToCart() {	
		addtocart.click();
		cart.click();
		String title = driver.getTitle();
		Assert.assertEquals("View Cart", title);
		return new ProductList(driver);
	}
}
