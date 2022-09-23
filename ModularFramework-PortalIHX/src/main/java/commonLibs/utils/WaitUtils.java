package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtils {

	
		
	public static void WaitTillElementVisible(WebDriver driver,WebElement element,Duration timeOutInSeconds) throws Exception{
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitTillElementClickable(WebDriver driver,WebElement element,Duration timeOutInSeconds) throws Exception{
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitTillElementSelectable(WebDriver driver,WebElement element,Duration timeOutInSeconds) throws Exception{
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void waitTillAlertIsPresent(WebDriver driver, Duration timeoutInseconds) {
		WebDriverWait wait =new WebDriverWait(driver, timeoutInseconds);
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public static void waitForSeconds(int timeOutInseconds) throws Exception {
		Thread.sleep(timeOutInseconds*1000);
	}
		
}
