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
            LoginPage.Login();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            
            //forgotuser.forgotusername();
            //forgotpass.forgotpassword();
            
        }       

        @After
        public void closeFirefox(){
            driver.quit();
        }
}   