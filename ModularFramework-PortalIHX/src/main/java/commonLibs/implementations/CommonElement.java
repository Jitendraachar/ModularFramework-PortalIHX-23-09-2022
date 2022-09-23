package commonLibs.implementations;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElements;

public class CommonElement implements ICommonElements{

	public String getText(WebElement element) throws Exception {
		String Text=element.getText();
		return Text;
	}

	public void clickElement(WebElement element) throws Exception {
		element.click();
		
	}

	public String getAttribute(WebElement element, String attribute) throws Exception {
		String attributefrompage=element.getAttribute(attribute);
		return attributefrompage;
	}

	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		String cssvalue=element.getCssValue(csspropertyName);
		return cssvalue;
	}

	public boolean isElementEnabled(WebElement element) throws Exception {
		
		return element.isEnabled();
	}

	public boolean isElementVisible(WebElement element) throws Exception {
		
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) throws Exception {
		
		return element.isSelected();
	}

	public void setText(WebElement element, String textToWrite) throws Exception {
		element.sendKeys(textToWrite);
		
	}

	public void clearText(WebElement element) throws Exception {
		
		element.clear();
	}

	public void changeCheckboxStatus(WebElement element, boolean expectedstatus) throws Exception {
		boolean currentstatus=element.isSelected();
		if(currentstatus!=expectedstatus) {
		element.click();	
		}
	}

	public int getXLocation(WebElement element) throws Exception {
		
		return element.getLocation().x;
	}

	public int getYLocation(WebElement element) throws Exception {
		
		return element.getLocation().y;
	}

}
