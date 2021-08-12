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


public class tc_valid_search {
	WebDriver driver =new ChromeDriver();
	Search_Functionality search = new Search_Functionality(driver);
	
	@AfterStep("@Launch2")
	//Method for saving screenshots after every step
    public void addScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");

    }
	@Given("the user is on search option")
	public void the_user_is_on_search_option() throws Throwable {
		//Launching the application
		search.openurl();

	}

	@When("the user enters the {string} and click submit button")
	public void the_user_enters_the_and_click_submit_button(String string) throws InterruptedException {
		String validsearch = string;
		//User selects valid product name in search bar
		search.searchbar(validsearch);	
		Thread.sleep(2000);
	}

	@Then("the system displays item is available")
	public void the_system_displays_item_is_available() throws Throwable {
	   //Result for valid search is displayed
		search.verify_product_page();
	}
	
	@After("@Launch2")
	//Method for closing browser
    public void exitBrowser() throws InterruptedException {
		driver.quit();

    }
}
