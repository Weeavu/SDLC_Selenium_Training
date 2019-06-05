package lab2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLab1 {

	public static void main(String[] args) throws InterruptedException {
		
		String sDriverPath = "C:\\<Your Path>\\SDLC_Selenium_Training\\lib\\chromedriver.exe";
		
		// To set chromedriver path
		System.setProperty("webdriver.chrome.driver", sDriverPath);	
		
		// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        // Launch a new browser session and directs it to the URL
        driver.get("http://the-internet.herokuapp.com/");
        
        //Wait for page load
        Thread.sleep(2000);  
        
        //Get page title
        String title;
        title = driver.getTitle();
        System.out.println(title);
        
       // compare the actual page title with the expected one and print
       System.out.println("Verify page title");
       if (title.contentEquals("The Internet")){
           System.out.println("Test Passed. Actual title is " +title);
       } else {
           System.out.println("Test Failed. Actual title is " +title);
       }
        
       //Close browser
        driver.close();
       
	}

}
