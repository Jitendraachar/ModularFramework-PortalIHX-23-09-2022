package commonLibs.implementations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver implements IDriver {
	
	private WebDriver driver;
	private int PageloadTimeout;
	private int ElementdetectionTimeout;
	
	public CommonDriver(String browserType) throws Exception {
		
		PageloadTimeout = 10;
		ElementdetectionTimeout= 100;
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Invalid Browser Type");
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		PageloadTimeout = pageloadTimeout;
	}

	public void setElementdetectionTimeout(int elementdetectionTimeout) {
		ElementdetectionTimeout = elementdetectionTimeout;
	}

	public void navigateToFirstUrl(String url) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(ElementdetectionTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ElementdetectionTimeout, TimeUnit.SECONDS);
		url= url.trim();
		driver.get(url);
	}

	public String getTitle() throws Exception {
		String title=driver.getTitle();
		return title;
	}

	public String getCurrentUrl() throws Exception {
		String url=driver.getCurrentUrl();
		return url;
	}

	public String getPageSource() throws Exception {
		String pagesource=driver.getPageSource();
		return pagesource;
	}

	public void navigateToUrl(String url) throws Exception {
		url=url.trim();
		driver.navigate().to(url);
		
	}

	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	public void navigateBackward() throws Exception {
		driver.navigate().back();
		
	}

	public void refresh() throws Exception {
		driver.navigate().refresh();
		
	}

	public void closeBrowser() throws Exception {
		if(driver!=null) {
			driver.close();
		}
			
		
	}

	public void closeAllBrowser() throws Exception {
		if(driver!=null) {
			driver.quit();
		}
		
	}

}
