package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestLoginPage {

    public TestLoginPage (){
//        Used to initiate the page objects
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement usernameInput;

    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;



}
