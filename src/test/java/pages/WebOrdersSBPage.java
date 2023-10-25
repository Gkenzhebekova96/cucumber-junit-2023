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
}
