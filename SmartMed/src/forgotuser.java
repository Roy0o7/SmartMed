import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class forgotuser extends LoginPage{
	public static void forgotusername(String s){
		
		WebElement element = driver.findElement(By.xpath("//*[@id='login-content']/div/a[1]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id='id_email']"));
		element.sendKeys(s);
		
		element = driver.findElement(By.xpath("//*[@id='reset-form']/div[2]/div[2]/button"));
		element.click();
	}
}
