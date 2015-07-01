package com.smartmed.testhome;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.smartmed.functions.Functions;

public class Node {
	public static WebDriver driver;
	public Node(WebDriver driver){
		Node.driver = driver;
	}
	public void Dashboard() throws IOException{
		Functions RS = PageFactory.initElements(driver, Functions.class);
	
		
		driver.findElement(By.xpath("//*[@id='all-patient-filter']")).click();
		Functions.getTableRowNumberWithValue(3);
		RS.RandomSelectInt(-1, "//*[@id='id_diagnosis']");
		
		Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='id_lead_clinician']")).size()!= 0;
		if (iselementpresent == true){
			 RS.RandomSelectInt(-1, "//*[@id='id_lead_clinician']");
		}else{
			System.out.print("Lead Clinician Box is Not Present On The Page\n");
		}
		
		RS.RandomSelectInt(-1, "//*[@id='id_priority']");
		RS.RandomSelectInt(-1, "//*[@id='id_status']");
		driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(Functions.generateRandomWords(120));
		NodeButtons();
	}
	

		
	public static void NodeButtons(){
		driver.findElement(By.id("reset_note")).click();
	    driver.findElement(By.id("button-0")).click();
	    driver.findElement(By.xpath("//*[@id='id_notes']")).sendKeys(Functions.generateRandomWords(120));
		driver.findElement(By.xpath("//*[@id='add-note']")).click();
		driver.findElement(By.xpath("//*[@id='button-0']")).click();
		driver.findElement(By.xpath("//button[@value='update']")).click();
	    driver.findElement(By.id("button-0")).click();
	  
	}

}
