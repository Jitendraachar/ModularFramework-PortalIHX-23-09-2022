package in.ihx.provider.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.WaitUtils;

public class LoginPage extends BasePage{
	
	@FindBy(xpath =  "//*[@id=\"root\"]/div/div/div[1]/div/div[2]/button/div/div")
	private WebElement covincertificate;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div[2]/a[1]/div")
	private WebElement HealthCareProfessional;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div[2]/a[2]/div/h5")
	private WebElement HealthcareFacility;
	
	@FindBy(id="login-form_username")
	private WebElement username;
	
	@FindBy(id="login-form_password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[4]/div/button")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[3]/a")
	private WebElement NeedHelp;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/div[2]/header/div[1]/div[2]")
	private WebElement HospitalName;
			
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public void userLogin(String uname,String pwd) throws Exception {
		
		elementControl.setText(username, uname);
		WaitUtils.waitForSeconds(3);
		
		elementControl.setText(password, pwd); 
		WaitUtils.waitForSeconds(3);
		elementControl.clickElement(loginbutton);
		WaitUtils.waitForSeconds(3);
		
	}
	
	public String getHospitalName() throws Exception {
		return elementControl.getText(HospitalName);
	}
	
}
