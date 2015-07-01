package com.smartmed.filter;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smartmed.login.Setup;

public class TestFilter {
	private static WebDriver driver;
	private static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void openFirefox() throws Exception {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  baseUrl = "http://portal.mhealthcaresolutions.co.uk/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseUrl + "users/login/");
	  Setup login = PageFactory.initElements(driver, Setup.class);
	  login.Log("thawn", "thawn009");	
	
	}
	@Test
	public void test(){
		
		filters RS = PageFactory.initElements(driver, filters.class);
		//RS.MyPatient();
		//RS.AllPatient();
		//RS.MA();
		RS.MAL();
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
