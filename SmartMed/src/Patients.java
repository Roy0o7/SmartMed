import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Patients extends LoginPage{
	public static void Manage() throws IOException{
		
		driver.findElement(By.linkText("Patients")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    	
		Add();
		//Delete();
	    //Edit();
		
	}
	public static void Add(){
		driver.findElement(By.xpath("//*[@id='add-btn']")).click();
		
		driver.findElement(By.xpath("//*[@id='id_username']")).sendKeys("Royce_");
		driver.findElement(By.xpath("//*[@id='id_salutation']")).sendKeys("Mr");
		driver.findElement(By.xpath("//*[@id='id_first_name']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='id_surname']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='id_nickname']")).sendKeys("Royce");
		
				       
		RandomSelectInt(2, "//*[@id='id_Dob_formate']");
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");
		RandomSelectInt(2, "//*[@id='id_lead_clinician']");
		RandomSelectInt(2, "//*[@id='id_country']");
		/*		
		if(driver.findElement(By.xpath("//*[@id='id_Dob_formate']")).equals("dd-mm-yyyy")){
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");	    	    				
		}else if(driver.findElement(By.xpath("//*[@id='id_Dob_formate']")).equals("mm-dd-yyyy")){
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-10-1992");
		}else{
			driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("1992-10-01");
		}
		*/
			
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Picadally Circus");
			    	    
	    driver.findElement(By.xpath("//*[@id='id_region']")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("12312");
				
		driver.findElement(By.xpath("//*[@id='id_sex']")).sendKeys("Male");
		driver.findElement(By.xpath("//*[@id='id_ethnicity']")).sendKeys("Asian British");
		driver.findElement(By.xpath("//*[@id='id_prefered_name']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='id_email']")).sendKeys("pritishroy299@gmail.com");
		
		//driver.findElement(By.xpath("//input[@id='']")).click();
	    //driver.findElement(By.id("button-0")).click();
	    //driver.findElement(By.cssSelector("html")).click();
	    
	    //driver.findElement(By.linkText("OK")).click();
	}
	public static void Delete(){
		driver.findElement(By.xpath("//*[@id='93']/td[1]/input")).click();
	    driver.findElement(By.id("delete-btn")).click();
	    driver.findElement(By.id("button-0")).click();
	}
	
	public static void Edit(){
		driver.findElement(By.xpath("//*[@id='93']/td[1]/input")).click();
	    driver.findElement(By.id("edit-btn")).click();
	    
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Oxford University");
	       
	    driver.findElement(By.xpath("//*[@id='id_region']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_region']")).sendKeys("Oxford");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).clear();
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("OX1 2JD");
		
		driver.findElement(By.xpath("//input[@id='']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
	}
	
	public static void RandomSelectInt(Integer i, String s){
		
		if(i == -1){
			WebElement drpDwnList = driver.findElement(By.xpath(s));
			Select objSel = new Select(drpDwnList);
			List <WebElement> weblist = objSel.getOptions();
			int iCnt = weblist.size();
			Random num = new Random();
			int iSelect = num.nextInt(iCnt);
			objSel.selectByIndex(iSelect);
			System.out.println(drpDwnList.getAttribute("value"));
				
		}
	
		else{	
			List<WebElement> options = driver.findElements(By.xpath(s));
			for(int j=0;j<options.size();j++){
			    System.out.println(options.get(j).getText());
			   	Select select = new Select(driver.findElement(By.xpath(s)));
			   	select.selectByIndex(i);
			   	options.get(j).click();
		    }
		}
		
	}
	
}
