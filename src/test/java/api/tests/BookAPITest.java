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
import org.apache.http.impl.conn.tsccm.RouteSpecificPool;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BookAPITest {


@Ignore

    @Test
            public void createJsonObject() throws JsonProcessingException {
        BookRecords records = new BookRecords();
       records.setId("myRandomID");
       records.setBookId(1);
       records.setCustomerName("Gul");
       records.setQuantity(10);

       ObjectMapper objectMapper = new ObjectMapper();// this is from jackson library
        String recordsJson=objectMapper.writeValueAsString(records);
        System.out.println(recordsJson);

    }

    /*@Test
    public void createOrder() throws JsonProcessingException {
        Order order =new Order();
        order.setBookId(1);
        order.setCustomerName("Charlotte");

        ObjectMapper objectMapper =new ObjectMapper();
        String createRecord=objectMapper.writeValueAsString(order);
        System.out.println(createRecord);

    }*/

    @Test
    public void createOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setBookId(1);
        order.setCustomerName("Askar");

        ObjectMapper objectMapper = new ObjectMapper();
       String createRecord=  objectMapper.writeValueAsString(order);
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

        Response response = RestAssured.given()
                .header("Authorization","Bearer d318e707cafb6404ba423dca318b009b3e5bcf0ff0abd33f2beaad3d25ac5b67")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://simple-books-api.glitch.me/orders");
        System.out.println(response.statusCode());
        System.out.println(response.asString());



}
}
