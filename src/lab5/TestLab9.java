package lab5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageP;

public class TestLab9 {
	

  //Dropdowns
    public static void main(String[] args) throws Exception {
            
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
        try {
        DesiredCapabilities capab=DesiredCapabilities.chrome();
        capab.setAcceptInsecureCerts(true);
        capab.setCapability("mariontte", false);
        capab.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        
        
         driver = new ChromeDriver(capab);
         
         // launch Chrome and redirect it to the Base URL
         driver.get("http://the-internet.herokuapp.com/");
         
         WebDriverWait wait=new WebDriverWait(driver, 30);
         HomePageP home= new HomePageP(driver);
         home.getLink_alerts().click();
         wait.until(ExpectedConditions.visibilityOf(home.getButton_JSalerts()));
         home.getButton_JSalerts().click();
             
         // Switching to Alert  
             Alert alert ;
            alert = driver.switchTo().alert();       
                     
            // Capturing alert message.    
            String alertMessage= driver.switchTo().alert().getText();        
                     
            // Displaying alert message      
            System.out.println(alertMessage);    
            Thread.sleep(5000);
                     
            // Accepting alert       
            alert.accept();  



            //close browser
            driver.close();

        }
        catch(Exception e)
        {
            driver.close();
            throw new Exception(e);
            
        }
    }




}

