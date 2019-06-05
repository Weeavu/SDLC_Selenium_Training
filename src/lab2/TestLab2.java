package lab2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLab2 {

	public static void main(String[] args) throws InterruptedException {
		
		String sDriverPath = "C:\\<Your Path>\\SDLC_Selenium_Training\\lib\\chromedriver.exe";
		String sURL = "http://the-internet.herokuapp.com/";
		
		// To set chromedriver path
		System.setProperty("webdriver.chrome.driver", sDriverPath);	
		
		// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        // Launch a new browser session and directs it to the URL
        driver.get(sURL);
        
        //Wait for page load
        Thread.sleep(2000);  
        
        //Instantiate Checkbox web element
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a"));
        //Click 'Checkboxes'link
        checkbox.click();

        //Wait for page load
        Thread.sleep(2000);  
        
        //Get header
        String header = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

        //Verify Header
        System.out.println("Verify page header");
        if (header.equals("Checkboxes")){
            System.out.println("Test Passed. Actual header is " +header);
        } else {
            System.out.println("Test Failed. Actual header is " +header);
        }
        
        //Close browser
        driver.close();
	}

}
