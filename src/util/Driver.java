package util;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Driver {
	
	public WebDriver driver;
	
	public WebDriver initDriver(String browserType, String url) throws Exception {
		driver = setUpdriver(browserType);
		driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        
		return driver;
	}
	
	private WebDriver setUpdriver(String browser) throws Exception {
        switch (browser.toLowerCase()) {
        case "ie":
        	
        	   //Note1: Make sure IE browser zoom level is set as 100%
        	   //Note2: Make sure protected level are the same for all zones(Tools > Internet Options > Security tab
        	   System.setProperty("webdriver.ie.driver", "resources//IEDriverServer.exe");
               
               driver = new InternetExplorerDriver();
               break;
        
        case "chrome":
        	   System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
               ChromeOptions chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("--start-maximized");
               chromeOptions.addArguments("--ignore-certificate-errors");
               chromeOptions.addArguments("--disable-popup-blocking");

               DesiredCapabilities capabilities = DesiredCapabilities.chrome();
               capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
               capabilities.setAcceptInsecureCerts(true);
               capabilities.setCapability("mariontte", false);
               capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
               
               driver = new ChromeDriver(capabilities);
              
               break;
        
        case "firefox":
              
               System.setProperty("webdriver.gecko.driver","resources//geckodriver.exe");
               
               //Note2
               //add pathToBinary if Firefox.exe cannot be located 
               File pathToBinary = new File("C:\\Users\\YangTang\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
               FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
               
               DesiredCapabilities fireFoxcapab = DesiredCapabilities.firefox();
               FirefoxOptions options = new FirefoxOptions();
               fireFoxcapab.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(ffBinary));
               
       		   driver = new FirefoxDriver(options);
               break;
        }
        driver.manage().deleteAllCookies();

        return driver;
 }
	
	public void closeDriver() {
		driver.quit();
		  
	}
 

}
