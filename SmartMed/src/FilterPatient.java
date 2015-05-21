import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class FilterPatient extends LoginPage{
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
	
	
}
