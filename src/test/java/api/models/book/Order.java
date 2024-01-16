package api.models.book;

public class Order {
    //{
    //    "bookId": 1,
    //    "customerName": "John"
    //}

    int BookId;
    String customerName;

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        this.BookId = bookId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
