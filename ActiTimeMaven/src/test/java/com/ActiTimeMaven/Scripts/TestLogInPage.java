package com.ActiTimeMaven.Scripts;

import org.testng.annotations.Test;

import com.ActiTime.Maven.pages.EnterTimeTrackPage;
import com.ActiTime.Maven.pages.LogInPage;
import com.ActiTimemaven.generics.BaseTest;
import com.ActiTimemaven.generics.FWUtils;

public class TestLogInPage extends BaseTest{
	@Test
	public void ValidLogInPage() {
		String un = FWUtils.read_XL_Data(Read_XL_data, "Sheet1", 1, 0);
		String pw = FWUtils.read_XL_Data(Read_XL_data, "Sheet1", 1, 1);
		String ExpectedTitle = FWUtils.read_XL_Data(Read_XL_data, "sheet1", 1, 2);
		
		
		LogInPage lp = new LogInPage(driver);
		lp.setusername(un);
		lp.setpassword(pw);
		lp.clickonlogin();
		
		EnterTimeTrackPage Etp = new EnterTimeTrackPage(driver);
		FWUtils.VerifyPageTitle(driver, ExpectedTitle);
		Etp.clickOnLogOutLink();
		
		
	}

}
