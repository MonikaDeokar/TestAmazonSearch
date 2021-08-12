package pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Sign_In {
	WebDriver driver;
	String signin_title;
	public Sign_In(WebDriver driver) {
		this.driver = driver;
		
	}
	public void clickSignin() throws InterruptedException
    {
        WebElement account = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        boolean check_account = account.isDisplayed();
        if(check_account) {
            account.click();
        }else
        {
            System.out.println("Element is not present");
        }
       
        //Amazon Sign In
        signin_title = driver.getTitle();
    }
    public void verify_signin() {
        String expected = "Amazon Sign In";
        String actual = signin_title;
        assertEquals(actual, expected);
    }
    public void sigin(String emailid,String password) {
       
        WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        boolean check_email = email.isDisplayed();
        if(check_email) {
                email.sendKeys(emailid);
        }else
        {
            System.out.println("Element is not present");
        }
        WebElement cont = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        boolean check_cont = cont.isDisplayed();
        if(check_cont) {
            cont.click();
        }else
        {
            System.out.println("Element is not present");
        }
        verify_signin();
         
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        boolean check_pass = pass.isDisplayed();
        if(check_pass) {
             pass.sendKeys(password);
        }else
        {
            System.out.println("Element is not present");
        }
       
        WebElement sign = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
          boolean check_sign = sign.isDisplayed();
            if(check_sign) {
                 sign.click();
                 
            }else
            {
                System.out.println("Element is not present");
            }    
            
    }
    
}