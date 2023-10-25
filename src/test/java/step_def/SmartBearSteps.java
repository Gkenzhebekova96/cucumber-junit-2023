package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SmartBearPage;
import pages.WebOrdersSBPage;

public class SmartBearSteps {
    WebOrdersSBPage webOrdersSBPage=new WebOrdersSBPage();
    SmartBearPage smartBearPage = new SmartBearPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
    @When("user should be able to login")
    public void user_should_be_able_to_login() {

        smartBearPage.userName.sendKeys(Config.getProperty("userName"));

        smartBearPage.password.sendKeys(Config.getProperty("pass"));

    }

    @When("user should able to click login")
    public void user_should_able_to_click_login() {
        smartBearPage.loginBtn.click();

    }
    @Then("User should be logged in and be able to verify Welcome text is displayed")
    public void user_should_be_logged_in_and_be_able_to_verify_welcome_text_is_displayed() {
        Assert.assertTrue(webOrdersSBPage.loginWelcomeMsg.isDisplayed());
    }






}
