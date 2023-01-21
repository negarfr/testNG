package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.XYZBankCustomerPage;
import techproed.pages.XYZBankHomepage;
import techproed.pages.XYZBankManagerPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class XYZBankTest {

//===> User Story :
// Open 5 new Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.
//https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

//=============================================================================================================

  /* >>  FIRST: we do MANUAL TESTING to understand the whole feature of the application.
     >>    and THEN based on steps we do on website we write our TEST CASE as bellow :
Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Deposit"(Submit) button
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0
     */
    @Test(groups="smoke-test")
    public void xyzBankTest() {

//    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//// URL >> to be able to change the URL whenever we want, we should put it into the *configuration.properties* file, just put the name here
        Driver.getDriver().get(ConfigReader.getProperty("xyzBank_URL"));

//    Click on "Bank Manager Login" button
////   we need to create HOMEPAGE  ==check that page for all details
        XYZBankHomepage xyzBankHomepage = new XYZBankHomepage(); // create object to access HomePage with name constructor XYZBankHomepage()
        xyzBankHomepage.bankManagerLoginButton.click();

//    Click on "Add Customer" button  ==> create new page
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

//    Fill inputs and click on "Add Customer" submit button

       Faker faker = new Faker();  //we need to make sure we have Java Faker dependency to add fake customers to add

       for (int i=0; i<5; i++) {  //

           xyzBankManagerPage.firstNameInput.sendKeys(faker.name().firstName());
           xyzBankManagerPage.lastNameInput.sendKeys(faker.name().lastName());
           xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
           xyzBankManagerPage.addcutomerSubmitButton.click();

//    Accept alert
           try {    // to ignore the exception
               Driver.getDriver().switchTo().alert().accept();
           } catch (Exception ignored) {

           }
       }
//    Add 4 more customers ======= >for this we add Loop in tope so it will add 4 more fake Customer

//    Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

//    Click on "Customer" dropdown

        //    Select customer name
        Select select = new Select(xyzBankManagerPage.customerDropDown);
        Select select2 = new Select(xyzBankManagerPage.currencyDropDown);

        for (int i=6;  i<11; i++) {
            select.selectByIndex(i); //index 1

//    Click on "Currency" dropdown
//           Select "Dollar"
            //Select select2 = new Select(xyzBankManagerPage.currencyDropDown);
            select2.selectByIndex(1);

//    Click on "Process" button
            xyzBankManagerPage.processSubmitButton.click();
//    Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }

//    Open 4 more accounts  ===> Again we need to creat loop before Select Customer
         } 
//    Click on "Customers" button

        xyzBankManagerPage.cutomersButton.click();

//    Count table number of rows

       int numOfRows = xyzBankManagerPage.numberOfRows.size();

//    Assert that you created 5 customers
                  assertEquals(10,numOfRows);

//    Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//    Click on "Customer Login" button  == locate this one in homepage

        xyzBankHomepage.customerLoginButton.click();

//    Click on "Your Name" dropdown     == create new page CustomePage
//    Select any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();

        Select select3 = new Select( xyzBankCustomerPage.yourNameDropDown);// we handling this DropDwon by using select

        select3.selectByIndex(6);

//    Click on "Login" button
         xyzBankCustomerPage.loginButton.click();

//    Click on "Deposit" button

          xyzBankCustomerPage.depositButton.click();
//    Type 100 into "Amount to be Deposited" input

        xyzBankCustomerPage.amountToBeDepositedInput.sendKeys("100");
//    Click on "Deposit"(Submit) button

        xyzBankCustomerPage.depositSubmitButton.click();
//    Assert that "Deposit Successful" is displayed

        assertTrue(xyzBankCustomerPage.depositSuccessMessage.isDisplayed());

//    Click on "Withdrawal" button

        xyzBankCustomerPage.withdrawalButton.click();

//    Type 100 into "Amount to be Withdrawn" input
        xyzBankCustomerPage.amountToBeWithdrawnInput.sendKeys("100", Keys.ENTER);

//        Click on "Withdraw"(Submit) button
//        xyzBankCustomerPage.withdrawSubmitButton.click(); //==> Selenium Click is not working
//        Actions actions = new Actions(Driver.getDriver());
//        actions.click(xyzBankCustomerPage.withdrawSubmitButton).perform();

//    Assert that "Transaction  Successful" is displayed

         ReusableMethods.verifyElementDisplayed(xyzBankCustomerPage.transactionSuccessMessage);

//    Click on "Logout" button
            xyzBankCustomerPage.logOutButton.click();

//    Click on "Home" button

      xyzBankManagerPage.homeButton.click();

//    Click on "Bank Manager Login" button
        xyzBankHomepage.bankManagerLoginButton.click();

//    Click on "Customers" button
        xyzBankManagerPage.cutomersButton.click();


        //        Click on each "Delete" button
          for (WebElement w : xyzBankManagerPage.deleteButtons) {
                      w.click();
                  }

        //        Count table row numbers
                int numberOfRowsAfterDelete = xyzBankManagerPage.deleteButtons.size();

       //        Assert that number of customers is 0
              assertEquals(0, numberOfRowsAfterDelete);
        }
    }