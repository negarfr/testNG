package techproed.tests.smoketests.reservationtest;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Day19_ReservationTest {
    /*
    Name:
    User should be able to reserve a car
    Description:
    User should be able to reserve a car as customer service profile
    Acceptance Criteria:
    Given user is on the home page
    And select a car
    And enter pick up field
    And enter drop off field
    And click continue reservation
    And verify complete reservation screen pops up
    And enter card number
    And enter name on the card
    And enter expire date and CVC
    And checks the agreement
    And click complete reservation
    Then verify ‘Reservation created successfully’ pop up
    And naviaged to Reservations screen
    And verify the last reservation is created
    When you click on the last reservation
    Then verify reservation detail page is displayed
    And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
    And click on back to reservations
    And verify Reservations page is displayed
    And click on Home link
    Then verify the home page is displayed

  */
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;
    @Test(groups = "minor-regression-group")
    public void US100208_Negative_Login() throws IOException {



//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);


        try {

            homePage.userID.click();
            homePage.logoutLink.click();
            homePage.OK.click();

        }catch (Exception e){

        }


        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        loginPage.userName.sendKeys("fake@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
    }

    @Test
    public void invalidCredsTest() throws IOException {
//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        faker=new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.userName.sendKeys(fakeEmail);
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys(faker.internet().password(4,6));//fake pass 4-6 digit
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email "+fakeEmail+" not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();
    }
}
