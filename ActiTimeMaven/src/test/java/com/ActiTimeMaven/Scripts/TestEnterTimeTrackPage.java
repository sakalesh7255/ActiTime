package com.ActiTimeMaven.Scripts;

import org.testng.annotations.Test;

import com.ActiTime.Maven.pages.EnterTimeTrackPage;
import com.ActiTime.Maven.pages.LogInPage;
import com.ActiTimemaven.generics.BaseTest;
import com.ActiTimemaven.generics.FWUtils;

public class TestEnterTimeTrackPage extends BaseTest{
	
	@Test
	public void ValidEnterTimeTrackPage() {
		String ExpectedTitle = FWUtils.read_XL_Data(Read_XL_data, "Sheet1", 1, 0);
		
		LogInPage lp = new LogInPage(driver);
		lp.setusername("admi");
		lp.setpassword("manager");
		lp.clickonlogin();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		FWUtils.VerifyPageTitle(driver, ExpectedTitle);
		etp.clickOnLogOutLink();
		
	}

}
