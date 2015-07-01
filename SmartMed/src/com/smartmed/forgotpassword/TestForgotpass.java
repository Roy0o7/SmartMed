package com.smartmed.forgotpassword;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestForgotpass {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void openFirefox() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://portal.mhealthcaresolutions.co.uk/users/login/";
	    driver.get(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	public void Test(){
		forgotpassword("toufiq@gmail.com");
	}
	public void forgotpassword(String s){
		
		WebElement element = driver.findElement(By.xpath("//*[@id='login-content']/div/a[2]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id='id_email']"));
		element.sendKeys(s);
		
		element = driver.findElement(By.xpath("//*[@id='reset-form']/div[2]/div[2]/button"));
		element.click();
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
