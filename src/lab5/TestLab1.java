package lab5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestLab1 {

	@SuppressWarnings({ "deprecation", "unchecked" })
    
public static void main(String[] args) throws Exception {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
        try {
        DesiredCapabilities capab=DesiredCapabilities.chrome();
        capab.setAcceptInsecureCerts(true);
        capab.setCapability("mariontte", false);
        capab.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        
        //it is used to initialize the IE driver
         driver = new ChromeDriver(capab);
         driver.get("http://the-internet.herokuapp.com/");
         Thread.sleep(5000);
         driver.quit();

        }
        catch(Exception e)
        {
            throw new Exception(e);
        }



    }
}
