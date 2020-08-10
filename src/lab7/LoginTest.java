package lab7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
	
	//Constant global variables
	private static String URL = "http://the-internet.herokuapp.com/";
	private static WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		//Set path for chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/vuvu/Documents/Java/Selenium/lib/chromedriver");
		
		//Creating an instance of chromedriver
		driver = new ChromeDriver();
		
		//Set wait time before throwing error
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open browser and navigate to URL
		driver.get(URL);
		
		//Maximize window
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() {
		
		WebElement formAuthLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/a[@href=\"/login\"]"));
		
		//Click Form Authentication Link
		formAuthLink.click();
		
		WebElement loginForm = driver.findElement(By.id("login"));
		
		//Assume loginForm is not null. If page is not loaded then login Form will be null.
		Assert.assertNotNull(loginForm, "Could not find login page");
		
		
		WebElement Username = driver.findElement(By.id("username"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		
		//Type Username
		Username.sendKeys("tomsmith");
		
		//Type Password
		Password.sendKeys("SuperSecretPassword!");
		
		//Click Login
		loginButton.click();
		
		//Login Message
		WebElement loginMessage = driver.findElement(By.id("flash"));
		
		//Expected text
		String expectedText = "flash success";
		
		//Get the class for the webelement
		String actualText = loginMessage.getAttribute("class").trim();
		
		//Get the text value of the webelement
		String errMessage = loginMessage.getText().trim();
		
		//Assume text match. If login fails then class will be 'flash error'
		Assert.assertEquals(actualText, expectedText, errMessage);
		
	}
	
	
	@AfterMethod
	public void CloseDown() {
		
		//Close down browser
		driver.quit();
	}
	
}
