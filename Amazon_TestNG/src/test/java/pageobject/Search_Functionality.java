package pageobject;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Search_Functionality {
	WebDriver driver;
	WebElement linkEntertheStore;
	String product_page_title;
	String page_title;
	String invalid_search_title;
	public Search_Functionality(WebDriver driver){
	this.driver = driver;
	}
	public void openurl()
	{
		   driver.get("https://www.amazon.in/");
		   String expOutput = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String actualoutput = driver.getTitle();
			assertEquals(expOutput, actualoutput);
		   }
	
	public void searchbar(String validsearch) throws InterruptedException
	{
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement Search_bar = driver.findElement(By.id("twotabsearchtextbox"));
		 if(Search_bar.isDisplayed()) {
			 Search_bar.sendKeys(validsearch);
		 }
		 else {
			 System.out.println("Search bar is not present");
		 }
		 WebElement search_icon = driver.findElement(By.id("nav-search-submit-button"));
		 if(search_icon.isDisplayed()) {
			 search_icon.click();
		 }
		 else {
			 System.out.println("Search icon is not present");
		 }
		 product_page_title = driver.getTitle();
		 
		 Thread.sleep(2000);
		
	}
	
	public void invalid_search(String invalidsearch) throws InterruptedException
	{
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement Search_bar = driver.findElement(By.id("twotabsearchtextbox"));
		 if(Search_bar.isDisplayed()) {
			 Search_bar.sendKeys(invalidsearch);
		 }
		 else {
			 System.out.println("Search bar is not present");
		 }
		 WebElement search_icon = driver.findElement(By.id("nav-search-submit-button"));
		 if(search_icon.isDisplayed()) {
			 search_icon.click();
		 }
		 else {
			 System.out.println("Search icon is not present");
		 }
		invalid_search_title = driver.getTitle();
		 Thread.sleep(2000);
		 
	}
	
	public void verify_invalid_search() {
		String expected = "Amazon.in : %@_-+%$";
		String actual = invalid_search_title;
		 assertEquals(expected, actual);
	}
	
	 public void dropdownlist() throws InterruptedException
		{
			
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
			 WebElement category=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
			 boolean list = category.isDisplayed();
			 if(list) {	
				 category.click();
			 }
			 Actions action = new Actions(driver);
			 action.click(category).build().perform();
			 Select category1 = new Select(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));
			 Thread.sleep(2000);
			 category1.selectByVisibleText("Computers & Accessories");
			 WebElement search_icon = driver.findElement(By.id("nav-search-submit-button"));
			 if(search_icon.isDisplayed()) {
				 search_icon.click();
				 page_title = driver.getTitle();
			 }
			 else {
				 System.out.println("Search icon is not present");
			 }
		
			 Thread.sleep(2000); 	
		}
	 
	 public void verify_dropdown_page() {
		 String expected = "Computers & Accessories: Buy Computers & Accessories Online at Low Prices in India - Amazon.in";
		 String actual = page_title;
		 assertEquals(expected, actual);
	 }
	 
	 public void verify_product_page() {
		 String expected = "Amazon.in : Computers & Accessories";
		 String actual = product_page_title;
		 assertEquals(expected, actual);
	 }
	 
}
