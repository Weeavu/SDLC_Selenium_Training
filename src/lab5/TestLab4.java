package lab5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageP;

public class TestLab4 {

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
         WebDriverWait wait=new WebDriverWait(driver, 20);
         String eTitle = "The Internet";
         String aTitle = "" ;
         // launch Chrome and redirect it to the Base URL
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
            
            HomePageP home=new HomePageP(driver);
            wait.until(ExpectedConditions.visibilityOf(home.getLink_ABTesting()));
            home.getLink_ABTesting().click();

            //close browser
            driver.close();

        }
        catch(Exception e)
        {
            throw new Exception(e);
        }
    }

}
