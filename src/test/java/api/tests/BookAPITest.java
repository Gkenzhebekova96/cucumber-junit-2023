package api.tests;

import Utilitis.Config;
import api.models.book.BookRecords;
import api.models.book.CreateOrder;
import api.models.book.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BookAPITest {



    @Test
            public void createJsonObject() throws JsonProcessingException {
        BookRecords records = new BookRecords();
        records.setId("myRendomID");
        records.setBookId(1);
        records.setCustomerName("Gul");
        records.setQuantity(10);

        ObjectMapper objectMapper = new ObjectMapper();// this is from jackson library
        String recordsJson=objectMapper.writeValueAsString(records);
        System.out.println(recordsJson);

    }

    @Test
    public void createOrder() throws JsonProcessingException {
        Order order =new Order();
        order.setBookId(1);
        order.setCustomerName("Charlotte");

        ObjectMapper objectMapper =new ObjectMapper();
        String createRecord=objectMapper.writeValueAsString(order);
        System.out.println(createRecord);

    }

    @Test
    public void postAnOrder() throws JsonProcessingException {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setBookId(1);
        createOrder.setCustomerName("Kake");

        ObjectMapper objectMapper = new ObjectMapper();

        String requestBody = objectMapper.writeValueAsString(createOrder);

        System.out.println(requestBody);
        Response response=RestAssured.given()
                .header("Authorization","Bearer pateb0GrCFayT8sW0.90caf36037c928131c8a405453a3fa141122d84416394e42063b8d0c576ef18b")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(Config.getProperty("baseUrl"));
        System.out.println(response.statusCode());
        System.out.println(response.asString());


    }



}
