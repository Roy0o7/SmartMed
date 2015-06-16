import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


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
		NodeButtons();
	}
	
	public static void DashBoard(){
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		getnameWithValue(4);		
		WebElement navBox = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[3]/div/div[1]/div/div[2]/fieldset/ul"));
		List<WebElement> links = navBox.findElements(By.cssSelector("a[href]"));
		
		WebElement navBox1 = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[3]/div/div[2]/div/div[1]/fieldset/div/div/ul"));
		List<WebElement> links1 = navBox1.findElements(By.cssSelector("a[href]"));
		
		for(int  i = 0; i< links.size(); i++){
			if(links.get(i).isDisplayed()){
				driver.findElement(By.id("graph-toggle-btn")).click();
				links.get(i).click();
				for(int  j = 0; j< links1.size();j++){
					try{
						if(links1.get(j).isDisplayed()){
							links1.get(j).click();
							Thread.sleep(500);
						}
					}catch(Exception e){	
					
					}			
				}
			}
			 driver.findElement(By.id("table-toggle-btn")).click();
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 driver.findElement(By.id("protocol-reveal-btn")).click();
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		driver.findElement(By.id("historical-note-btn")).click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/span[1]")).click();
		 
		 driver.findElement(By.id("general-note-btn")).click();
		 driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(generateRandomWords(50));
		 driver.findElement(By.id("add-note-general-assess")).click();
		 driver.findElement(By.id("button-0")).click();
		 driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/span[1]")).click();
		 
		 driver.findElement(By.id("assessment-note-btn")).click();
		 driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(generateRandomWords(50));
		 Patients.RandomSelectInt(2, "//*[@id='id_is_prescription']");
		 driver.findElement(By.id("add-note-dashboard-assess")).click();
		 driver.findElement(By.id("button-0")).click();
		 driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/span[1]")).click();
		 
		 driver.findElement(By.id("message-send-btn")).click();
		 SendMessage.toUsers(null, null);
		 driver.findElement(By.xpath("//div[2]/div[2]/button")).click();
		 driver.findElement(By.id("button-0")).click();
	}
	
	public static void getnameWithValue(Integer j) {

		  String first_part = "//*[@id='DataTables_Table_0']/tbody/tr[";
		  String second_part = "]/td[4]/a";
		  
		  List<String> secondColumnList=new ArrayList<String>();

		  for (int i=j; i<=j; i++){
		       String final_xpath = first_part+i+second_part;
		       String test_name = driver.findElement(By.xpath(final_xpath)).getText();
		       driver.findElement(By.xpath(final_xpath)).click();
		       secondColumnList.add(test_name);  
		       System.out.println(test_name);

		  }
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