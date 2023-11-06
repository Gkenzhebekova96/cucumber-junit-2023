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
    public WebElement



}
