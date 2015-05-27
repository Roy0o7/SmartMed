import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends SetupBase{

	public static void Login() throws IOException{
		WebElement element = driver.findElement(By.xpath("//*[@id='id_username']"));
		element.sendKeys("toufiq");
		
		element = driver.findElement(By.xpath("//*[@id='id_password']"));
		element.sendKeys("toufiq123456");
		
		element = driver.findElement(By.xpath("//*[@id='login-form']/div[3]/input"));
		element.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Patients.Manage();
		//FilterPatient.filter();
		//FilterPatient.CarePathways();
		//Logout.logout();
		//TestHome.Home();
		//Filter.MyPatient();
		Filter.AllPatient();
		//FilterPatient.MA();
		//FilterPatient.MAL();
	}

	
}
