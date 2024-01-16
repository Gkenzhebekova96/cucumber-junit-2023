package api.models.book;

import lombok.Data;

@Data
public class CreateOrder {
    int BookId;
    String customerName;

}
