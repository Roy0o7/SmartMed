import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class TestHome extends LoginPage{
	
public static void Home(){
		
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		driver.findElement(By.xpath("//*[@id='307']/td[3]")).click();
		driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys("Working");
		driver.findElement(By.xpath("//*[@id='reset_note']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		Patients.RandomSelectInt(2, "//*[@id='id_status']");
		driver.findElement(By.xpath("//button[@value='update']")).click();
		driver.findElement(By.id("button-0")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Home")).click();
	    
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		
		new Select(driver.findElement(By.id("filter-1"))).selectByVisibleText("GREEN");
	    new Select(driver.findElement(By.id("filter-1"))).selectByVisibleText("Do not filter");
	    new Select(driver.findElement(By.id("filter-2"))).selectByVisibleText("URGENT");
	    new Select(driver.findElement(By.id("filter-2"))).selectByVisibleText("Do not filter");
	    new Select(driver.findElement(By.id("filter-3"))).selectByVisibleText("NEW/UNREAD");
	    new Select(driver.findElement(By.id("filter-3"))).selectByVisibleText("Do not filter");
	    
	    driver.findElement(By.id("filter-4")).sendKeys("56");
	    driver.findElement(By.id("filter-4")).clear();
	    driver.findElement(By.id("filter-5")).sendKeys("Touhid");
	    driver.findElement(By.id("filter-5")).clear();
	    driver.findElement(By.cssSelector("i.icon-calendar")).click();
	    driver.findElement(By.xpath("//li/div/div/table/tbody/tr/td[6]")).click();
	    driver.findElement(By.xpath("//div[@id='filters']/div[3]/div[2]/span/i")).click();
	    driver.findElement(By.xpath("//div[3]/ul/li/div/div/table/tbody/tr[2]/td[3]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='filter-clear']")).click();
	  
	  }

}
