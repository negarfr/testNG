package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listerners implements ITestListener {
    /*
    >> ITestListener is an interface
    >> we use this interface for customizing our testNG framework
    >> before all tests it will run with "onStart" and "onFinish" end them all
    >> onStart, onFinish, onTestStart, onTestFinish, onTestSuccess, onTestFail, are special method names are used to LISTEN the test methods.
    We especially use listeners for adding a special condition such as test pass, fail or skip.

     */
@Override
public void onStart(ITestContext context) {

    System.out.println("onStart - Execute ONCE before ALL test : "+context.getName());
}

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(" onFinish- Execute ONCE after ALL test : "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart- Execute ONCE before EACH @test : "+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Execute ONCE after EACH PASSED @Test: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - Execute ONCE after EACH FAILED @Test: " + result.getName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Execute ONCE after EACH SKIPPED @Test: " + result.getName());
    }

}
