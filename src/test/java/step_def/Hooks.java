package step_def;

import Utilitis.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before// cucumber annotation and not Junit
    public void setUp(){
        System.out.println("The scenario is running ");
        // example login

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed() && Driver.getReference()!=null){
            byte[]screenshot=((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.quitDriver();

    }
}
