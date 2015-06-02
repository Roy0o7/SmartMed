import org.openqa.selenium.By;


public class Logout extends LoginPage{
	public static void logout(String username, String Logout){
		
		driver.findElement(By.linkText(username)).click();
	    driver.findElement(By.linkText(Logout)).click();
	    
		
	}
}
