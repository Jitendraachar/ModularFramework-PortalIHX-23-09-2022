package commonLibs.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.ImouseOperation;

public class MouseControl implements ImouseOperation{
	
	private Actions actions;
	
	public MouseControl(WebDriver driver) {
		
		actions= new Actions(driver); 
	} 

	public void dragAndDrop(WebElement source, WebElement target) throws Exception {
		actions.dragAndDrop(source, target).build().perform();
		
	}

	public void moveToElement(WebElement element) throws Exception {
		actions.moveToElement(element).build().perform();
		
	}

	public void rightClick(WebElement element) throws Exception {
		actions.contextClick(element).build().perform();
		
	}

	public void doubleClick(WebElement element) throws Exception {
		actions.doubleClick(element).build().perform();
		
	}

	public void moveToElementAndClick(WebElement element) throws Exception {
		actions.moveToElement(element).build().perform();
		
	}

}
