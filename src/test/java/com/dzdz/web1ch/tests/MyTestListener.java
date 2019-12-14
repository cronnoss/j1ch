package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.appmanager.ApplicationManager;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
        saveScreenshot(app.takeScreenshot());
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am in onStart method " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am in onFinish method " + context.getName());
    }
}
