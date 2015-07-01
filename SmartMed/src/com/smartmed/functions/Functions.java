package com.smartmed.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Functions {
	public static WebDriver driver;
	public Functions(WebDriver driver){
		Functions.driver = driver;
	}
	

public void RandomSelectInt(int i, String s) {
	// TODO Auto-generated method stub
	if(i == -1){
		WebElement drpDwnList = driver.findElement(By.xpath(s));
		Select objSel = new Select(drpDwnList);
		List <WebElement> weblist = objSel.getOptions();
		int iCnt = weblist.size();
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);
		objSel.selectByIndex(iSelect);
		System.out.println(drpDwnList.getAttribute("value"));
			
		
	}else{	
	List<WebElement> options = driver.findElements(By.xpath(s));
		for(int j=0;j<options.size();j++){
		    System.out.println(options.get(j).getText());
		   	Select select = new Select(driver.findElement(By.xpath(s)));
		   	select.selectByIndex(i);
		   	options.get(j).click();
	    }
	}
			
	
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
	
public static String generateRandomWords(int numberOfWords){
	String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
	int n = alphabet.length(); 

	String result = new String(); 
	Random r = new Random(); 

	for (int i=0; i<numberOfWords; i++) 
	    result = result + alphabet.charAt(r.nextInt(n)); 

	return result;
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


}
