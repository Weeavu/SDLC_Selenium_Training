package lab5;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageP;



public class TestLab10 {
	

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
         TakesScreenshot scrShot =((TakesScreenshot)driver); 
         
         File SrcFile=scrShot.getScreenshotAs(OutputType.FILE); 
         
         Date dt=new Date();
         String date= new SimpleDateFormat("mm-dd-yyyy_HHmmssSSS").format(dt);
         String absoluteFileName="C:\\Users\\choitali\\Desktop\\screenshots\\"+date+".png";
         System.out.println(absoluteFileName);
         
         FileUtils.copyFile(SrcFile, new File(absoluteFileName));

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

