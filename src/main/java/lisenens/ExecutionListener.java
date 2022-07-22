package lisenens;

import org.testng.IExecutionListener;

//super precondition and postcondition
public class ExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onExecutionFinish() {
        IExecutionListener.super.onExecutionFinish();
    }
}
