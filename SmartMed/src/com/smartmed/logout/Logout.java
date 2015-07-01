package com.smartmed.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

	public static WebDriver driver;
	public Logout(WebDriver driver){
		Logout.driver = driver;
	}
	
		public void logout(String username, String Logout){
			
			driver.findElement(By.linkText(username)).click();
		    driver.findElement(By.linkText(Logout)).click();
		    
			
		}
}
