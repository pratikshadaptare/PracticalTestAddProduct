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
import pageObjects.AddProduct;


public class Login_Steps {
	private static WebDriver driver = null;
	private LoginPage loginPage;
	private HomePage homePage;
	private AddProduct addNewproduct;
	
	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		addNewproduct = new AddProduct(driver);		
	}
		
	@After
	public void tearDown() {
		driver.quit(); 
	}
	
	@Given("^Admin is on admin home page$")
	public void admin_is_on_admin_home_page() throws Throwable {
		loginPage.navigateTo();
		homePage.clickSignIn();	
	}

	@When("^Admin enters username and password and click on Login button$")
	public void admin_enters_username_and_password_and_click_on_Login_button(){
		loginPage.login("Admin", "Password456");
	}

	@Then("^Admin should be logged in and Verified$")
	public void admin_should_be_logged_in_and_Verified() throws Throwable {
		homePage.verifyLogin("admin");
	}
	
	@Given("^Navigate to Add Product Section$")
	public void navigate_to_Add_Product_Section() throws Throwable {
		addNewproduct.NavigateToAddProduct();
	}

	@When("^Enter new product information and click on Add product$")
	public void enter_new_product_information_and_click_on_Add_product() throws Throwable {
		addNewproduct.newProduct();
	}

	@Then("^Display message product added successfully$")
	public void display_message_product_added_successfully() throws Throwable {
		Thread.sleep(2000);
		addNewproduct.verifyProduct();
	}
}


