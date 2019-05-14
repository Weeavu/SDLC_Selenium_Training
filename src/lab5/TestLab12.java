package lab5;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageP;

public class TestLab12 {
	

  //Screenshots
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
         
       
         
         JavascriptExecutor js=(JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", home.getLink_BasicAuth());
         js.executeScript("arguments[0].style.border='3px solid red'", home.getLink_BasicAuth());
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", home.getLink_BasicAuth());
         home.getLink_BasicAuth().click();
         
         
         Thread.sleep(200);
       //Robot Class
         try {
             Robot robot = new Robot(); // Java Robot class

             Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
             StringSelection stringSelection = new StringSelection("username");
             clipboard.setContents(stringSelection, stringSelection);
             Thread.sleep(200);
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);

             // Tab to the password
             robot.keyPress(KeyEvent.VK_TAB);
             robot.keyRelease(KeyEvent.VK_TAB);

             Thread.sleep(100);
             StringSelection stringSelection2 = new StringSelection("password");
             clipboard.setContents(stringSelection2, stringSelection);
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             
             Thread.sleep(100);
             

             // The chrome version requires only one tab press to get to the Ok
             // button
             
               // Tab to the 'OK' button
               robot.keyPress(KeyEvent.VK_TAB);
               robot.keyRelease(KeyEvent.VK_TAB);
             
               Thread.sleep(100);

             // Press Enter
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyPress(KeyEvent.VK_ENTER);

           } catch (AWTException awte) {
             awte.printStackTrace();
           }

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

