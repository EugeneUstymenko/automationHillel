package lisenens;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST IS PASSED" + result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST IS FAILED" + result.getMethod());
    }

}
