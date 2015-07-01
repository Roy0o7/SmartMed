package com.smartmed.sendmessage;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.login.Setup;

public class TestSendMessage{
	public static WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void openFirefox() throws Exception {
	  driver = new FirefoxDriver();
	  baseUrl = "http://portal.mhealthcaresolutions.co.uk/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseUrl + "users/login/");
	  Setup login = PageFactory.initElements(driver, Setup.class);
	  login.Log("thawn", "thawn009");	
	
	}
	@Test
	public void sendmessage(){
		SendM SM = PageFactory.initElements(driver, SendM.class);
		
		SM.toUsers("messages/create/?to=user",1);
		//SM.toUsers("messages/create/?to=patient",2);
		//SM.toUsers("messages/create/?to=hcw",2);
	}
	
 
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

	
}