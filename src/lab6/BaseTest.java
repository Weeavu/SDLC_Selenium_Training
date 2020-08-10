package lab6;

import org.openqa.selenium.WebDriver;
import util.Driver;
import util.Parameter;
import util.WebElementObjTool;

public class BaseTest {
	
	public static WebDriver driver = null;
	public static util.WebElementObjTool webObj;
	public static util.Driver testDriver = new Driver();
	
	public static void launchApp() {
		try {
			driver = testDriver.initDriver("chrome", Parameter.URL);
			webObj = new WebElementObjTool(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void closeApp() {
		try {
			testDriver.closeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

