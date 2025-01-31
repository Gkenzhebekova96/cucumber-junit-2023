package step_def;

import Utilitis.APIUtil;
import Utilitis.Config;
import Utilitis.Driver;
import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AirTableBasePage;
import pages.AirTableLoginPage;

import java.util.ArrayList;
import java.util.List;

public class AirTableSteps {
    Faker faker = new Faker();

    String resource = "/Table%201";
    //String resource1 = "/Table%201/:recTGVi5LnWeWsBXK";
    String recordID;
    @When("use call a GET endpoint")
    public void use_call_a_get_endpoint() {
        APIUtil.hitGet(resource);

    }
    @Then("user will receive status {string}")
    public void user_will_receive_status(String statusCode) {
        //String strParse = Integer.toString(APIUtil.getResponse().statusCode());
        String str = String.valueOf(APIUtil.getResponse().statusCode());
        Assert.assertEquals(statusCode,str);

    }



    @When("user call a GET single endpoint")
    public void user_call_a_get_single_endpoint() {
        APIUtil.hitGet(resource+ "/rec4CU918VKIkwsh0");

    }


    @And("user verify the first name")
    public void userVerifyTheFirstName() {
        // Roel
        String actualName =APIUtil.getResponseBody().getFields().getFirstName();
        Assert.assertEquals(actualName,"Roel");
    }

    @When("a user creates a record")
    public void aUserCreatesARecord() {

        String firsName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fakeEmail= faker.internet().emailAddress();// make dynamic email
        int index = fakeEmail.indexOf("@");
        String emailProvider= fakeEmail.substring(index);



        MyFields field = new MyFields();
        field.setAge(faker.number().numberBetween(16,30));
        field.setFirstName(firsName);
        field.setLastName(lastName);
        field.setEmail(firsName+"."+lastName+emailProvider);
        field.setStudent(faker.random().nextBoolean());
        field.setAddress(faker.address().streetAddress());

       Record record= new Record();
       record.setFields(field);

        List <Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPost(resource,requestBody);

}

    @When("a user is saving the recordID")
    public void aUserIsSavingTheRecordID() {
        recordID=APIUtil.getResponseBody().getRecords().get(0).getId();
    }

    @And("a user updates email")
    public void aUserUpdatesEmail() {
        MyFields fields = new MyFields();
        fields.setEmail(faker.internet().emailAddress());

        Record record = new Record();
        record.setFields(fields);
        record.setId(recordID);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPatch(resource,requestBody);


    }

    @When("user delete the recordID")
    public void userDeleteTheRecordID() {
        APIUtil.hitDelete(resource,recordID);

    }

    @When("a user tries to create a record with invalid payload")
    public void aUserTriesToCreateARecordWithInvalidPayload() {
        RequestBody requestBody = new RequestBody();
        APIUtil.hitPost(resource,requestBody);
    }




    @Then("user will receive status: {int}")
    public void userWillReceiveStatus(int statusCode) {
        Assert.assertEquals(statusCode,APIUtil.getResponse().statusCode());
    }





    @Given("user is logs in the airtable account")
    public void user_is_logs_in_the_airtable_account() throws InterruptedException {
        AirTableLoginPage airTableLoginPage=new AirTableLoginPage();

        Driver.getDriver().get(Config.getProperty("loginPageATable"));


        airTableLoginPage.EmailField.sendKeys(Config.getProperty("loginEmailAirTable"));
        airTableLoginPage.submitBTN.click();

        airTableLoginPage.passwordField.sendKeys(Config.getProperty("passwordAirtable"));

        airTableLoginPage.signInField.click();



    }
    @When("user selects a base")
    public void userSelectsABase() {
        AirTableBasePage airTableBasePage=new AirTableBasePage();
        airTableBasePage.baseBtn.click();
    }
    @When("adds a new record")
    public void adds_a_new_record() {
        AirTableBasePage airTableBasePage = new AirTableBasePage();
        airTableBasePage.cellRowZeroCoordinates.clear();
        airTableBasePage.cellRowZeroCoordinates.sendKeys("Gulzhamal");

    }
    @Then("will verify record was saved, using api call")
    public void will_verify_record_was_saved_using_api_call() {
        APIUtil.hitGet(resource);
        String actualName=APIUtil
                .getResponseBody()
                .getRecords().get(0)
                .getFields()
                .getFirstName();
        Assert.assertEquals(actualName,"Gulzhamal");

    }



}
