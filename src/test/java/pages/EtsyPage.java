package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {
    public EtsyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#global-enhancements-search-query")
    public WebElement searchBar;


    @FindBy(xpath = "//button[@data-id=\"gnav-search-submit-button\"]")
    public WebElement searchBtn;
}
