package lab5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestLab3 {

    public static void main(String[] args) throws Exception {
        
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
        try {
        DesiredCapabilities capab=DesiredCapabilities.chrome();
        capab.setAcceptInsecureCerts(true);
        capab.setCapability("mariontte", false);
        capab.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        
        // launch Chrome and redirect it to the Base URL
         driver = new ChromeDriver(capab);
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
         String eTitle = "The Internet";
         String aTitle = "" ;
         
         driver.get("http://the-internet.herokuapp.com/");
            
            
            //get the actual value of the title
            aTitle = driver.getTitle();
            //compare the actual title with the expected title
            if (aTitle.equals(eTitle))
            {
            System.out.println( "Test Passed") ;
            }
            else {
            System.out.println( "Test Failed" );
            }
            //close browser
            driver.close();

        }
        catch(Exception e)
        {
            throw new Exception(e);
        }
    }
}
