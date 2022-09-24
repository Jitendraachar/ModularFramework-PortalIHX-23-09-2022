package in.ihx.provider.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.TestDataProvider;


public class IHXLogin  extends BaseTest{
	
	@Test(dataProvider = "getUserData",dataProviderClass =TestDataProvider.class )
	public void verifyUserLoginWithCorrectCredential(String uname,String pwd) throws Exception {
		
		extentTest = extent.createTest("TC-001 - verify user login with correct credentials"+uname+ "and" +pwd);		
		
		extentTest.log(Status.INFO, "user name is "+uname);
		
		extentTest.log(Status.INFO, "user password  is "+pwd);
		loginPage.userLogin(uname, pwd);
		extentTest.log(Status.INFO, "user logged in successfully ");
		String ExpectedHospitalName=configProperties.getProperty("ExpectedHospitalName");
		String ActualHospitalName=loginPage.getHospitalName();
		
		Assert.assertEquals(ExpectedHospitalName, ActualHospitalName);
		
	}

}
