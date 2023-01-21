package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class XYZBankManagerPage {

    public XYZBankManagerPage() {

        PageFactory.initElements(Driver.getDriver(),this); // Create Constructor
    }
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeInput;

    @FindBy(xpath = "//button[. ='Add Customer']")
    public WebElement addcutomerSubmitButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement openAccountButton;

    @FindBy(id = "userSelect")
    public WebElement customerDropDown;

    @FindBy(id = "currency")
    public WebElement currencyDropDown;

    @FindBy(xpath = "//button[.='Process']")
    public WebElement processSubmitButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement cutomersButton;
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement > numberOfRows;

    @FindBy(xpath = "//button[. ='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//button[.='Delete']")
    public List<WebElement> deleteButtons;




}
