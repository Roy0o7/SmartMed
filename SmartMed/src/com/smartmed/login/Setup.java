package com.smartmed.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Setup {
	public static WebDriver driver;
	public Setup(WebDriver driver){
		Setup.driver = driver;
	}
	
public void Log(String Username, String Password) throws Exception {  
  	    
	driver.findElement(By.id("id_username")).sendKeys(Username);
	driver.findElement(By.id("id_password")).sendKeys(Password);
	driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
}
}