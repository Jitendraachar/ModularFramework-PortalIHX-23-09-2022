package commonLibs.implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl  implements IScreenshot{
	
	private TakesScreenshot camera;
	
	public ScreenshotControl(WebDriver driver) {
		
		 camera= (TakesScreenshot)driver;
		
	}

	public void captureAndSaveScreenshot(String pathFile) throws Exception {
	
		pathFile=pathFile.trim();
		File imageFile,tempFile;
		
		imageFile=new File(pathFile);
		if(imageFile.exists()) {
			throw new Exception("image with this file name already exist..");
		}
		tempFile = camera.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tempFile, imageFile);
	}

}
