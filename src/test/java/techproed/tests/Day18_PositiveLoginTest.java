package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

    //    Name: US100201_Admin_Login
//    Description:
//    User should be able login as admin
//    Acceptance Criteria:
//    As  admin, I  should be able to log in the application  https://www.bluerentalcars.com/
//    Admin email: john@doe.com
//    Admin password: John.123/

    ////==> first tye Test case
    /*
    Given
        https://www.bluerentalcars.com/
   When
        click on log in button
   And
        Type john@doe.com into email input
   And
        Type John.123 into password input
   And
        Click on login submit Button
  And
        Verify user log in
     */

    @Test
    public void US100201_Admin_Login(){

//        https://www.bluerentalcars.com
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        click on log in button
        HomePage homePage = new HomePage();
        homePage.HomePageloginButton.click();

//        Type john@doe.com into email input

        LoginPage loginPage = new LoginPage();

//        Type John.123 into password input
        loginPage.passwordInput.click();
        loginPage.emailInput.sendKeys("john@doe.com");
//        Click on login submit Button
        loginPage.passwordInput.sendKeys("John.123");
//        Verify user log in

        //        assertTrue(homePage.usernameDropDown.isDisplayed());
        ReusableMethods.verifyElementDisplayed(homePage.usernameDropDown);//Recommended

        Driver.closeDriver();

    }


}
