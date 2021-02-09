package com.ActiTimemaven.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant{
	
	static {
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	
	public WebDriver driver;
	public static int passcount = 0 , failcount =0;
	
	@BeforeClass
	@Parameters("sbrowser")
	public void Openbrowser(String sbrowser) {
		if (sbrowser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (sbrowser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void OpenApplication() {
		driver.get(URL);
	}
	@AfterMethod
	public void closebrowser(ITestResult res) {
		int status = res.getStatus();
		String MethodName = res.getName();
		if (status==1) {
			passcount++;
		}else {
			failcount++;
			String path = Photo_Path+MethodName+".png";
			FWUtils.takeScreenshot(driver, path);
		}
		
		driver.close();
	}
	@AfterSuite
	public void printreport() {
		Reporter.log("passcoiunt: " + passcount, true);
		Reporter.log("failcount:" + failcount, true);
		FWUtils.set_XL_Data(report_path, "result", 1, 0, passcount);
		FWUtils.set_XL_Data(report_path, "result", 1, 1, failcount);
	}

}
