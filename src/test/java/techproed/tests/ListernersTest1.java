package techproed.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import static org.testng.Assert.assertTrue;

@Listeners(techproed.utilities.Listerners.class) // path of the listeners in our package

/*
USE @Listeners annotation to connect test classes and listeners
techproed.utilities.Listeners.class ==> path of listeners utility
 */

public class ListernersTest1 {

    @Test
    public void test1(){

        System.out.println("Test case 1 PASS");
        assertTrue(true); // PASS
    }

    @Test
    public void test2(){

        System.out.println("Test case 2 FAIL");
        assertTrue(false); // FAIL
    }

    @Test
    public void test3(){
        System.out.println("Test case 3 SKIPPED");
        throw new SkipException("SKIP THIS TEST CASE");

    }
    @Test
    public void test4(){
        System.out.println("Test case 4 NO SUCH ELEMENT EXCEPTION");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.id("abdc")); // NO SUCH ELEMENT EXCEPTION
    }

}
