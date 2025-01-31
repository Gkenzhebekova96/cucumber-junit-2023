package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirTableLoginPage {
    public AirTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@id=\"emailLogin\"]")
    public WebElement EmailField;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement submitBTN;
    @FindBy(css = "#passwordLogin")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement signInField;




}
