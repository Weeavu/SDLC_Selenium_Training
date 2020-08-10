package lab6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;

public class TestLab0601 extends BaseTest {
	
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
         
         /*
          * Use wait functions defined in BasePage to replace following wait command
          * 
          * */
         
         //WebDriverWait wait=new WebDriverWait(driver, 30);
         pageObjects.HomePage home= new HomePage(driver);
         //wait.until(ExpectedConditions.elementToBeClickable(home.getLink_FormAuthentication()));
         home.waitForElementToAppear(home.getLink_FormAuthentication());
         home.getLink_FormAuthentication().click();
         
         
         //wait.until(ExpectedConditions.visibilityOf(home.getTextbox_username()));
         home.waitForElementToAppear(home.getTextbox_username());
         home.getTextbox_username().sendKeys("username");
         
         //wait.until(ExpectedConditions.visibilityOf(home.getTextbox_password()));
         home.waitForElementToAppear(home.getTextbox_password());
         home.getTextbox_password().sendKeys("password");
         
         //wait.until(ExpectedConditions.visibilityOf(home.getButton_Login()));
         home.waitForElementToAppear(home.getButton_Login());
         home.getButton_Login().submit();
         Thread.sleep(400);
         

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

