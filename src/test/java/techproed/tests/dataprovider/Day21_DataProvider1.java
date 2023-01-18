package techproed.tests.dataprovider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
   >>>> WHAT IS DATA PROVIDER ?
   * Data Provide is used to get List of data
   * We can get data from external file such as excel or json files
   * Data Provider is an Annotation of TestNG- if we do not have TestNG framework we are not able to use it
   * We use Data Provider to get Data,such as Credentials from External files like Excel.

  >>>>> HOW DO WE GET DATA IN OUR TESTNG Framework?
   >> In our Data Provider method we use Data Provider Annotation
   >> And in test method, we add Data Provider method name or custom name inside Test annotation parameters

   >>>> Data Provider Has 2 parameters
   1- Name: It is used to give custom name for data provider
   2- Parallel : It is used for parallel testing

 */

public class Day21_DataProvider1 {

    @DataProvider(name = "my_smoke_test")

    public Object[][] customerData(){ // create method which has return us 2 dimenssional arraye

       Object [][] customerCredentials = { {"sam.walker@bluerentalcars.com", "c!fas_art"},
                                           {"kate.brown@bluerentalcars.com","tad1$Fas"},
                                           {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                                           {"pam.raymond@bluerentalcars.com","Nga^g6!"} };
        return customerCredentials;

}
    @Test(dataProvider = "my_smoke_test")

    public void dataProviderTest1 (String username, String password){

        System.out.println("customerData()[0][0] = " + customerData()[0][0]);

        System.out.println("Username:" +username + "<==> Password: " + password );


    }
///====== we can create 1 more test

    @Test(dataProvider = "my_smoke_test")
    public void dataProviderTest(String user, String pass){

        System.out.println("User: "+user+ "<==> Pass:" +pass);

    }












}
