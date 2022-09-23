package in.ihx.provider.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class IHXLogin  extends BaseTest{
	
	@Test
	public void verifyUserLoginWithCorrectCredential() throws Exception {
		
		extentTest = extent.createTest("TC-001 - verify user login with correct credentials");		
		String uname=configProperties.getProperty("username");
		extentTest.log(Status.INFO, "user name is "+uname);
		String pwd=configProperties.getProperty("password");
		extentTest.log(Status.INFO, "user password  is "+pwd);
		loginPage.userLogin(uname, pwd);
		extentTest.log(Status.INFO, "user logged in successfully ");
		String ExpectedHospitalName=configProperties.getProperty("ExpectedHospitalName");
		String ActualHospitalName=loginPage.getHospitalName();
		
		Assert.assertEquals(ExpectedHospitalName, ActualHospitalName);
		
	}

}
