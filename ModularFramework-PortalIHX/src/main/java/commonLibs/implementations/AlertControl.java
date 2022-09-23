package commonLibs.implementations;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;

public class AlertControl implements IAlert {
	
	private WebDriver driver;
	
	public AlertControl(WebDriver driver) {
		this.driver=driver;
	}
	
	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() throws Exception {
		getAlert().accept();
		
	}

	public void rejectAlert() throws Exception {
		
		getAlert().dismiss();
	}

	public String getMessageFromAlert() throws Exception {
		String message=getAlert().getText();
		return message;
	}

	public boolean checkAlertPresent1(Duration timeoutInseconds) throws Exception {
		try {
			
			WaitUtils.waitTillAlertIsPresent(driver, timeoutInseconds);
			return true;
			
		}catch(Exception e){
			return false;
		}
		
	}

	public boolean checkAlertPresent(Duration timeoutInseconds) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
