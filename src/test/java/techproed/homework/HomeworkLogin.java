package techproed.homework;

import org.testng.annotations.Test;
import techproed.pages.TestHomePage;
import techproed.pages.TestLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertTrue;

public class HomeworkLogin {

    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    ////    Login the application by using page object model

  //  now we type our test in Gherkin
/*
Given
    Go to URL : https://testcenter.techproeducation.com/index.php?page=form-authentication
When
    Type "techproed" into username input
And
    Type SuperSecretPassword into password input
And
    click login button
Then
    Verify user singed in
 */
@Test
    public void loginTest() {

    //   Go to URL : https://testcenter.techproeducation.com/index.php?page=form-authentication
    Driver.getDriver().get(ConfigReader.getProperty("test_login_url"));

    //   Type "techproed" into username input
    TestLoginPage testLoginPage = new TestLoginPage();
    testLoginPage.usernameInput.sendKeys("techproed");

//    Type SuperSecretPassword into password input
    testLoginPage.passwordInput.sendKeys("SuperSecretPassword");

//    click submit button
    testLoginPage.submitButton.click();

//    Verify user singed in
    TestHomePage testHomePage = new TestHomePage();
 //   assertTrue(testHomePage.loginSuccessMessage.isDisplayed());

    ReusableMethods.verifyElementDisplayed(testHomePage.loginSuccessMessage);
    // ReusableMethods create this class in utilities and coppied all methods there
}

}
