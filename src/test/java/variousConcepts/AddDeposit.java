package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class AddDeposit {

	WebDriver driver;
	//Login page
	By USER_NAME_FIELD = By.xpath("//input[@id = 'username']");
	By PASSWORD_FIELD = By.xpath("//input[@id = 'password']");
	By SIGN_IN_FIELD = By.xpath("//button[@name = 'login']");
	//select options
	By TRANSACTION_FIELD =By.xpath("//span[text() = 'Transactions']");
	By NEW_DEPOSIT_FIELD = By.xpath("//a[text()= 'New Deposit']");
	//define transaction page fields
	By ACCOUNT_DROWPDOWN_FIELD = By.xpath("//select[@id='account']");
	By DESCRIPTION_MENU_FIELD = By.xpath("//input[@id='description']");
	By AMOUNT_FIELD = By.xpath("//input[@id='amount']");
	By SUBMIT_BUTTON = By.xpath("//button[@id='submit']");
	

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
    @Test
     public void LoginTest() {
    	
    	driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
    	driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
    	driver.findElement(SIGN_IN_FIELD).click();
    	
    }
    @Test
    public void AddDeposit() {
    	
    	LoginTest();
    	
    	driver.findElement(TRANSACTION_FIELD).click();
         Assert.assertTrue("Transaction page not found", driver.findElement(TRANSACTION_FIELD).isDisplayed());
         System.out.println("Transaction");
         
         driver.findElement(NEW_DEPOSIT_FIELD).click();
         Assert.assertTrue("new Deposit page not found", driver.findElement(NEW_DEPOSIT_FIELD).isDisplayed());
         System.out.println("new Deposit");
         
       
        Select sel = new Select(driver.findElement(ACCOUNT_DROWPDOWN_FIELD));
        sel.selectByVisibleText("Ruby");
        Assert.assertTrue("Account dropdown page not found ", driver.findElement(ACCOUNT_DROWPDOWN_FIELD).isDisplayed());
        System.out.println("Account dropdown");
        
        driver.findElement(DESCRIPTION_MENU_FIELD).sendKeys("Add Deposit");
        Assert.assertTrue("Description page not found", driver.findElement(DESCRIPTION_MENU_FIELD).isDisplayed());
        System.out.println("Description");
        
        driver.findElement(AMOUNT_FIELD).sendKeys("70");
        Assert.assertTrue("amount page not found", driver.findElement(AMOUNT_FIELD).isDisplayed());
        System.out.println("amount");
        
       driver.findElement(SUBMIT_BUTTON).click();
       Assert.assertTrue("Submit page not found", driver.findElement(SUBMIT_BUTTON).isDisplayed());
       System.out.println("Submit");
        
           	
    	
    	
    	
    	
    	
    	
    	
	
    	
	
	
    }
	
}
