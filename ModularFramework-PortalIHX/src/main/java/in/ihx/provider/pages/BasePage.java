package in.ihx.provider.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementations.AlertControl;
import commonLibs.implementations.CommonElement;
import commonLibs.implementations.DropdownControl;
import commonLibs.implementations.FrameControl;
import commonLibs.implementations.MouseControl;

public class BasePage {

	protected AlertControl alertControl;

	protected CommonElement elementControl;

	protected DropdownControl dropDownControl;

	protected FrameControl frameControl;

	protected MouseControl mouseControl;

	public BasePage(WebDriver driver) {

		alertControl = new AlertControl(driver);

		elementControl = new CommonElement();

		dropDownControl = new DropdownControl();

		frameControl = new FrameControl(driver);

	}

	
}
