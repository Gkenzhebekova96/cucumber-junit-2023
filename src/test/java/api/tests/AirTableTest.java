package api.tests;

import Utilitis.Config;
import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class AirTableTest {
    String myRecordID;

    @Test
    public void getRecords() throws JsonProcessingException {
        Response response = RestAssured.given()
                .header("Authorization","Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .urlEncodingEnabled(false)
                .get(Config.getProperty("baseUrl"));
        System.out.println(response.statusCode());

        ObjectMapper obj =new ObjectMapper();
        obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ResponseBody rb = obj.readValue(response.asString(),ResponseBody.class);

       System.out.println(rb.getRecords().get(0).getFields().getFirstName());


      int size=rb.getRecords().size();

        for (int i = 0; i<size; i++){
            if (rb.getRecords().get(i).getFields().getFirstName().startsWith("A")){
                String firstName=rb.getRecords().get(i).getFields().getFirstName();
                String lastName=rb.getRecords().get(i).getFields().getLastName();
                String email=rb.getRecords().get(i).getFields().getEmail();
                boolean studentYes=rb.getRecords().get(i).getFields().isStudent();
                int age=rb.getRecords().get(i).getFields().getAge();

                System.out.println(firstName+" "+ lastName+" "+ email +" "+ studentYes+" "+ age);
            }
        }

//        for (Record element : rb.getRecords()){
//            if (element.getFields().getFirstName().charAt(0)=='A'){
//                System.out.println(element.getFields().getFirstName()
//                        +" " + element.getFields().getLastName()
//                        +" " + element.getFields().getEmail()
//                        +" " + element.getFields().isStudent()
//                        +" " + element.getFields().getAge());
//            }//*
//        }
    }



    @Test
    public void postRecord() throws JsonProcessingException {
        MyFields stRecord= new MyFields();

        stRecord.setFirstName("Andres");
        stRecord.setLastName("Nova");
        stRecord.setEmail("Gulmm@gmail.com");
        stRecord.setStudent(true);
        stRecord.setAddress("defence street 154");
        stRecord.setAge(25);

        Record record = new Record();
        record.setFields(stRecord);

        List<Record> records= new ArrayList<>();
        records.add(record);

        RequestBody requestBody=new RequestBody();
        requestBody.setRecords(records);

        ObjectMapper obj =new ObjectMapper();
        String jsonBody=obj.writeValueAsString(requestBody);

        System.out.println(jsonBody);

        Response response = RestAssured.given()
                .header("Authorization","Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .post("https://api.airtable.com/v0/appNPDRE8H2Nl0HBL/Table%201");
        System.out.println(response.statusCode());
        ResponseBody rb=obj.readValue(response.asString(),ResponseBody.class);
        myRecordID=rb.getRecords().get(0).getId();
        System.out.println(myRecordID);

    }


    @Test

    public void patchRecord() throws JsonProcessingException {

        MyFields studentUpdate = new MyFields();

        studentUpdate.setAddress("defence street 154");


        Record record = new Record();
        record.setFields(studentUpdate);
        record.setId(myRecordID);

         List<Record> records= new ArrayList<>();
         records.add(record);

         RequestBody requestBody= new RequestBody();
         requestBody.setRecords(records);

         ObjectMapper objectMapper = new ObjectMapper();
         String jsonValue=objectMapper.writeValueAsString(requestBody);
         System.out.println(jsonValue);

         Response response = RestAssured.given()
                .header("Authorization", "Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(jsonValue)
                .patch(Config.getProperty("baseUrl"));
        System.out.println(response.statusCode());




    }
    @Test
    public void deleteRecord(){
        String queryParam ="records[]";
        String recordID= myRecordID;
        Response response = RestAssured.given()
                .header("Authorization", "Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .urlEncodingEnabled(false)
                        .queryParam(queryParam,recordID)
                                .delete(Config.getProperty("baseUrl"));


        System.out.println(response.statusCode());


    }

}
