package com.smartmed.healthworker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;

public class HealthWorkerManage {
	public static WebDriver driver;
	public HealthWorkerManage(WebDriver driver){
		HealthWorkerManage.driver = driver;
	}
	public void Add(){
		Functions RS = PageFactory.initElements(driver, Functions.class);
		
		driver.findElement(By.xpath("//*[@id='add-btn']")).click();
		
		driver.findElement(By.xpath("//*[@id='id_username']")).sendKeys(Functions.generateRandomWords(5));
		driver.findElement(By.xpath("//*[@id='id_password1']")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id='id_password2']")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id='id_title']")).sendKeys("Mr");
		driver.findElement(By.xpath("//*[@id='id_first_name']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='id_surname']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-October-1992");
				       
		RS.RandomSelectInt(-1, "//*[@id='id_lead_clinician']");
		RS.RandomSelectInt(0, "//*[@id='id_status']");
			
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Picadally Circus");
	    RS.RandomSelectInt(3, "//*[@id='id_country']");
		driver.findElement(By.xpath("//*[@id='id_city']")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("12312");
				
		driver.findElement(By.xpath("//*[@id='id_email']")).sendKeys(Functions.generateRandomWords(10)+"@gmail.com");
		driver.findElement(By.xpath("//*[@id='id_mobile']")).sendKeys("+880"+Functions.generateRandomNumbers(10));
		
		
		driver.findElement(By.xpath("//input[@id='']")).click();
	    driver.findElement(By.id("button-0")).click();
	
	}
	public void Delete(String ID){
		driver.findElement(By.xpath("//*[@id='all-hcw-filter']")).click();
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		driver.findElement(By.xpath("//*[@id='filter-1']")).sendKeys(ID);
		driver.findElement(By.xpath("//*[@id='"+ID+"']/td[1]/input")).click();
	    driver.findElement(By.id("delete-btn")).click();
	    driver.findElement(By.id("button-0")).click();
	}
			
	public void Edit(String ID){
		driver.findElement(By.xpath("//*[@id='all-hcw-filter']")).click();
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		driver.findElement(By.xpath("//*[@id='filter-1']")).sendKeys(ID);
		driver.findElement(By.xpath("//*[@id='"+ID+"']/td[1]/input")).click();
	    driver.findElement(By.id("edit-btn")).click();
	    
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Oxford University");
	       
	    driver.findElement(By.xpath("//*[@id='id_postcode']")).clear();
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("OX1 2JD");
		driver.findElement(By.xpath("//input[@id='']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		
	}

}