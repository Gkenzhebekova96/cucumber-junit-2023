package step_def;

import Utilitis.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;

public class GoogleSteps {

   GooglePage googlePage = new GooglePage();

    @Given("i am at google home page")
    public void i_am_at_google_home_page() {
        Driver.getDriver().get("http://www.google.com");

    }
    @Then("I verify yhe title is Google")
    public void i_verify_yhe_title_is_google() {
        String expectedTitle="Google";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @When("I search for sauceLabs")
    public void i_search_for_sauce_labs() {
        googlePage.searchBar.sendKeys("saucelabs",Keys.ENTER);

    }
   /* @Then("I verify yhe title is SauceLabs")
    public void i_verify_yhe_title_is_sauce_labs() {
        String expectedTitle="saucelabs";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }*/






}
