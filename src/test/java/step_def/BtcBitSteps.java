package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BtcBitPage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BtcBitSteps {
    Driver driver = new Driver();

   BtcBitPage btcBitPage = new BtcBitPage();
   Faker faker=new Faker();
   
       

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {

    Driver.getDriver().get(Config.getProperty("urlBctBit"));

    }
    @When("user should able to click the {string}")
    public void user_should_able_to_click_the(String string) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"header_links__Q5ogU\"]//a[1]")));
        //driver.executeScript("window.scrollBy(0, 1000)");
        btcBitPage.getStartedBtn.click();




    }

    @When("user should be able type the email")
    public void user_should_be_able_type_the_email() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"email\"]")));
        btcBitPage.emailBtn.sendKeys("gulzhamalkenzhebekova1@gmail.com");

    }
    @When("user should be able type the password")
    public void user_should_be_able_type_the_password() {
        btcBitPage.passwordBtn.sendKeys("Auhet@2303");

    }
    @When("user should be able confirm the password")
    public void user_should_be_able_confirm_the_password() {
        btcBitPage.confirmPasswordBtn.sendKeys("Auhet@2303");

    }
    @When("user should able to to tick to agreement term and condition of website checkbox")
    public void user_should_able_to_to_tick_to_agreement_term_and_condition_of_website_checkbox() throws InterruptedException {
        btcBitPage.checkBox.click();
        Thread.sleep(500);

    }

    @Then("user should able to click {string} button")
    public void user_should_able_to_click_button(String string) {
        btcBitPage.SignUpBtn.click();

    }



}




