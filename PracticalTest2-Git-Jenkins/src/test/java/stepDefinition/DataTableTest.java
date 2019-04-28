package stepDefinition;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTableTest {
	WebDriver driver;
	@Given("^navigate to home page$")
	public void navigate_to_home_page() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();  // open chrome browser   
		System.out.println("Browser Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8083/TestMeApp/");
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password(DataTable usercredentials) {

		List<List<String>> data = usercredentials.raw();
		for(int i=1;i<data.size();i++)
		{
			driver.get("http://localhost:8083/TestMeApp/");
			driver.findElement(By.linkText("SignIn")).click();
			driver.findElement(By.name("userName")).sendKeys(data.get(i).get(0));
			driver.findElement(By.name("password")).sendKeys(data.get(i).get(1));
			driver.findElement(By.name("Login")).click();
			driver.findElement(By.linkText("SignOut")).click();

		}
	}

	@Then("^Message login successfully$")
	public void message_login_successfully() {
		System.out.println("User logged in successfully");
	}
}


