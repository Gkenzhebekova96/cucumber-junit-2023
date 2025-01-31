package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirTableBasePage {
    public AirTableBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[.=\"API TEST\"]/../..")
    public WebElement baseBtn;

    @FindBy(xpath = "//div[@data-testid=\"gridCell-0:0\"]")
    public WebElement cellRowZeroCoordinates;



}
