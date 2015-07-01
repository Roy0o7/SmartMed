package com.smartmed.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;
import com.smartmed.functions.PatientFilter;

public class filters {
	public static WebDriver driver;
	public filters(WebDriver driver){
		filters.driver = driver;
	}
	public void MyPatient(){
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
	    Functions RS = PageFactory.initElements(driver, Functions.class);
	    
	    PatientFilter firstname = PageFactory.initElements(driver, PatientFilter.class);
	    firstname.firstname("//*[@id='filter-1']", "93");
	    firstname.firstname("//*[@id='filter-4']", "Pritish");
	    firstname.firstname("//*[@id='filter-5']", "Roy");
        RS.RandomSelectInt(1, "//*[@id='filter-6']");
        firstname.firstname("//*[@id='filter-7']", "Oxford University");
        firstname.firstname("//*[@id='filter-8']", "Dhaka");
        firstname.firstname("//*[@id='filter-9']", "1209");
        
        firstname.searchFor1("//*[@id='filter-9']","");
        firstname.searchFor1("//*[@id='filter-8']","");
        firstname.searchFor1("//*[@id='filter-7']","");
        RS.RandomSelectInt(0, "//*[@id='filter-6']");
        firstname.searchFor1("//*[@id='filter-5']","");
        firstname.searchFor1("//*[@id='filter-4']","");
        firstname.searchFor1("//*[@id='filter-1']","");
        
        
	}

	public void AllPatient() {
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
	   
	    MyPatient();
		
	}
	
	public void MA(){
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		PatientFilter firstname = PageFactory.initElements(driver, PatientFilter.class);
		Functions RS1 = PageFactory.initElements(driver, Functions.class);
	    
		RS1.RandomSelectInt(1, "//*[@id='filter-1']");
	    RS1.RandomSelectInt(1, "//*[@id='filter-2']");
	    RS1.RandomSelectInt(1, "//*[@id='filter-3']");
	    firstname.firstname("//*[@id='filter-4']", "93");
	    
	    firstname.searchFor1("//*[@id='filter-4']","");
	    RS1.RandomSelectInt(0, "//*[@id='filter-3']");
	    RS1.RandomSelectInt(0, "//*[@id='filter-2']");
	    RS1.RandomSelectInt(0, "//*[@id='filter-1']");
	 	}
	
	public void MAL(){
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		MA();
	 	}
}
