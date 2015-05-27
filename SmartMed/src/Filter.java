import java.util.concurrent.TimeUnit;

import model.PatientFilter;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Filter extends LoginPage{
	public static void filter(){
		
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    
	    driver.findElement(By.xpath("//*[@id='filters-div']/div[1]/div/ul/li[2]/label")).click();
	    driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
	    driver.findElement(By.xpath("//*[@id='filter-4']")).sendKeys("Pri");
	    
	    driver.findElement(By.xpath("//*[@id='93']/td[1]/input")).click();
	    driver.findElement(By.xpath("//*[@id='patient-dashboard-btn']")).click();  

	    driver.findElement(By.xpath("//*[@id='assessment-note-btn']")).click();  
	    
	    driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys("Its Working");  
	    driver.findElement(By.xpath("//*[@id='add-note-dashboard-assess']")).click();
	    driver.findElement(By.xpath("//*[@id='button-0']")).click();
	    
	  
	}
	
	public static void CarePathways(){
		
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='93']/td[1]/input")).click();
	    driver.findElement(By.xpath("//*[@id='patient-care-path-ways-btn']")).click();
	    
	    Patients.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[2]/select");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Patients.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[2]/div[2]/div/div[2]/select");
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[4]/div/div[3]/div/input[1]")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    Patients.RandomSelectInt(2, "//*[@id='entity-update-form']/div/div[3]/div[1]/div/div[2]/select");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Patients.RandomSelectInt(1, "//*[@id='entity-update-form']/div/div[3]/div[2]/div/div[2]/select");
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[3]/div[4]/div/div[3]/div/input[1]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[3]/label")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id='entity-update-form']/div/div[2]/div[1]/div/div[3]/div/ul/li[2]/label")).click();
	    
	    driver.findElement(By.xpath("//*[@id='update-pathway-btn-selector']")).click();
	    driver.findElement(By.xpath("//*[@id='button-0']")).click();
	    
	}
	
	public static void MyPatient(){
		//driver.findElement(By.linkText("Patients")).click();
	    //driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
	    
	    PatientFilter firstname = PageFactory.initElements(driver, PatientFilter.class);
	    firstname.firstname("//*[@id='filter-1']", "93");
	    firstname.firstname("//*[@id='filter-4']", "Simon");
	    firstname.firstname("//*[@id='filter-5']", "Roy");
        Patients.RandomSelectInt(1, "//*[@id='filter-6']");
        firstname.firstname("//*[@id='filter-7']", "Oxford University");
        firstname.firstname("//*[@id='filter-8']", "Dhaka");
        firstname.firstname("//*[@id='filter-9']", "1209");
        
        firstname.searchFor1("//*[@id='filter-9']");
        firstname.searchFor1("//*[@id='filter-8']");
        firstname.searchFor1("//*[@id='filter-7']");
        Patients.RandomSelectInt(0, "//*[@id='filter-6']");
        firstname.searchFor1("//*[@id='filter-5']");
        firstname.searchFor1("//*[@id='filter-4']");
        firstname.searchFor1("//*[@id='filter-1']");
        
        
	}

	
	
	/*
	public static void MA(){
		
	 	}
	
public static void MAL(){
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
	 	}
	*/

	public static void AllPatient() {
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
	   
	    MyPatient();
		
	}
}
