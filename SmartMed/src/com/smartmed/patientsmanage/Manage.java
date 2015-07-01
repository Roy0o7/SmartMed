package com.smartmed.patientsmanage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;


public class Manage {
	public static WebDriver driver;
	public Manage(WebDriver driver){
		Manage.driver = driver;
	}
	public void Add(){
		Functions RS = PageFactory.initElements(driver, Functions.class);
		
		driver.findElement(By.xpath("//*[@id='add-btn']")).click();
				
		driver.findElement(By.xpath("//*[@id='id_username']")).sendKeys(Functions.generateRandomWords(5));
		driver.findElement(By.xpath("//*[@id='id_salutation']")).sendKeys("Mr");
		driver.findElement(By.xpath("//*[@id='id_first_name']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='id_surname']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='id_nickname']")).sendKeys("Royce");
				
						       
		RS.RandomSelectInt(2, "//*[@id='id_Dob_formate']");
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");
		RS.RandomSelectInt(2, "//*[@id='id_lead_clinician']");
		RS.RandomSelectInt(2, "//*[@id='id_country']");
				
		if(driver.findElement(By.xpath("//*[@id='id_Dob_formate']")).equals("dd-mm-yyyy")){
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");	    	    				
		}else if(driver.findElement(By.xpath("//*[@id='id_Dob_formate']")).equals("mm-dd-yyyy")){
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");
		}else{
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("1992-10-01");
		}
			
					
		driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Picadally Circus");
					    	    
		driver.findElement(By.xpath("//*[@id='id_region']")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("12312");
						
		driver.findElement(By.xpath("//*[@id='id_sex']")).sendKeys("Male");
		driver.findElement(By.xpath("//*[@id='id_ethnicity']")).sendKeys("Asian British");
		driver.findElement(By.xpath("//*[@id='id_prefered_name']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='id_email']")).sendKeys(Functions.generateRandomWords(10)+"@gmail.com");
		driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys("The patient is Sick");
		driver.findElement(By.xpath("//input[@id='']")).click();
	    driver.findElement(By.id("button-0")).click();
	    driver.findElement(By.cssSelector("html")).click();
			    
	    driver.findElement(By.linkText("OK")).click();
	}
	public void Delete(String ID){
		driver.findElement(By.xpath("//*[@id='"+ID+"']/td[1]/input")).click();
	    driver.findElement(By.id("delete-btn")).click();
	    driver.findElement(By.id("button-0")).click();
	}
			
	public void Edit(String ID){
		driver.findElement(By.xpath("//*[@id='"+ID+"']/td[1]/input")).click();
	    driver.findElement(By.id("edit-btn")).click();
	    
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Oxford University");
	       
	    driver.findElement(By.xpath("//*[@id='id_region']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_region']")).sendKeys("Oxford");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).clear();
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("OX1 2JD");
		driver.findElement(By.cssSelector("#entity-send-form-historical > .span7 > #id_notes")).sendKeys("The patient felt Sick again");
		driver.findElement(By.xpath("//*[@id='id_opt_date']")).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='patient-historical-add-note']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		driver.findElement(By.xpath("//input[@id='']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
			
	}
public void CarePathways(){
	Functions RS1 = PageFactory.initElements(driver, Functions.class);
	
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='93']/td[1]/input")).click();
	    driver.findElement(By.xpath("//*[@id='patient-care-path-ways-btn']")).click();
	    
	    RS1.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[2]/select");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    RS1.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[2]/div[2]/div/div[2]/select");
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[4]/div/div[3]/div/input[1]")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    RS1.RandomSelectInt(2, "//*[@id='entity-update-form']/div/div[3]/div[1]/div/div[2]/select");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    RS1.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[3]/div[2]/div/div[2]/select");
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[3]/div[4]/div/div[3]/div/input[1]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[3]/label")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[3]/div/ul/li[2]/label")).click();
	    
	    driver.findElement(By.xpath("//*[@id='update-pathway-btn-selector']")).click();
	    driver.findElement(By.xpath("//*[@id='button-0']")).click();
	    
	}
	
}