package com.smartmed.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestSetup {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void openFirefox() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://portal.mhealthcaresolutions.co.uk/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void Setup() throws Exception {
	  Setup RS = PageFactory.initElements(driver, Setup.class);
	  driver.get(baseUrl + "users/login/");
	  RS.Log("thawn","thawn009");
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
