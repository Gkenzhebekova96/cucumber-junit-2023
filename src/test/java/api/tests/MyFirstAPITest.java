package api.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.devtools.v108.fetch.model.AuthChallengeResponse;

public class MyFirstAPITest {
    // 1. Hitting an endpoint or hit the api
    //2. What type of request it will be (get,post,delete),
    // auth,headers,url(endpoint),params,request body,response body
    /*@Test
    public void getListOfTheBooks(){
       Response response=RestAssured.get("https://simple-books-api.glitch.me/books");
        //System.out.println(response.asString());
        //System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());
        JsonPath jsonPath=response.jsonPath();
        String str = jsonPath.get("[1].name").toString();
        System.out.println(str);*/
    @Test
    public void getListOfBook(){
       Response response = RestAssured.get("https://simple-books-api.glitch.me/books");
        //System.out.println(response.asString());
       // System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        String str = jsonPath.get("[1].name");
        System.out.println(str);
        int size = jsonPath.getList("").size();

        for (int i =0; i<size; i++){
            String names = jsonPath.get("["+ i +"].name");
            System.out.println(names);

        }


    }



   /*
    //authorization
    @Test
    public void getAllOrders(){
        Response response=RestAssured.given()
                .header("Authorization","Bearer 5421be0fc4ba419f31085838e0f9dcdca36ff3ba586d72ef57aae928af25ff42")
                .get("https://simple-books-api.glitch.me/orders");
        System.out.println(response.statusCode());
    }

    @Test
    public void airtableAuth(){
        Response response = RestAssured.given()
                .header("Authorization","Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .urlEncodingEnabled(false)
                .get("https://api.airtable.com/v0/appNPDRE8H2Nl0HBL/Table%201");
        System.out.println(response.statusCode());

    }*/





}
