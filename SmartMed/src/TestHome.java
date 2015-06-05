import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;


public class TestHome extends LoginPage{
	
	public static void Node(){
		
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		getTableRowNumberWithValue(3);
		Patients.RandomSelectInt(-1, "//*[@id='id_diagnosis']");
		
		Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='id_lead_clinician']")).size()!= 0;
		if (iselementpresent == true){
			 Patients.RandomSelectInt(-1, "//*[@id='id_lead_clinician']");
		}else{
			System.out.print("Lead Clinician Box is Not Present On The Page\n");
		}
		
		Patients.RandomSelectInt(-1, "//*[@id='id_priority']");
		Patients.RandomSelectInt(-1, "//*[@id='id_status']");
		driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(generateRandomWords(120));
		//NodeButtons();
	}
	public static void NodeButtons(){
		driver.findElement(By.id("reset_note")).click();
	    driver.findElement(By.id("button-0")).click();
	    driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(generateRandomWords(120));
		driver.findElement(By.xpath("//*[@id='add-note']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		driver.findElement(By.xpath("//button[@value='update']")).click();
	    driver.findElement(By.id("button-0")).click();
	  
	}
	
	public static String generateRandomWords(int numberOfWords){
		String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		int n = alphabet.length(); 

		String result = new String(); 
		Random r = new Random(); 

		for (int i=0; i<numberOfWords; i++) 
		    result = result + alphabet.charAt(r.nextInt(n)); 

		return result;
		}


public static void getTableRowNumberWithValue(Integer j) {

	  String first_part = "//*[@id='DataTables_Table_0']/tbody/tr[";
	  String second_part = "]/td[";
	  String third_part = "]";
	  
	  List<String> secondColumnList=new ArrayList<String>();

	  for (int i=j; i<=j; i++){
	       String final_xpath = first_part+i+second_part+j+third_part;
	       String test_name = driver.findElement(By.xpath(final_xpath)).getText();
	       driver.findElement(By.xpath(final_xpath)).click();
	       secondColumnList.add(test_name);  
	       System.out.println(test_name);

	  }
}

}