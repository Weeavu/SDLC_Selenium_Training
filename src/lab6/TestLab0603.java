package lab6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import util.WebElementObjTool;

public class TestLab0603 {
	

    //Checkboxes
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
         HomePage home= new HomePage(driver);
         /*
          * Use WebElmentObjTool to replace following code 
          * **/
         WebElementObjTool webObj = new WebElementObjTool(driver);
         
         //home.getLink_checkboxes().click();
         //wait.until(ExpectedConditions.visibilityOf(home.getCheckbox1()));
         webObj.clickOnElement(home.getLink_checkboxes());
         
         //home.getCheckbox1().click();
         //Thread.sleep(400);
         webObj.clickOnElement(home.getCheckbox1());
         
         //wait.until(ExpectedConditions.visibilityOf(home.getCheckbox2()));
         //home.getCheckbox2().click();
         //Thread.sleep(400);
         webObj.clickOnElement(home.getCheckbox2());
         
         
         if(home.getCheckbox1().isSelected())
         {
             System.out.println("My checkbox is selected");
         }
         
         String checkhead=home.getCheckboxHeader().getText();
         if(checkhead.equalsIgnoreCase("checkboxes"))
         {
             System.out.println("header is present");
             JavascriptExecutor js=(JavascriptExecutor) driver;
             js.executeScript("arguments[0].scrollIntoView(true);", home.getCheckboxHeader());
             js.executeScript("arguments[0].style.border='3px solid red'", home.getCheckboxHeader());
             ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", home.getCheckboxHeader());

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

