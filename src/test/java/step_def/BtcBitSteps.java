package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(Config.getProperty("urlBctBit"));
    }
    @When("user should able to click the {string}")
    public void user_should_able_to_click_the(String string) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"header_links__Q5ogU\"]//a[1]")));
        driver.executeScript("window.scrollBy(0, 1000)");
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
    @Then("user should ba able to land on profile page")
    public void user_should_ba_able_to_land_on_profile_page(){
        String expectedURL = "https://btcbit.net/profile/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        if (actualURL.equals(expectedURL)){
            System.out.println("URL Redirection successful");
        }else {
            System.out.println("URL Redirection is failed");
        }
    }







    @When("user should be able to click Login button")
    public void user_should_be_able_to_click_login_button() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"header_links__Q5ogU\"]//a[2]")));
        //driver.executeScript("window.scrollBy(0, 1000)");
        btcBitPage.LoginBtn.click();

    }

    @When("user should be able to input email address")
    public void user_should_be_able_to_input_email_address() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"email\"]")));
        btcBitPage.emailBtn.sendKeys("magicsagic2022@gmail.com");

    }
    @When("user should be able to input password")
    public void user_should_be_able_to_input_password() {
        btcBitPage.passwordBtn.sendKeys("Auhet@2302");

    }
    @When("user should be able to click Sign in button")
    public void user_should_be_able_to_click_sign_in_button()  {
        btcBitPage.SignInBtn.click();


    }
    @Then("user should land on user profile page")
    public void user_should_land_on_user_profile_page() {

        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.urlToBe(expectedURL));

        String expectedURL = "https://btcbit.net/profile/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        if (actualURL.equals(expectedURL)){
            System.out.println("URL Redirection successful");
        }else {
            System.out.println("URL Redirection is failed");
        }

    }

    @When("user should input incorrect email address")
    public void user_should_input_incorrect_email_address() {
        btcBitPage.emailBtn.sendKeys("Huratojapan@gmail.com");

    }
    @When("user should input incorrect password")
    public void user_should_input_incorrect_password() {
        btcBitPage.passwordBtn.sendKeys("Bishkek2025");

    }
    @When("user should be able to click Sing in button")
    public void user_should_be_able_to_click_sing_in_button() {
        btcBitPage.SignInBtn.click();

    }
    @Then("user should see the error message displayed on the page")
    public void user_should_see_the_error_message_displayed_on_the_page() {
        Assert.assertTrue(btcBitPage.ErrorMessage.isDisplayed());

    }



    @Then("user  should see the phone number displayed correctly")
    public void user_should_see_the_phone_number_displayed_correctly() {

        Assert.assertTrue(btcBitPage.contactNumber.isDisplayed());
    }
    @Then("user  should see the email address displayed correctly")
    public void user_should_see_the_email_address_displayed_correctly() {
        ;
    }
    @Then("user should see the address displayed correctly")
    public void user_should_see_the_address_displayed_correctly() {

    }
    @Then("user  should see the email link working")
    public void user_should_see_the_email_link_working() {

    }
    @Then("user  should see the map link working")
    public void user_should_see_the_map_link_working() {

    }



}




