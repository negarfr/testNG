package tests;

import Utilities.Driver;
import org.testng.annotations.Test;

public class Day17_FirstDriverTest {


    @Test
    public void firstDriverTest(){
//        driver  ->  Driver.getDriver()
        Driver.getDriver().get("https://www.techproeducation.com");

//        close the driver
        Driver.closeDriver();
    }




}
