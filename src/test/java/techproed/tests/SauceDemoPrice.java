package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.SauceDemoHomePage;
import techproed.pages.SauceDemoProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import static org.testng.Assert.assertEquals;

public class SauceDemoPrice {

/*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  Then
    Assert that total price of all products is 129.94 dollars
  And
    Flash each web element you used   ==> in our homePage we have flash(WebElement element) which changes the color and get it back
   */

@Test(groups = "smoke-test")
    public void totalPrice (){ // Test method

//    Go to  https://www.saucedemo.com/
    Driver.getDriver().get(ConfigReader.getProperty("sauce_demo_url"));

//        Enter the username  as "standard_user"
    SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
    JSUtils.flash(sauceDemoHomePage.usernameInput);
    sauceDemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("sauce_demo_username"));

//        Enter the password as "secret_sauce"
    JSUtils.flash(sauceDemoHomePage.passwordInput);
    sauceDemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("sauce_demo_password"));

//        Click on login button
    JSUtils.flash(sauceDemoHomePage.loginButton); // for flash the icon
    sauceDemoHomePage.loginButton.click();

//        Assert that total price of all products is 129.94 dollars
    double sum = 0;
    SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage();
    for (WebElement w : sauceDemoProductPage.pricesList){
        JSUtils.flash(w); // for flash
        sum += Double.valueOf(w.getText().replaceAll("\\$",""));

    }

    assertEquals(129.4,sum);
//    9
//        Flash each web element you used



}




}
