package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BtcBitPage {
    public BtcBitPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//div[@class=\"header_links__Q5ogU\"]//a[1]")
    public WebElement getStartedBtn;
    @FindBy (xpath = "//input[@id=\"email\"]")
    public WebElement emailBtn;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement passwordBtn;

    @FindBy (xpath = "//input[@id=\"confirmPassword\"]")
    public WebElement confirmPasswordBtn;

    @FindBy (xpath = "//label[@for=\"agreements\"]//span[1]")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement SignUpBtn;



    //-----------------------------------------------

    @FindBy (xpath = "//div[@class=\"header_links__Q5ogU\"]//a[2]")
    public WebElement LoginBtn;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement SignInBtn;

    @FindBy (xpath = "//*[contains(text(),'Invalid email or password')]")
    public WebElement ErrorMessage;



    @FindBy (xpath = "//*[contains(text(),'+9710555513258')]")
    public WebElement contactNumber;




    @FindBy (xpath = "")
    public WebElement

    @FindBy (xpath = "")
    public WebElement

    @FindBy (xpath = "")
    public WebElement













}
