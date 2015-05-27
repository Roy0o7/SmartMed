package model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFilter {
	public WebDriver driver;
	public PatientFilter(WebDriver driver){
		this.driver = driver;
	}
	public void firstname(String string1, String string) {
		driver.findElement(By.xpath(string1)).sendKeys(string);
		
	}
	
	public void searchFor1(String string1) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(string1)).clear();
        
    }
	

}
