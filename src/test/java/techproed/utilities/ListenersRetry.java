package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {


    @Override
    public boolean retry(ITestResult iTestResult) {
        return false;
    }
}
