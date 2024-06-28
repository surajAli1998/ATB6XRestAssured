package com.apiautomation.testNG_day_25June2024.testNG_listeners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListener implements IExecutionListener, ISuiteListener {
    @Override
    public void onExecutionStart() {
        System.out.println("On Execution starts");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("On Execution finishes");
    }
}
