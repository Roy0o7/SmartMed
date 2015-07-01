package com.smartmed.sendmessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;
import com.smartmed.login.Setup;

public class SendM {
	public static WebDriver driver;
	private String baseUrl="http://portal.mhealthcaresolutions.co.uk/";
	public SendM(WebDriver driver){
		SendM.driver = driver;
	}
	
	public void toUsers(String url, int DeliverAs){
		driver.get(baseUrl + url);
		Functions RS = PageFactory.initElements(driver, Functions.class);
		
		RS.RandomSelectInt(DeliverAs, "//*[@id='id_deliver_as']");
		ComboBox(10,3);//(10,3) for toUser for Roy0o7 & (75,4) for toPatient for Patient Pritish & (5,5) for hwc
		int i = 1;
		RS.RandomSelectInt(i, "//*[@id='id_send_option']");
	    
		Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='id_repeat_frequency']")).size() == i;
		if (iselementpresent == true){
			 RS.RandomSelectInt(1, "//*[@id='id_repeat_frequency']");
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
		
		RS.RandomSelectInt(-1, "//*[@id='id_priority']");
		RS.RandomSelectInt(-1, "//*[@id='id_type']");
		driver.findElement(By.xpath("//*[@id='id_subject']")).sendKeys(Functions.generateRandomWords(10));
		driver.findElement(By.xpath("//*[@id='id_text']")).sendKeys(Functions.generateRandomWords(70));
		
		driver.findElement(By.xpath("//div[2]/button")).click();
	    driver.findElement(By.id("button-0")).click();
	    
	    driver.findElement(By.linkText("Sent")).click();
	    driver.findElement(By.linkText("Archived")).click();
	    driver.findElement(By.linkText("Scheduled")).click();
	    
	    Check();
	}
	
	public void ComboBox(int j, int q){
		String S="//*[@id='entity-send-form']/div/div[1]/div[1]/div[";
		String W= "]/div[2]/div/div/ul/li[";
		String T="]/label";
		driver.findElement(By.xpath(S+q+"]/div[2]/div/button")).click();
	    driver.findElement(By.xpath(S+q+W+j+T)).click();
	    
	}
	public void logout(String username, String Logout){
		
		driver.findElement(By.linkText(username)).click();
	    driver.findElement(By.linkText(Logout)).click();    
		
	}
	
	public void Check(){
		Setup login = PageFactory.initElements(driver, Setup.class);
		 
		logout("thawn", "Logout");
		try {
			try {
				login.Log("Roy0o7", "Pritish_7");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Messages & Alerts")).click();
	    driver.findElement(By.linkText("View & Manage Messages")).click();

	    Functions.getTableRowNumberWithValue(1);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.findElement(By.cssSelector("span.messi-closebtn")).click();
	    logout("Roy0o7", "Logout");
	}
	
	public static void CalenderTime(){
		String innerhtml = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]")).getAttribute("innerHTML");
		System.out.println(innerhtml);
		String a_letter = Character.toString(innerhtml.charAt(38));
		String b_letter = Character.toString(innerhtml.charAt(39));
		
		driver.findElement(By.xpath("//*[@id='id_delivery_time']/span/i")).click();
		driver.findElement(By.cssSelector(".day.active")).click();
		driver.findElement(By.cssSelector("i.icon-time")).click();
		
		String innerhtml1 = driver.findElement(By.xpath("html/body/div[2]/ul/li[3]/div/div[1]/table/tbody/tr[2]/td[3]/span")).getAttribute("innerHTML");
		System.out.println(innerhtml1);
		String c_letter = Character.toString(innerhtml1.charAt(0));
		String d_letter = Character.toString(innerhtml1.charAt(1));
		
		String E = a_letter+b_letter;
		String F = c_letter+d_letter;
		
		Integer x2 = Integer.valueOf(E);
		Integer y2 = Integer.valueOf(F);
		
		Integer q = Math.abs(x2-y2); 
		
		for(int i = 0 ; i< q + 2 ; i++ ){
			driver.findElement(By.xpath("html/body/div[2]/ul/li[3]/div/div[1]/table/tbody/tr[1]/td[3]/a")).click();
		}
        
	} 
	
}