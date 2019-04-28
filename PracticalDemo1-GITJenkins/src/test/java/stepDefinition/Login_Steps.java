package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductList;
import pageObjects.checkoutPage;

public class Login_Steps {
	private static WebDriver driver = null;
	private LoginPage loginPage;
	private HomePage homePage;
	private ProductList productList;
	private checkoutPage checkoutPage;

	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		productList = new ProductList(driver);
		checkoutPage = new checkoutPage(driver);
	}
		
	@After
	public void tearDown() {
		driver.quit(); 
	}

	@Given("^User is on home page$")
	public void user_is_on_home_page() {
		loginPage.navigateTo();
		homePage.clickSignIn();		
	}

	@When("^User enters username and password and click on Login button$")
	public void user_enters_username_and_password_and_click_on_Login_button(){
		loginPage.login("Lalitha", "Password123");
	}

	@Then("^User should be logged in and Verified$")
	public void user_should_be_logged_in_and_Verified() throws Throwable {
		homePage.verifyLogin("Lalitha");
	}

	@Given("^Navigate to All categories - electronics and Head phone$")
	public void navigate_to_All_categories_electronics_and_Head_phone() throws Throwable {
		productList.NavigateToProduct();
	}

	@Given("^Add product into shopping cart$")
	public void add_product_into_shopping_cart() throws Throwable {
		productList.AddToCart();
	}

	@When("^proceed to checkout$")
	public void proceed_to_checkout() throws Throwable {
		checkoutPage.proceedTocheckout();
	}

	@When("^select bank and add credentials$")
	public void select_bank_and_add_credentials() throws Throwable {
		checkoutPage.enterBankDetails();
	}

	@Then("^redirected to the thank you page$")
	public void redirected_to_the_thank_you_page() throws Throwable {
		Assert.assertEquals("Order Details", driver.getTitle());		
	}
}


