package com.smartmed.testhome;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.login.Setup;


public class TestHome {
	  private static WebDriver driver;
	  private static String baseUrl;
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
	public void test(){
		driver.get(baseUrl + "alerts/list/");
		Node RS = PageFactory.initElements(driver, Node.class);
		try {
			RS.Dashboard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
