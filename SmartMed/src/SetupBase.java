import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupBase{
        static WebDriver driver;

        @Before
        public static void openFirefox() throws IOException {        

            driver = new FirefoxDriver();
            String baseUrl = "http://portal.mhealthcaresolutions.co.uk/users/login/";
            driver.manage().window().maximize();
            driver.get(baseUrl);  
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            LoginPage.Login("thawn", "thawn009");
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            
            //forgotuser.forgotusername("toufiq@gmail.com");
            //forgotpass.forgotpassword("toufiq@gmail.com");
            //Patients.Manage();
    		//Logout.logout("toufiq","Logout");
            
            //Filter.filter();
    		//Filter.CarePathways();
    		//Filter.MyPatient();
    		//Filter.AllPatient();
    		//Filter.MA();
    		//Filter.MAL();
            
    		//TestHome.Node();
            //TestHome.DashBoard();
            
    		//SendMessage.toUsers("messages/create/?to=user",1);
    		//SendMessage.toPatients();
    		//SendMessage.toHealthWorkers();
    		
            HW.Manage();          
        }       

        @After
        public void closeFirefox(){
            driver.quit();
        }
}   