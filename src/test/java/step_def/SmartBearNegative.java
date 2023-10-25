package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SmartBearPage;

public class SmartBearNegative {
    SmartBearPage smartBearPage = new SmartBearPage();
    Faker faker=new Faker();


    @When("User is on SmartBear login page")
    public void user_is_on_smart_bear_login_page() {
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));

    }
    @When("User enters correct username")
    public void user_enters_correct_username() {
        smartBearPage.userName.sendKeys("Tester");

    }
    @When("User enters incorrect password")
    public void user_enters_incorrect_password() {
        smartBearPage.password.sendKeys(faker.internet().password());

    }
    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
        smartBearPage.loginBtn.click();

    }
    @Then("User should see the error message displayed on the page")
    public void user_should_see_the_error_message_displayed_on_the_page() {
        Assert.assertTrue(smartBearPage.errorText.isDisplayed());

    }



}
