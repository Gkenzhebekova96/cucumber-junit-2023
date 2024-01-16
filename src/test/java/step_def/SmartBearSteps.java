package step_def;

import Utilitis.Config;
import Utilitis.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.SmartBearPage;
import pages.WebOrdersSBPage;

public class SmartBearSteps {
    WebOrdersSBPage webOrdersSBPage=new WebOrdersSBPage();
    SmartBearPage smartBearPage = new SmartBearPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
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






    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        smartBearPage.userName.sendKeys(Config.getProperty("userName"));
        smartBearPage.password.sendKeys(Config.getProperty("pass"));
        smartBearPage.loginBtn.click();
        webOrdersSBPage.getOrdersTab.click();


    }
    @Given("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String productType) {
        Select product = new Select(webOrdersSBPage.getProductDropdown);
        product.selectByVisibleText(productType);


    }
    @Given("User enters {string} to quantity input box")
    public void user_enters_to_quantity_input_box(String quantityNum) {
        webOrdersSBPage.quantity.sendKeys(quantityNum);

    }
    @Given("User enters {string} to costumer name input box")
    public void user_enters_to_costumer_name_input_box(String name) {
        webOrdersSBPage.name.sendKeys(name);

    }
    @Given("User enters {string} to street name input box")
    public void user_enters_to_street_name_input_box(String streetName) {
        webOrdersSBPage.Street.sendKeys(streetName);

    }
    @Given("User enters {string} to city input box")
    public void user_enters_to_city_input_box(String cityName) {
        webOrdersSBPage.City.sendKeys(cityName);

    }
    @Given("User enters {string} to state input box")
    public void user_enters_to_state_input_box(String stateName) {
        webOrdersSBPage.State.sendKeys(stateName);

    }
    @Given("User enters {string} to zip input box")
    public void user_enters_to_zip_input_box(String zipCode) {
        webOrdersSBPage.zipCode.sendKeys(zipCode);

    }
    @Given("User selects {string} as card type from radio buttons")
    public void user_selects_as_card_type_from_radio_buttons(String carType) {
        webOrdersSBPage.VisaRadioBtn.click();

    }
    @Given("User enters {string} to card number input box")
    public void user_enters_to_card_number_input_box(String cardNum) {
        webOrdersSBPage.CardNumber.sendKeys(cardNum);

    }
    @Given("User enters {string} to expiration date into input box")
    public void user_enters_to_expiration_date_into_input_box(String expiryDate) {
        webOrdersSBPage.ExpiryDate.sendKeys(expiryDate);

    }
    @Given("User clicks process button")
    public void user_clicks_process_button() {
        webOrdersSBPage.processBtn.click();

    }
    //@Then("User verifies {string} is in the table")
   // public void user_verifies_is_in_the_table(String string) {









}
