package lab5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageP;

public class TestLab13 {

	
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
	         js.executeScript("arguments[0].scrollIntoView(true);", home.getLink_Frame());
	         js.executeScript("arguments[0].style.border='3px solid red'", home.getLink_Frame());
	         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", home.getLink_Frame());
	         home.getLink_Frame().click();

	         wait.until(ExpectedConditions.visibilityOf(home.getLink_iFrame()));

	         home.getLink_iFrame().click();

	         driver.switchTo().frame("mce_0_ifr");

	         System.out.println("switched to frame");

	         wait.until(ExpectedConditions.visibilityOf(home.getIframe_elt()));

	          js=(JavascriptExecutor) driver;

	         js.executeScript("arguments[0].scrollIntoView(true);", home.getIframe_elt());

	         js.executeScript("arguments[0].style.border='3px solid red'", home.getIframe_elt());

	         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", home.getIframe_elt());

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
