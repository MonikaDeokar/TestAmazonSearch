package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import util.ExcelReader;

public class tc_invalid_search {
	WebDriver driver =new ChromeDriver();
	Search_Functionality search_item = new Search_Functionality(driver);
	@AfterStep("@Launch3")
	//Method for saving screenshots after every step
    public void addScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
        
    }
	
	@Given("the user in the search option for invalid search")
	public void the_user_in_the_search_option_for_invalid_search() {
		//Launching the application
		search_item.openurl();
	}
	@When("the user enters the {string},{int} and click on submit button")
	public void the_user_enters_the_and_click_on_submit_button(String string, Integer int1) throws InterruptedException, InvalidFormatException, IOException {
		String SheetName = string;
		int RowNumber = int1;
		ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = 
                reader.getData("C:\\abc\\Invalid Search.xlsx", SheetName);
       String search = testData.get(RowNumber).get("Search Input");
		//User enters invalid product name in search bar
       search_item.invalid_search(search);
		Thread.sleep(2000);
	}
	@Then("the system displays item is not available")
	public void the_system_displays_item_is_not_available() throws Throwable {
		//Result for invalid search is displayed
		search_item.verify_invalid_search();
	}
	
	@After("@Launch3")
	//Method for closing browser
    public void exitBrowser() throws InterruptedException {
		driver.quit();
       
    }
}
