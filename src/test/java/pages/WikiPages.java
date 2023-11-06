package pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPages {
    public WikiPages(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//input[@id=\"searchInput\"]")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitBtn;

    @FindBy (xpath = "//h1[@id=\"firstHeading\"]")
    public WebElement getTextHeader;

    @FindBy(xpath = "//th[@class=\"infobox-above\"]/div")
    public WebElement getHeaderForImage;


}
