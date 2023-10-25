package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearPage {
    public SmartBearPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_username\"]")
    public WebElement userName;
    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_password\"]")
    public WebElement password;

    @FindBy(xpath = "//input[@id=\"ctl00_MainContent_login_button\"]")
    public WebElement loginBtn;



    @FindBy(css = "#ctl00_MainContent_status")
    public WebElement errorText;


















}
