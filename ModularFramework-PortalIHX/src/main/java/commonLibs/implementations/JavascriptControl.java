package commonLibs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavascriptOperations;

public class JavascriptControl implements IJavascriptOperations {
	
	private JavascriptExecutor jsEngine;
	
	public JavascriptControl(WebDriver driver) {
		
		jsEngine = (JavascriptExecutor) driver;
	}

	public void executeJavaScript(String scriptToExecute) throws Exception {
		
		jsEngine.executeScript(scriptToExecute);
	}

	public void scrollDown(int x, int y) throws Exception {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
		jsEngine.executeScript(jsCommand);
	}

	public String executeJavaScriptWithRetrunValue(String scriptToExecute) throws Exception {
		
		return jsEngine.executeScript(scriptToExecute).toString();
	}

}
