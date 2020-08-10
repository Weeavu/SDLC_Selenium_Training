package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String getDateTimeFull() {
		
		Date dt=new Date();
        String date= new SimpleDateFormat("mm-dd-yyyy_HHmmssSSS").format(dt);
        return date;
	}

	public static void switchToNewOpenWindow(WebDriver driver) {
		try {
			String mainWindow=driver.getWindowHandle();
			System.out.println(mainWindow);
			Set<String> set =driver.getWindowHandles();
			Iterator<String> itr= set.iterator();
					
			while(itr.hasNext()){
				String childWindow=itr.next();
				System.out.println(childWindow);
		       // Compare whether the main windows is not equal to child window. If not equal, we will close.
				if(!mainWindow.equals(childWindow)){
				  driver.switchTo().window(childWindow);
		}
			}
					
		} catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void dismissAlert(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert();		
		
		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		
			        		
		// Displaying alert message		
		System.out.println(alertMessage);	
		sleep(5);
			        		
		// Accepting alert		
		alert.dismiss();

	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	


}
