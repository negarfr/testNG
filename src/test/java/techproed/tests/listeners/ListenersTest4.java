package techproed.tests.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class ListenersTest4<retryAnalyzer> {


    @Test (retryAnalyzer = techproed.utilities.ListernersRetry.class)
        public void test1(){
        Driver.getDriver().get("https://techproeducation.com/");
        Assert.assertTrue(false);
    }


}
