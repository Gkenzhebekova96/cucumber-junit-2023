package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersSBPage {
    public WebOrdersSBPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".login_info")
    public WebElement loginWelcomeMsg;

    @FindBy(xpath = "//a[.='Order']")
    public WebElement getOrdersTab;

    @FindBy(xpath = "//select[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")
    public WebElement getProductDropdown;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")
    public WebElement quantity;
    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")
    public WebElement name;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")
    public WebElement Street;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")
    public WebElement City;
    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")
    public WebElement State;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]")
    public WebElement VisaRadioBtn;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")
    public WebElement CardNumber;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")
    public WebElement ExpiryDate;

    @FindBy(xpath = "//a[@class=\"btn_light\"]")
    public WebElement processBtn;








}
