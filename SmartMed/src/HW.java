import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;


public class HW extends LoginPage{
public static void Manage() throws IOException{
		
		driver.findElement(By.linkText("HW")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    	
		Add();
		//Delete();
	    //Edit();
		
	}
	public static void Add(){
		driver.findElement(By.xpath("//*[@id='add-btn']")).click();
		
		driver.findElement(By.xpath("//*[@id='id_username']")).sendKeys(TestHome.generateRandomWords(5));
		driver.findElement(By.xpath("//*[@id='id_password1']")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id='id_password2']")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id='id_title']")).sendKeys("Mr");
		driver.findElement(By.xpath("//*[@id='id_first_name']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='id_surname']")).sendKeys("Roy");
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("01-October-1992");
				       
		Patients.RandomSelectInt(-1, "//*[@id='id_lead_clinician']");
		Patients.RandomSelectInt(0, "//*[@id='id_status']");
			
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Picadally Circus");
	    Patients.RandomSelectInt(3, "//*[@id='id_country']");
		driver.findElement(By.xpath("//*[@id='id_city']")).sendKeys("London");
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("12312");
				
		driver.findElement(By.xpath("//*[@id='id_email']")).sendKeys(TestHome.generateRandomWords(10)+"@gmail.com");
		driver.findElement(By.xpath("//*[@id='id_mobile']")).sendKeys("+880"+generateRandomNumbers(10));
		
		
		driver.findElement(By.xpath("//input[@id='']")).click();
	    driver.findElement(By.id("button-0")).click();
	    
	}
	public static void Delete(){
		driver.findElement(By.xpath("//*[@id='all-hcw-filter']")).click();
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		driver.findElement(By.xpath("//*[@id='filter-3']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='17']/td[1]/input")).click();
	    driver.findElement(By.id("delete-btn")).click();
	    driver.findElement(By.id("button-0")).click();
	}
	
	public static void Edit(){
		driver.findElement(By.xpath("//*[@id='all-hcw-filter']")).click();
		driver.findElement(By.xpath("//*[@id='filter-switch']")).click();
		driver.findElement(By.xpath("//*[@id='filter-3']")).sendKeys("Pritish");
		driver.findElement(By.xpath("//*[@id='17']/td[1]/input")).click();
	    driver.findElement(By.id("edit-btn")).click();
	    
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).clear();
	    driver.findElement(By.xpath("//*[@id='id_address_1']")).sendKeys("Oxford University");
	       
	    driver.findElement(By.xpath("//*[@id='id_postcode']")).clear();
		driver.findElement(By.xpath("//*[@id='id_postcode']")).sendKeys("OX1 2JD");
		driver.findElement(By.xpath("//input[@id='']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		
	}
	
	public static int getRandomNumberBetween(int min, int max) {
        Random foo = new Random();
        int randomNumber = foo.nextInt(max - min) + min;
        if(randomNumber == min) {
            return min + 1;
        }else{
            return randomNumber;
        }
    }
	
	public static String generateRandomNumbers(int numberOfDigit){
		String alphabet = new String("0123456789");
		int n = alphabet.length(); 

		String result = new String(); 
		Random r = new Random(); 

		for (int i=0; i<numberOfDigit; i++){
		    result = result + alphabet.charAt(r.nextInt(n)); 
		}
		return result;
		}
}
