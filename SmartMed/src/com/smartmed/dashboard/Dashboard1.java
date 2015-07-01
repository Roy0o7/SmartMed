package com.smartmed.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;

public class Dashboard1 {
	public static WebDriver driver;
	public Dashboard1(WebDriver driver){
		Dashboard1.driver = driver;
	}
	public void Dash() {
		Functions RS = PageFactory.initElements(driver, Functions.class);
		
			driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
			Functions.getnameWithValue(3);		
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
			 driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(Functions.generateRandomWords(50));
			 driver.findElement(By.id("add-note-general-assess")).click();
			 driver.findElement(By.id("button-0")).click();
			 driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/span[1]")).click();
			 
			 driver.findElement(By.id("assessment-note-btn")).click();
			 driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(Functions.generateRandomWords(50));
			 RS.RandomSelectInt(2, "//*[@id='id_is_prescription']");
			 driver.findElement(By.id("add-note-dashboard-assess")).click();
			 driver.findElement(By.id("button-0")).click();
			 driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/span[1]")).click();
			 
			 driver.findElement(By.id("message-send-btn")).click();
			 toUsers();
			 driver.findElement(By.xpath("//div[2]/div[2]/button")).click();
			 driver.findElement(By.id("button-0")).click();
			
		}
	public void toUsers(){
		Functions RS1 = PageFactory.initElements(driver, Functions.class);
		
		int i = 1;
		RS1.RandomSelectInt(i, "//*[@id='id_send_option']");
		Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='id_repeat_frequency']")).size() == i;
		if (iselementpresent == true){
			 RS1.RandomSelectInt(1, "//*[@id='id_repeat_frequency']");
			 Boolean iselementpresent1 = driver.findElements(By.xpath("//*[@id='id_repeat_until']")).size() == 1;
				if (iselementpresent1 == true){
					driver.findElement(By.xpath("//*[@id='id_repeat_until']")).clear();
					driver.findElement(By.xpath("//*[@id='id_repeat_until']")).sendKeys("5");
				}else{
					System.out.print("Only once\n");
				}
				driver.findElement(By.xpath("//*[@id='id_delivery_time']/span")).click();
				}else{
			System.out.print("Messaged Not Scheduled\n");
		}
		
		RS1.RandomSelectInt(-1, "//*[@id='id_priority']");
		RS1.RandomSelectInt(-1, "//*[@id='id_type']");
		driver.findElement(By.xpath("//*[@id='id_subject']")).sendKeys(Functions.generateRandomWords(10));
		driver.findElement(By.xpath("//*[@id='id_text']")).sendKeys(Functions.generateRandomWords(70));
		
		driver.findElement(By.xpath("//div[2]/div[2]/button")).click();
	    driver.findElement(By.id("button-0")).click();
	    
	}

}