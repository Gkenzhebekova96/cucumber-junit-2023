package Utilitis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver implements JavascriptExecutor {
    private static WebDriver driver;

    public Driver() {

    }


    //private static WebDriver driver;



    public static WebDriver getReference(){
        return driver;
    }




    public static WebDriver getDriver() {

        if (driver == null) {
            switch (Config.getProperty("mozilla")) {
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }

                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }

            }
            driver.manage().window().maximize();






            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
          //  Faker faker=new Faker();


        }

        return driver;
    }

    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;

        }

    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script,args);
    }

   @Override
    public Object executeAsyncScript(String script, Object... args) {
       return ((JavascriptExecutor) driver).executeScript(script,args);
    }
}
