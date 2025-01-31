package Utilitis;

import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtil {
    //CRUD operation
    // GET, POST,PATCH,DELETE
    private static   Response response;
    private static ResponseBody responseBody;
    public static ResponseBody getResponseBody(){
        return responseBody;
    }
    public static Response getResponse(){
        return response;

    }

    String recordID;

    public static void hitGet(String recourse){
        String uri=Config.getProperty("host")+recourse;

        response=RestAssured.given()
                .header("Authorization","Bearer "+ Config.getProperty("apiKey"))
                .urlEncodingEnabled(false)
                .get(uri);
        System.out.println(response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            responseBody =objectMapper.readValue(response.asString(),ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public static void hitPost(String resource, RequestBody body){
        String uri=Config.getProperty("host")+resource;

        ObjectMapper objectMapper=new ObjectMapper();

        String bodyJson= "";
        try {
            bodyJson=objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        response= RestAssured.given()
                .header("Authorization","Bearer "+ Config.getProperty("apiKey"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .post(uri);
        System.out.println(response.statusCode());
        try {
            responseBody=objectMapper.readValue(response.asString(),ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
    public static void hitPatch(String resource, RequestBody body){
        String uri=Config.getProperty("host")+resource;

        ObjectMapper objectMapper=new ObjectMapper();

        String bodyJson= "";
        try {
            bodyJson=objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        response= RestAssured.given()
                .header("Authorization","Bearer "+ Config.getProperty("apiKey"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .patch(uri);
        System.out.println(response.statusCode());
        try {
            responseBody=objectMapper.readValue(response.asString(),ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
    public static void hitDelete(String resource,String recordId){
        String uri=Config.getProperty("host")+resource;
        response= RestAssured.given()
                .header("Authorization","Bearer "+ Config.getProperty("apiKey"))
                .urlEncodingEnabled(false)
                .queryParam("records[]",recordId)
                .delete(uri);
        System.out.println(response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            responseBody=objectMapper.readValue(response.asString(),ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
