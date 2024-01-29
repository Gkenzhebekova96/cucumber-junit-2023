package api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@Data

public class MyFields {

    String firstName;
    String lastName;
    String email;
    boolean student;
    String address;
    int age;
}
