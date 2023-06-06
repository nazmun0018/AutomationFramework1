package BasePackage;

import UtilityPackage.Utilis;
import com.google.j2objc.annotations.Property;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public static Logger loger;


    public BaseClass(){
        try {
            prop=new Properties();

            FileInputStream fis= new FileInputStream("/Users/Nazmun0018/IdeaProjects/AutomationFramework1/src/main/java/ConfigPackage/Config.Properties");

            prop.load(fis);
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Initialization(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));


        loger= Logger.getLogger("Automation Framework1");
        PropertyConfigurator.configure("/Users/Nazmun0018/IdeaProjects/AutomationFramework1/src/main/resources/Log4j.Properties");

       // driver.manage().timeouts().pageLoadTimeout(Utilis.Page_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(Utilis.IMPLICIT_WAIT,TimeUnit.SECONDS);
    }
}
