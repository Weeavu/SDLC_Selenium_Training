package Lab7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.concurrent.TimeUnit;

public class ExtendReportsTest {
	private static String URL = "http://the-internet.herokuapp.com/";
	private static WebDriver driver;
	
	private static ExtentReports extent;
	private static ExtentTest logger;
	
	@BeforeMethod
	public void SetUp() {
		System.out.println("Running set up...");
		System.setProperty("webdriver.chrome.driver", "/Users/vuvu/Documents/Java/Selenium/lib/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		System.out.println("Report Generated");
		extent = new ExtentReports("./LoginTest/Test.html", true);
		
	}
	
	@Test
	public void test() {
		System.out.println("Running test...");
		
		//Create Test for TestNG
		logger = extent.startTest("Login Test");
		
		//Log Start Testing
		logger.log(LogStatus.INFO, "Login Test Start");
		
		//Log Click Form Authentication
		logger.log(LogStatus.INFO, "Click on Form Authentication Link.");
		
		//Click Form Authentication link
		WebElement formAuthLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/a[@href=\"/login\"]"));
		formAuthLink.click();
		
		//Check if login page is loaded
		WebElement loginForm = driver.findElement(By.id("login"));
		Assert.assertNotNull(loginForm, "Could not find login page");
		
		//Log Login page has loaded
		logger.log(LogStatus.INFO, "Login Page Loaded.");
		
		//Type in Username and Password
		WebElement Username = driver.findElement(By.id("username"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		
		Username.sendKeys("tomsmith");
		Password.sendKeys("SuperSecretPassword!");
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
		logger.log(LogStatus.PASS, "Credential Login Success!");
		
	}
	
	@AfterMethod
	public void CloseDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed due to " + result.getThrowable());
		}
		
		System.out.println("Test Completed.");
		driver.quit();
		
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
