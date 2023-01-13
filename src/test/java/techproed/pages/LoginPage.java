package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement emailInput;

    @FindBy(id = "formBasicPassword")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginSubmitButton;

}