import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

public class SendMessage extends LoginPage{
	static String baseUrl = "http://portal.mhealthcaresolutions.co.uk/";
	
	public static void toUsers(String url){
		driver.get(baseUrl + url);
		ComboBox(9,3);//(9,3) for toUser for Roy0o7 & (75,4) for toPatient for Patient Pritish
		int i =1;
		Patients.RandomSelectInt(i, "//*[@id='id_send_option']");
		Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='id_repeat_frequency']")).size() ==i;
		if (iselementpresent == true){
			 Patients.RandomSelectInt(1, "//*[@id='id_repeat_frequency']");
			 Boolean iselementpresent1 = driver.findElements(By.xpath("//*[@id='id_repeat_until']")).size() == 1;
				if (iselementpresent1 == true){
					driver.findElement(By.xpath("//*[@id='id_repeat_until']")).clear();
					driver.findElement(By.xpath("//*[@id='id_repeat_until']")).sendKeys("5");
				}else{
					System.out.print("Only once\n");
				}
			 CalenderTime();
		}else{
			System.out.print("Messaged Not Scheduled\n");
		}
		
		Patients.RandomSelectInt(-1, "//*[@id='id_priority']");
		Patients.RandomSelectInt(-1, "//*[@id='id_type']");
		driver.findElement(By.xpath("//*[@id='id_subject']")).sendKeys(TestHome.generateRandomWords(10));
		driver.findElement(By.xpath("//*[@id='id_text']")).sendKeys(TestHome.generateRandomWords(70));
		
		driver.findElement(By.xpath("//div[2]/button")).click();
	    driver.findElement(By.id("button-0")).click();
	    
	    Check();
	}
	public static void ComboBox(int j, int q){
		String S="//*[@id='entity-send-form']/div/div[1]/div[1]/div[";
		String W= "]/div[2]/div/div/ul/li[";
		String T="]/label";
		driver.findElement(By.xpath(S+q+"]/div[2]/div/button")).click();
	    driver.findElement(By.xpath(S+q+W+j+T)).click();
	    
	}
	
	public static void Check(){
		Logout.logout("toufiq", "Logout");
		try {
			LoginPage.Login("Roy0o7", "Pritish_7");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Messages & Alerts")).click();
	    driver.findElement(By.linkText("View & Manage Messages")).click();
	    TestHome.getTableRowNumberWithValue(1);
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.findElement(By.cssSelector("span.messi-closebtn.firepath-matching-node")).click();
	    Logout.logout("Roy0o7", "Logout");
	}
	
	public static void toPatients(){
		toUsers("messages/create/?to=patient");
	}
	
	public static void CalenderTime(){
		driver.findElement(By.xpath("//*[@id='id_delivery_time']/span/i")).click();
        
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[1]/div/div[1]/table/tbody/tr[1]/td[3]")).click();
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
    
        driver.findElement(By.cssSelector("i.icon-time")).click();
        for(int i=0;i<32;i++){
        	driver.findElement(By.xpath("(//a[contains(@href, '#')])[7]")).click();
        }
	} 
}

