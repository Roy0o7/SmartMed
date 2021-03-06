package com.smartmed.patientsmanage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smartmed.login.Setup;

public class TestPatients {
	  private static WebDriver driver;
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
	public void Manage() throws IOException{
		driver.get(baseUrl + "prms/");
		Manage SM = PageFactory.initElements(driver, Manage.class);
			
		SM.Add();
		//SM.Delete("93");
		//SM.Edit("93");
		//SM.CarePathways();		
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


