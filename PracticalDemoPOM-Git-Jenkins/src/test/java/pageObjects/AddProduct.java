package pageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddProduct extends BasePage{

	@FindBy(xpath = "//h4[contains(.,'Add Product')]")
	private WebElement addProductSection;

	@FindBy(xpath = "//select[@name='categorydropname']")
	private WebElement categoryName;

	@FindBy(xpath = "//select[@name='subcategorydropname']")
	private WebElement subcategoryName;

	@FindBy(xpath = "//input[@name='prodname']")
	private WebElement prodName;

	@FindBy(xpath = "//input[@name='pricename']")
	private WebElement price;

	@FindBy(xpath = "//input[contains(@name,'Quantity')]")
	private WebElement quantity;

	@FindBy(xpath = "//input[@name='Brand']")
	private WebElement brand;

	@FindBy(xpath = "//textarea[contains(@name,'description')]")
	private WebElement description;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addProductBTN;
	
	@FindBy(xpath = "//i[@style='font-size: 20px']")
	private WebElement message;

	public AddProduct(WebDriver driver) {
		super(driver);
	}

	public AddProduct NavigateToAddProduct() throws InterruptedException {	
		Thread.sleep(3000);
		addProductSection.click();		
		return new AddProduct(driver);
	}

	public AddProduct newProduct() {	
		Select catName = new Select(categoryName);
		catName.selectByIndex(1);
		
		Select subcatName = new Select(subcategoryName);
		subcatName.selectByIndex(1);
		
		prodName.sendKeys("iPhone");
		price.sendKeys("55000");
		quantity.sendKeys("20");
		brand.sendKeys("Apple");
		description.sendKeys("New iPhone");
		addProductBTN.click();			
		return new AddProduct(driver);
	}
	
	public AddProduct verifyProduct() throws InterruptedException {	
		Thread.sleep(2000);
		String MSG = message.getText();
		assertTrue(MSG.contains("Succesfully"));		
		return new AddProduct(driver);
	}
	
}
