package step_def;

import Utilitis.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EtsyPage;

public class EtsySteps {
    EtsyPage etsyPage= new EtsyPage();
    @Given("I am on etsy homepage")
    public void i_am_on_etsy_homepage() {
        Driver.getDriver().get("http://www.etsy.com");

    }

    @When("I search for book")
    public void i_search_for_book() {
        etsyPage.searchBar.sendKeys("book");


    }
    @When("I click on search box")
    public void i_click_on_search_box() {
        etsyPage.searchBtn.click();

    }
    //@Then("I see the title contains book")
   // public void i_see_the_title_contains_book() {
       // String expectedTitle="Book - Etsy";
       // String actualTitle=Driver.getDriver().getTitle();

       // Assert.assertTrue(actualTitle.contains(expectedTitle));



}
