package com.ActiTime.Maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.ActiTimemaven.generics.BaseTest;

public class LogInPage extends BaseTest{
	
	@FindBy(id="username")
	private WebElement username ;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement login;
	
	@FindBy(xpath= "//span[contains(.,'Please try again.')]")
	private WebElement errormsg;
	
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setusername(String un) {
		username.sendKeys(un);
	}
	public void setpassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void login() {
		username.sendKeys("admin");
		password.sendKeys("manager");
		login.click();
	}
	
	public void clickonlogin() {
		login.click();
	}
	
	public void VerifyErrorMsg() {
		Assert.assertTrue(errormsg.isDisplayed());
		Reporter.log("err msg is displayed" + errormsg.getText(),true);
	}
	

}
