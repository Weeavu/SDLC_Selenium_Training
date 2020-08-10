package lab6;

import org.openqa.selenium.WebDriver;
import util.Driver;
import util.Parameter;


public class TestLab0604 {
	

    
public static void main(String[] args) throws Exception {
	//public void startDriver() {
		/*
		 * Use Driver class functions to replace following lines of code 
		 * */
		
        try {
        	Driver uiDriver = new Driver();
			WebDriver driver = uiDriver.initDriver("ie",Parameter.URL); 
			uiDriver.closeDriver();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        
        /*
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
        */



    }
}
