import org.openqa.selenium.By;


public class Logout extends LoginPage{
	public static void logout(){
		
		driver.findElement(By.linkText("toufiq")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    
		
	}
}
