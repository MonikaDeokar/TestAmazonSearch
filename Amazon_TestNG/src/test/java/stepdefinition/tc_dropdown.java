package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Search_Functionality;
import pageobject.Sign_In;


public class tc_dropdown {
	WebDriver driver =new ChromeDriver();
	Search_Functionality search_prod = new Search_Functionality(driver);
	@AfterStep("@Launch1")
	//Method for saving screenshots after every step
    public void addScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }
	
	@Given("The user is on Home page")
	public void the_user_is_on_Home_page() throws Throwable {
		//Launching the application
		search_prod.openurl();
		
	}

	@Given("The user is already logged in")
	public void The_user_is_already_logged_in() throws InterruptedException {
		Sign_In signin = new Sign_In(driver);
		signin.clickSignin();
		signin.verify_signin();
		signin.sigin("monikadeokar10@gmail.com", "Friends@123");
	}
	
	@When("The user selects product catergory from dropdown list")
	public void the_user_selects_product_catergory_from_dropdown_list() throws Throwable {
		//User selects product category from dropdown list
		search_prod.dropdownlist();
		Thread.sleep(2000);
	
	}

	@Then("The system displays product is available")
	public void the_system_displays_product_is_available() throws Throwable {
		Thread.sleep(2000);
		//Result for selected product category is displayed
		search_prod.verify_dropdown_page();
	}
	@After("@Launch1")
	//Method for closing browser
    public void exitBrowser() throws InterruptedException {
		driver.quit();
      
    }
	
	
}
