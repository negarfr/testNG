package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class XYZBankHomepage {  // create homepage class for XYZBANK

    public XYZBankHomepage() {  // Create Constructor

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Bank Manager Login']")
     public WebElement bankManagerLoginButton;  // we make access modifier public so we can access from another class

    @FindBy(xpath = "//button[.='Customer Login']")
    public WebElement customerLoginButton;

    

}
