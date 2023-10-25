package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//This line will force this class to run with Cucumber
@CucumberOptions(
        features ="src/test/resources/features",
        glue ="step_def",
        tags ="@smartBearNegative",
        dryRun=false
)

public class CukesRunner {
}
