package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementObjTool {
	WebDriver driver;
	
	public WebElementObjTool(WebDriver drv) {
		driver = drv;
	}

	public void enterTextArea(WebElement textarea, String text) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(textarea));
		highlightElement(textarea);
		textarea.clear();
		textarea.sendKeys(text);
		Helper.sleep(3);
	}

	
	public void clickOnElement(WebElement tab) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(tab));
		highlightElement(tab);
		tab.click();
		Helper.sleep(3);
	}
	
	
	public void highlightElement(WebElement element) throws Exception{
		
		String org_style = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
		Helper.sleep(1);
		js.executeScript("arguments[0].setAttribute('style', '"+ org_style +"');", element);
	}
	
}
