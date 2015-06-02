import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends SetupBase{

	public static void Login(String username, String password) throws IOException{
		WebElement element = driver.findElement(By.xpath("//*[@id='id_username']"));
		element.sendKeys(username);
		
		element = driver.findElement(By.xpath("//*[@id='id_password']"));
		element.sendKeys(password);
		
		element = driver.findElement(By.xpath("//*[@id='login-form']/div[3]/input"));
		element.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	
}
