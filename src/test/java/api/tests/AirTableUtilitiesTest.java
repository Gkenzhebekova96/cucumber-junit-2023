package api.tests;

import Utilitis.APIUtil;
import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AirTableUtilitiesTest {
    public static String myRecord;
    @Test()
    public void testZGetMethod(){
        String resource="/Table%201";
        APIUtil.hitGet(resource);
    }
    @Test
    public void testCPostMethod(){
        Faker faker=new Faker();
        String resource="/Table%201";

        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=firstName+lastName+"@gmail.com";

        MyFields fields=new MyFields();
        fields.setFirstName("Gul");
        fields.setLastName("Kenzhebekova");
        fields.setAddress("Defence Street 154");
        fields.setStudent(true);
        fields.setEmail("Gggkk@gmail.com");
        fields.setAge(27);

        Record record = new Record();
        record.setFields(fields);

        List <Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);
        APIUtil.hitPost(resource,requestBody);
        myRecord=APIUtil.getResponseBody().getRecords().get(0).getId();



    }
    @Test
    public void testZPatchMethod(){

        String resource="/Table%201";
        MyFields fields=new MyFields();
        fields.setFirstName("Gul");
        fields.setLastName("Kenzhebekova");
        fields.setAddress("Defence Street 154");
        fields.setStudent(true);
        fields.setEmail("Gggkk@gmail.com");
        fields.setAge(27);

        Record record = new Record();
        record.setFields(fields);
        record.setId(myRecord);

        List <Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);
        APIUtil.hitPatch(resource,requestBody);



    }
    @Test
    public void testADelete(){
        String resource="/Table%201";

        String recordToBEDeleted = myRecord;
        APIUtil.hitDelete(resource,recordToBEDeleted);
        System.out.println(APIUtil.getResponse().asString());

    }
}
