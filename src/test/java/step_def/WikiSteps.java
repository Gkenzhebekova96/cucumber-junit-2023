package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WikiPages;

public class WikiSteps {
    WikiPages wikiPages = new WikiPages();
   String name = "Steve Jobs";
    @Given("user click on wikipedia page")
    public void user_click_on_wikipedia_page() {
        Driver.getDriver().get(Config.getProperty("wikiURL"));
    }
    @When("User type Steve Jobs in the wiki search box")
    public void user_type_steve_jobs_in_the_wiki_search_box() {
        wikiPages.searchInput.sendKeys("Steve Jobs");

    }
    @When("User click search button")
    public void user_click_search_button() {
        wikiPages.submitBtn.click();
    }
    @Then("User see Steve Jobs in the wiki page title")
    public void user_see_steve_jobs_in_the_wiki_page_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(name));

    }

    @Then("User see Steve Jobs in the main header")
    public void user_see_steve_jobs_in_the_main_header() {
        Assert.assertEquals(wikiPages.getTextHeader.getText(),name);
    }

    @Then("User see Steve Jobs in the image header")
    public void user_see_steve_jobs_in_the_image_header() {
        Assert.assertEquals(wikiPages.getHeaderForImage.getText(),name);

    }

    @When("User type {string} in the wiki search box")
    public void user_type_in_the_wiki_search_box(String name) {
        wikiPages.searchInput.sendKeys(name);

    }
    @Then("User see {string} in the wiki page title")
    public void user_see_in_the_wiki_page_title(String name) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(name));

    }

}
